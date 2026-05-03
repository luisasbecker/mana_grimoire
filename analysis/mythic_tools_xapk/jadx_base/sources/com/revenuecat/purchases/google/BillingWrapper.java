package com.revenuecat.purchases.google;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.work.PeriodicWorkRequest;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.InAppMessageResponseListener;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.NoCoreLibraryDesugaringException;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.BillingClientUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCaseParams;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: BillingWrapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u009a\u0001\u009b\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J@\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020/0*H\u0000¢\u0006\u0002\b6J3\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020+082\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010>J=\u0010?\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020+082\u0006\u0010:\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020F0E2\u0006\u0010:\u001a\u00020GH\u0002J=\u0010H\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020+082\u0006\u0010:\u001a\u00020G2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010IJ(\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00122\u0006\u00102\u001a\u000203H\u0016J@\u0010O\u001a\u00020/2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020/0*H\u0000¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020/H\u0014J\b\u0010S\u001a\u00020/H\u0002J/\u0010T\u001a\u00020/2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010%2\u0014\u0010V\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020/0*H\u0002¢\u0006\u0002\u0010WJH\u0010X\u001a\u00020/2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001e2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020/0*2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*H\u0016J)\u0010^\u001a\u00020/2\u0006\u00105\u001a\u00020\u001e2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020/0*H\u0001¢\u0006\u0002\b`J\b\u0010a\u001a\u00020\u001eH\u0002J3\u0010b\u001a\u00020/2\u0006\u0010L\u001a\u00020c2!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110M¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020/0*H\u0002J4\u0010f\u001a\u00020/2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020/0*2\u0016\u0010]\u001a\u0012\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*j\u0002`hH\u0016J\b\u0010i\u001a\u00020\u0012H\u0016J\u0018\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u000209H\u0003JC\u0010n\u001a\u00020/2\u0006\u0010k\u001a\u00020l2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020p2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010q\u001a\u0004\u0018\u00010r2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010sJ\b\u0010t\u001a\u00020/H\u0016J\u0010\u0010u\u001a\u00020/2\u0006\u0010v\u001a\u00020wH\u0016J \u0010x\u001a\u00020/2\u0006\u0010v\u001a\u00020w2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010EH\u0016J>\u0010z\u001a\u00020/2\u0006\u0010<\u001a\u00020\u001e2\u0018\u0010{\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0E\u0012\u0004\u0012\u00020/0*2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*H\u0016JW\u0010}\u001a\u00020/2\u0006\u0010Y\u001a\u00020Z2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u001e0\u007f2\u001f\u0010\u0080\u0001\u001a\u001a\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0081\u00010E\u0012\u0004\u0012\u00020/0*j\u0003`\u0082\u00012\u0016\u0010]\u001a\u0012\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*j\u0002`hH\u0016J=\u0010\u0083\u0001\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u001e2\u0018\u0010{\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0E\u0012\u0004\u0012\u00020/0*2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*JB\u0010\u0084\u0001\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001e2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020/0*2\u0013\u0010\u0085\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020/0*H\u0002JF\u0010\u0086\u0001\u001a\u00020/2\u0006\u0010<\u001a\u00020\u001e2\u001f\u0010g\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020M0\u0087\u0001\u0012\u0004\u0012\u00020/0*2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020/0*H\u0016J\t\u0010\u0088\u0001\u001a\u00020/H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020+H\u0002J1\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010k\u001a\u00020l2\u000e\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010E2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020/0\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020/2\u0006\u0010U\u001a\u00020%H\u0016J\t\u0010\u0092\u0001\u001a\u00020/H\u0002J\u001d\u0010\u0093\u0001\u001a\u00020/2\u0007\u0010\u0094\u0001\u001a\u00020@2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J!\u0010\u0096\u0001\u001a\u00020/2\u0006\u0010v\u001a\u00020w2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010EH\u0002J$\u0010\u0097\u0001\u001a\u00020/2\u0019\u0010\u0098\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0*¢\u0006\u0003\b\u0099\u0001H\u0002R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\u0002\n\u0000R?\u0010'\u001a3\u0012/\u0012-\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/0*\u0012\u0006\u0012\u0004\u0018\u00010%0)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009c\u0001"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "Lcom/android/billingclient/api/BillingClientStateListener;", "clientFactory", "Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "mainHandler", "Landroid/os/Handler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "purchasesStateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;Landroid/os/Handler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/DateProvider;)V", "appInBackground", "", "getAppInBackground", "()Z", "<set-?>", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "setBillingClient", "(Lcom/android/billingclient/api/BillingClient;)V", "purchaseContext", "", "", "Lcom/revenuecat/purchases/google/PurchaseContext;", "getPurchaseContext$purchases_defaultsBc8Release$annotations", "()V", "getPurchaseContext$purchases_defaultsBc8Release", "()Ljava/util/Map;", "reconnectMilliseconds", "", "reconnectionAlreadyScheduled", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "acknowledge", "token", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "onAcknowledged", Constants.GP_IAP_PURCHASE_TOKEN, "acknowledge$purchases_defaultsBc8Release", "buildOneTimePurchaseParams", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/android/billingclient/api/BillingFlowParams;", "purchaseInfo", "Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;", "appUserID", "isPersonalizedPrice", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildPurchaseParams", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "(Lcom/revenuecat/purchases/models/GooglePurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildSubscriptionProductDetailsParams", "", "Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;", "Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;", "buildSubscriptionPurchaseParams", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "consumeAndSave", "finishTransactions", FirebaseAnalytics.Event.PURCHASE, "Lcom/revenuecat/purchases/models/StoreTransaction;", "shouldConsume", "consumePurchase", "onConsumed", "consumePurchase$purchases_defaultsBc8Release", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "delayMilliseconds", "request", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "findPurchaseInPurchaseHistory", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getPurchaseType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPurchaseType$purchases_defaultsBc8Release", "getStackTrace", "getStoreTransaction", "Lcom/android/billingclient/api/Purchase;", "completion", "storeTxn", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "isConnected", "launchBillingFlow", "activity", "Landroid/app/Activity;", NativeProtocol.WEB_DIALOG_PARAMS, "makePurchaseAsync", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "purchases", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, "productIds", "", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", InAppPurchaseConstants.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, "queryPurchaseType", "resultHandler", InAppPurchaseConstants.METHOD_QUERY_PURCHASES, "", "retryBillingServiceConnectionWithExponentialBackoff", "sendErrorsToAllPendingRequests", "error", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", InAppPurchaseConstants.METHOD_START_CONNECTION, "startConnectionOnMainThread", "trackProductDetailsNotSupportedIfNeeded", "trackPurchaseStartIfNeeded", "googlePurchasingData", "oldProductId", "trackPurchaseUpdateReceivedIfNeeded", "withConnectedClient", "receivingFunction", "Lkotlin/ExtensionFunctionType;", "ClientFactory", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BillingWrapper extends BillingAbstract implements PurchasesUpdatedListener, BillingClientStateListener {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_PENDING_REQUEST_COUNT_REPORTED = 100;
    private volatile BillingClient billingClient;
    private final ClientFactory clientFactory;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler mainHandler;
    private final Map<String, PurchaseContext> purchaseContext;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<Pair<Function1<PurchasesError, Unit>, Long>> serviceRequests;

    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "", "context", "Landroid/content/Context;", "pendingTransactionsForPrepaidPlansEnabled", "", "(Landroid/content/Context;Z)V", "buildClient", "Lcom/android/billingclient/api/BillingClient;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ClientFactory {
        private final Context context;
        private final boolean pendingTransactionsForPrepaidPlansEnabled;

        public ClientFactory(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.pendingTransactionsForPrepaidPlansEnabled = z;
        }

        public final BillingClient buildClient(PurchasesUpdatedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            PendingPurchasesParams.Builder builderEnableOneTimeProducts = PendingPurchasesParams.newBuilder().enableOneTimeProducts();
            if (this.pendingTransactionsForPrepaidPlansEnabled) {
                builderEnableOneTimeProducts.enablePrepaidPlans();
            }
            PendingPurchasesParams pendingPurchasesParamsBuild = builderEnableOneTimeProducts.build();
            Intrinsics.checkNotNullExpressionValue(pendingPurchasesParamsBuild, "newBuilder()\n           …\n                .build()");
            BillingClient billingClientBuild = BillingClient.newBuilder(this.context).enablePendingPurchases(pendingPurchasesParamsBuild).setListener(listener).build();
            Intrinsics.checkNotNullExpressionValue(billingClientBuild, "newBuilder(context).enab…\n                .build()");
            return billingClientBuild;
        }
    }

    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper$Companion;", "", "()V", "MAX_PENDING_REQUEST_COUNT_REPORTED", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$3, reason: invalid class name */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
            invoke2((Function1<? super BillingClient, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function1<? super BillingClient, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p0);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$4, reason: invalid class name */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        AnonymousClass4(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Function1<? super PurchasesError, ? extends Unit> function1) {
            invoke2(l, (Function1<? super PurchasesError, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l, Function1<? super PurchasesError, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, p1);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06622 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C06622(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
            invoke2((Function1<? super BillingClient, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function1<? super BillingClient, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p0);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06633 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C06633(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Function1<? super PurchasesError, ? extends Unit> function1) {
            invoke2(l, (Function1<? super PurchasesError, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l, Function1<? super PurchasesError, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, p1);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06663 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C06663(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
            invoke2((Function1<? super BillingClient, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function1<? super BillingClient, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p0);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06674 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C06674(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Function1<? super PurchasesError, ? extends Unit> function1) {
            invoke2(l, (Function1<? super PurchasesError, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l, Function1<? super PurchasesError, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, p1);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06682 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C06682(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
            invoke2((Function1<? super BillingClient, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function1<? super BillingClient, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p0);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BillingWrapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06693 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C06693(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Function1<? super PurchasesError, ? extends Unit> function1) {
            invoke2(l, (Function1<? super PurchasesError, Unit>) function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l, Function1<? super PurchasesError, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, p1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper(ClientFactory clientFactory, Handler mainHandler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(clientFactory, "clientFactory");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.clientFactory = clientFactory;
        this.mainHandler = mainHandler;
        this.deviceCache = deviceCache;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.purchaseContext = new LinkedHashMap();
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000L;
    }

    public /* synthetic */ BillingWrapper(ClientFactory clientFactory, Handler handler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clientFactory, handler, deviceCache, diagnosticsTracker, purchasesStateProvider, (i & 32) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    private final Result<BillingFlowParams, PurchasesError> buildOneTimePurchaseParams(GooglePurchasingData.InAppProduct purchaseInfo, String appUserID, Boolean isPersonalizedPrice) {
        BillingFlowParams.ProductDetailsParams.Builder builderNewBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        builderNewBuilder.setProductDetails(purchaseInfo.getProductDetails());
        BillingFlowParams.ProductDetailsParams productDetailsParamsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(productDetailsParamsBuild, "newBuilder().apply {\n   …etails)\n        }.build()");
        try {
            BillingFlowParams.Builder obfuscatedAccountId = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(productDetailsParamsBuild)).setObfuscatedAccountId(UtilsKt.sha256(appUserID));
            if (isPersonalizedPrice != null) {
                obfuscatedAccountId.setIsOfferPersonalized(isPersonalizedPrice.booleanValue());
            }
            BillingFlowParams billingFlowParamsBuild = obfuscatedAccountId.build();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "newBuilder()\n           …                 .build()");
            return new Result.Success(billingFlowParamsBuild);
        } catch (NoClassDefFoundError e) {
            throw new NoCoreLibraryDesugaringException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<BillingFlowParams, PurchasesError> buildPurchaseParams(GooglePurchasingData purchaseInfo, ReplaceProductInfo replaceProductInfo, String appUserID, Boolean isPersonalizedPrice) {
        if (purchaseInfo instanceof GooglePurchasingData.InAppProduct) {
            return buildOneTimePurchaseParams((GooglePurchasingData.InAppProduct) purchaseInfo, appUserID, isPersonalizedPrice);
        }
        if (purchaseInfo instanceof GooglePurchasingData.Subscription) {
            return buildSubscriptionPurchaseParams((GooglePurchasingData.Subscription) purchaseInfo, replaceProductInfo, appUserID, isPersonalizedPrice);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<BillingFlowParams.ProductDetailsParams> buildSubscriptionProductDetailsParams(GooglePurchasingData.Subscription purchaseInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildSubscriptionProductDetailsParams$buildProductDetailParams(purchaseInfo));
        List addOnProducts = purchaseInfo.getAddOnProducts();
        if (addOnProducts != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : addOnProducts) {
                if (obj instanceof GooglePurchasingData.Subscription) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(buildSubscriptionProductDetailsParams$buildProductDetailParams((GooglePurchasingData.Subscription) it.next()));
            }
            arrayList.addAll(arrayList4);
        }
        return arrayList;
    }

    private static final BillingFlowParams.ProductDetailsParams buildSubscriptionProductDetailsParams$buildProductDetailParams(GooglePurchasingData.Subscription subscription) {
        BillingFlowParams.ProductDetailsParams.Builder builderNewBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        builderNewBuilder.setOfferToken(subscription.getToken());
        builderNewBuilder.setProductDetails(subscription.getProductDetails());
        BillingFlowParams.ProductDetailsParams productDetailsParamsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(productDetailsParamsBuild, "newBuilder().apply {\n   …ls)\n            }.build()");
        return productDetailsParamsBuild;
    }

    private final Result<BillingFlowParams, PurchasesError> buildSubscriptionPurchaseParams(GooglePurchasingData.Subscription purchaseInfo, ReplaceProductInfo replaceProductInfo, String appUserID, Boolean isPersonalizedPrice) {
        try {
            BillingFlowParams.Builder productDetailsParamsList = BillingFlowParams.newBuilder().setProductDetailsParamsList(buildSubscriptionProductDetailsParams(purchaseInfo));
            if (replaceProductInfo != null) {
                Intrinsics.checkNotNullExpressionValue(productDetailsParamsList, "buildSubscriptionPurchas…arams$lambda$61$lambda$59");
                BillingFlowParamsExtensionsKt.setUpgradeInfo(productDetailsParamsList, replaceProductInfo);
                Unit unit = Unit.INSTANCE;
            } else {
                Intrinsics.checkNotNullExpressionValue(productDetailsParamsList.setObfuscatedAccountId(UtilsKt.sha256(appUserID)), "setObfuscatedAccountId(appUserID.sha256())");
            }
            if (isPersonalizedPrice != null) {
                productDetailsParamsList.setIsOfferPersonalized(isPersonalizedPrice.booleanValue());
            }
            BillingFlowParams billingFlowParamsBuild = productDetailsParamsList.build();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "newBuilder()\n           …                 .build()");
            return new Result.Success(billingFlowParamsBuild);
        } catch (NoClassDefFoundError e) {
            throw new NoCoreLibraryDesugaringException(e);
        }
    }

    static final void endConnection$lambda$13(BillingWrapper billingWrapper) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        synchronized (billingWrapper) {
            final BillingClient billingClient = billingWrapper.billingClient;
            if (billingClient != null) {
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$endConnection$lambda$13$lambda$12$lambda$11$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                        String str2 = String.format(BillingStrings.BILLING_CLIENT_ENDING, Arrays.copyOf(new Object[]{billingClient}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        return sbAppend.append(str2).toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                }
                billingClient.endConnection();
            }
            billingWrapper.billingClient = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void executePendingRequests() {
        Pair<Function1<PurchasesError, Unit>, Long> pairPoll;
        synchronized (this) {
            while (true) {
                BillingClient billingClient = this.billingClient;
                if (billingClient == null || !billingClient.isReady() || (pairPoll = this.serviceRequests.poll()) == null) {
                    break;
                }
                Intrinsics.checkNotNullExpressionValue(pairPoll, "poll()");
                final Function1<PurchasesError, Unit> function1Component1 = pairPoll.component1();
                Long lComponent2 = pairPoll.component2();
                Handler handler = this.mainHandler;
                if (lComponent2 != null) {
                    handler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            function1Component1.invoke(null);
                        }
                    }, lComponent2.longValue());
                } else {
                    handler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            function1Component1.invoke(null);
                        }
                    });
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long delayMilliseconds, Function1<? super PurchasesError, Unit> request) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(TuplesKt.to(request, delayMilliseconds));
            BillingClient billingClient = this.billingClient;
            if (billingClient == null || billingClient.isReady()) {
                executePendingRequests();
            } else {
                BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
            }
        } else {
            request.invoke(new PurchasesError(PurchasesErrorCode.UnknownError, "BillingWrapper is not attached to a listener"));
        }
    }

    static /* synthetic */ void executeRequestOnUIThread$default(BillingWrapper billingWrapper, Long l, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        billingWrapper.executeRequestOnUIThread(l, function1);
    }

    public static /* synthetic */ void getPurchaseContext$purchases_defaultsBc8Release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringWriter.toString()");
        return string;
    }

    private final void getStoreTransaction(final Purchase purchase, final Function1<? super StoreTransaction, Unit> completion) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStoreTransaction$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_UPDATED, Arrays.copyOf(new Object[]{PurchaseExtensionsKt.toHumanReadableDescription(purchase)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        synchronized (this) {
            PurchaseContext purchaseContext = this.purchaseContext.get(PurchaseExtensionsKt.getFirstProductId(purchase));
            if (purchaseContext != null && purchaseContext.getProductType() != null) {
                completion.invoke(StoreTransactionConversionsKt.toStoreTransaction(purchase, purchaseContext));
                return;
            }
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            getPurchaseType$purchases_defaultsBc8Release(purchaseToken, new Function1<ProductType, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStoreTransaction$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProductType productType) {
                    invoke2(productType);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProductType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    completion.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(purchase, type, null, null, null, null, 30, null));
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBillingFlow(final Activity activity, final BillingFlowParams params) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (activity.getIntent() == null) {
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Activity passed into launchBillingFlow has a null intent, which may cause a crash. See https://github.com/RevenueCat/purchases-android/issues/381 for more information.";
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
        }
        withConnectedClient(new Function1<BillingClient, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.launchBillingFlow.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                invoke2(billingClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BillingClient withConnectedClient) {
                Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                final BillingResult billingResultLaunchBillingFlow = withConnectedClient.launchBillingFlow(activity, params);
                if (billingResultLaunchBillingFlow.getResponseCode() == 0) {
                    billingResultLaunchBillingFlow = null;
                }
                if (billingResultLaunchBillingFlow != null) {
                    final LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            BillingResult billingResult = billingResultLaunchBillingFlow;
                            Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                            String str2 = String.format(BillingStrings.BILLING_INTENT_FAILED, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResultLaunchBillingFlow)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return sbAppend.append(str2).toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.d("[Purchases] - " + logLevel11.name(), function02.invoke());
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel12 = LogLevel.WARN;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel13 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                currentLogHandler10.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel14 = LogLevel.DEBUG;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler11.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler12.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                currentLogHandler13.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler14.d("[Purchases] - " + logLevel17.name(), function02.invoke());
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                    }
                }
            }
        });
    }

    static final void onBillingSetupFinished$lambda$39(final BillingResult billingResult, final BillingWrapper billingWrapper) {
        PurchasesError purchasesErrorBillingResponseToPurchasesError;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 6) {
            if (responseCode != 7 && responseCode != 8) {
                if (responseCode != 12) {
                    switch (responseCode) {
                        case -2:
                        case 3:
                            String humanReadableDescription = BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult);
                            if (Intrinsics.areEqual(billingResult.getDebugMessage(), ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE)) {
                                String str2 = String.format(BillingStrings.BILLING_UNAVAILABLE_LESS_THAN_3, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                                purchasesErrorBillingResponseToPurchasesError = new PurchasesError(PurchasesErrorCode.StoreProblemError, str2);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            } else {
                                String str3 = String.format(BillingStrings.BILLING_UNAVAILABLE, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.getResponseCode(), str3);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            }
                            billingWrapper.sendErrorsToAllPendingRequests(purchasesErrorBillingResponseToPurchasesError);
                            break;
                        case 0:
                            final LogIntent logIntent = LogIntent.DEBUG;
                            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$39$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                    BillingClient billingClient = billingWrapper.getBillingClient();
                                    String str4 = String.format(BillingStrings.BILLING_SERVICE_SETUP_FINISHED, Arrays.copyOf(new Object[]{billingClient != null ? billingClient.toString() : null}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                    return sbAppend.append(str4).toString();
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                case 1:
                                    LogLevel logLevel = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                        str = "[Purchases] - " + logLevel.name();
                                        strInvoke = function0.invoke();
                                        currentLogHandler.d(str, strInvoke);
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel2 = LogLevel.WARN;
                                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel3 = LogLevel.INFO;
                                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel4 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                        str = "[Purchases] - " + logLevel4.name();
                                        strInvoke = function0.invoke();
                                        currentLogHandler.d(str, strInvoke);
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel5 = LogLevel.INFO;
                                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel6 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                        str = "[Purchases] - " + logLevel6.name();
                                        strInvoke = function0.invoke();
                                        currentLogHandler.d(str, strInvoke);
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel7 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                        str = "[Purchases] - " + logLevel7.name();
                                        strInvoke = function0.invoke();
                                        currentLogHandler.d(str, strInvoke);
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel8 = LogLevel.WARN;
                                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel9 = LogLevel.WARN;
                                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                                    break;
                                case 13:
                                    LogLevel logLevel10 = LogLevel.WARN;
                                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                                    }
                                    break;
                                case 14:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                                    break;
                            }
                            BillingAbstract.StateListener stateListener = billingWrapper.getStateListener();
                            if (stateListener != null) {
                                stateListener.onConnected();
                                Unit unit = Unit.INSTANCE;
                            }
                            billingWrapper.executePendingRequests();
                            billingWrapper.reconnectMilliseconds = 1000L;
                            billingWrapper.trackProductDetailsNotSupportedIfNeeded();
                            break;
                    }
                    return;
                }
            }
            final LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$39$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str4 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    return sbAppend.append(str4).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel11.name(), function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel17.name(), function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
            }
            return;
        }
        final LogIntent logIntent3 = LogIntent.GOOGLE_WARNING;
        Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$39$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str4 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                return sbAppend.append(str4).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
            case 1:
                LogLevel logLevel21 = LogLevel.DEBUG;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                    currentLogHandler18.d("[Purchases] - " + logLevel21.name(), function03.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 3:
                LogLevel logLevel22 = LogLevel.WARN;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                    currentLogHandler19.w("[Purchases] - " + logLevel22.name(), function03.invoke());
                }
                break;
            case 4:
                LogLevel logLevel23 = LogLevel.INFO;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                    currentLogHandler20.i("[Purchases] - " + logLevel23.name(), function03.invoke());
                }
                break;
            case 5:
                LogLevel logLevel24 = LogLevel.DEBUG;
                LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                    currentLogHandler21.d("[Purchases] - " + logLevel24.name(), function03.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 7:
                LogLevel logLevel25 = LogLevel.INFO;
                LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                    currentLogHandler22.i("[Purchases] - " + logLevel25.name(), function03.invoke());
                }
                break;
            case 8:
                LogLevel logLevel26 = LogLevel.DEBUG;
                LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                    currentLogHandler23.d("[Purchases] - " + logLevel26.name(), function03.invoke());
                }
                break;
            case 9:
                LogLevel logLevel27 = LogLevel.DEBUG;
                LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                    currentLogHandler24.d("[Purchases] - " + logLevel27.name(), function03.invoke());
                }
                break;
            case 10:
                LogLevel logLevel28 = LogLevel.WARN;
                LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                    currentLogHandler25.w("[Purchases] - " + logLevel28.name(), function03.invoke());
                }
                break;
            case 11:
                LogLevel logLevel29 = LogLevel.WARN;
                LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                    currentLogHandler26.w("[Purchases] - " + logLevel29.name(), function03.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                break;
            case 13:
                LogLevel logLevel30 = LogLevel.WARN;
                LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                    currentLogHandler27.w("[Purchases] - " + logLevel30.name(), function03.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                break;
        }
        billingWrapper.retryBillingServiceConnectionWithExponentialBackoff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchaseType(String productType, final String purchaseToken, final Function1<? super ProductType, Unit> listener, final Function1<? super Boolean, Unit> resultHandler) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground(), productType), new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryPurchaseType.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreTransaction> map) {
                invoke2((Map<String, StoreTransaction>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, StoreTransaction> purchases) {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Function1<Boolean, Unit> function1 = resultHandler;
                Collection<StoreTransaction> collectionValues = purchases.values();
                String str = purchaseToken;
                boolean z = false;
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator<T> it = collectionValues.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((StoreTransaction) it.next()).getPurchaseToken(), str)) {
                            z = true;
                            break;
                        }
                    }
                }
                function1.invoke(Boolean.valueOf(z));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryPurchaseType.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogUtilsKt.errorLog(error);
                listener.invoke(ProductType.UNKNOWN);
            }
        }, new C06663(this), new C06674(this)), 0L, 1, null);
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " BillingClient connection retry already scheduled. Ignoring";
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            return;
        }
        final LogIntent logIntent2 = LogIntent.WARNING;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str = String.format(BillingStrings.BILLING_CLIENT_RETRY, Arrays.copyOf(new Object[]{Long.valueOf(this.reconnectMilliseconds)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return sbAppend.append(str).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel11 = LogLevel.DEBUG;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler11.d("[Purchases] - " + logLevel11.name(), function02.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler13.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                }
                break;
            case 5:
                LogLevel logLevel14 = LogLevel.DEBUG;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler14.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler15.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler16.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                }
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler17.d("[Purchases] - " + logLevel17.name(), function02.invoke());
                }
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler18.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler19.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler20.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                break;
        }
        this.reconnectionAlreadyScheduled = true;
        startConnectionOnMainThread(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * 2, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
    }

    private final synchronized void sendErrorsToAllPendingRequests(final PurchasesError error) {
        while (true) {
            Pair<Function1<PurchasesError, Unit>, Long> pairPoll = this.serviceRequests.poll();
            if (pairPoll != null) {
                final Function1<PurchasesError, Unit> function1Component1 = pairPoll.component1();
                this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        function1Component1.invoke(error);
                    }
                });
            }
        }
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        BillingClient billingClient = this.billingClient;
        BillingResult billingResultIsFeatureSupported = billingClient != null ? billingClient.isFeatureSupported(BillingClient.FeatureType.PRODUCT_DETAILS) : null;
        if (billingResultIsFeatureSupported == null || billingResultIsFeatureSupported.getResponseCode() != -2) {
            return;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int responseCode = billingResultIsFeatureSupported.getResponseCode();
        String debugMessage = billingResultIsFeatureSupported.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        diagnosticsTracker.trackProductDetailsNotSupported(responseCode, debugMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void trackPurchaseStartIfNeeded(GooglePurchasingData googlePurchasingData, String oldProductId) {
        List<ProductDetails.PricingPhase> pricingPhaseList;
        Boolean boolValueOf;
        List listDropLast;
        boolean z;
        ProductDetails productDetails;
        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        Boolean boolValueOf2 = null;
        GooglePurchasingData.Subscription subscription = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
        if (subscription != null && (productDetails = subscription.getProductDetails()) != null && (subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails()) != null) {
            for (ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails2 : subscriptionOfferDetails) {
                if (Intrinsics.areEqual(subscriptionOfferDetails2.getOfferToken(), subscription.getToken())) {
                    if (subscriptionOfferDetails2 != null && (pricingPhases = subscriptionOfferDetails2.getPricingPhases()) != null) {
                        pricingPhaseList = pricingPhases.getPricingPhaseList();
                    }
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        pricingPhaseList = null;
        boolean z2 = true;
        if (pricingPhaseList != null) {
            List<ProductDetails.PricingPhase> list = pricingPhaseList;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = false;
                boolValueOf = Boolean.valueOf(z);
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((ProductDetails.PricingPhase) it.next()).getPriceAmountMicros() == 0) {
                        z = true;
                        break;
                    }
                }
                z = false;
                boolValueOf = Boolean.valueOf(z);
            }
        } else {
            boolValueOf = null;
        }
        if (pricingPhaseList != null && (listDropLast = CollectionsKt.dropLast(pricingPhaseList, 1)) != null) {
            List list2 = listDropLast;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                z2 = false;
                boolValueOf2 = Boolean.valueOf(z2);
            } else {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((ProductDetails.PricingPhase) it2.next()).getPriceAmountMicros() > 0) {
                        break;
                    }
                }
                z2 = false;
                boolValueOf2 = Boolean.valueOf(z2);
            }
        }
        this.diagnosticsTrackerIfEnabled.trackGooglePurchaseStarted(googlePurchasingData.getProductId(), oldProductId, boolValueOf, boolValueOf2);
    }

    private final void trackPurchaseUpdateReceivedIfNeeded(BillingResult billingResult, List<? extends Purchase> purchases) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker == null) {
            return;
        }
        ArrayList arrayList2 = null;
        if (purchases != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = purchases.iterator();
            while (it.hasNext()) {
                List<String> products = ((Purchase) it.next()).getProducts();
                Intrinsics.checkNotNullExpressionValue(products, "it.products");
                CollectionsKt.addAll(arrayList3, products);
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        if (purchases != null) {
            List<? extends Purchase> list = purchases;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList4.add(PurchaseStateConversionsKt.toRevenueCatPurchaseState(((Purchase) it2.next()).getPurchaseState()).name());
            }
            arrayList2 = arrayList4;
        }
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        diagnosticsTracker.trackGooglePurchaseUpdateReceived(arrayList, arrayList2, responseCode, debugMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void withConnectedClient(Function1<? super BillingClient, Unit> receivingFunction) {
        Unit unit;
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            unit = null;
        } else {
            if (!billingClient.isReady()) {
                billingClient = null;
            }
            if (billingClient != null) {
                receivingFunction.invoke(billingClient);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            final LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$withConnectedClient$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str = String.format(BillingStrings.BILLING_CLIENT_DISCONNECTED, Arrays.copyOf(new Object[]{this.getStackTrace()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
        }
    }

    public final void acknowledge$purchases_defaultsBc8Release(final String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onAcknowledged) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onAcknowledged, "onAcknowledged");
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$acknowledge$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(PurchaseStrings.ACKNOWLEDGING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new AcknowledgePurchaseUseCase(new AcknowledgePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onAcknowledged, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$acknowledge$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
            }
        }, new BillingWrapper$acknowledge$3(this), new BillingWrapper$acknowledge$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean finishTransactions, final StoreTransaction purchase, boolean shouldConsume, PostReceiptInitiationSource initiationSource) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (purchase.getType() == ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        Purchase originalGooglePurchase = StoreTransactionConversionsKt.getOriginalGooglePurchase(purchase);
        boolean zIsAcknowledged = originalGooglePurchase != null ? originalGooglePurchase.isAcknowledged() : false;
        boolean z = purchase.getType() == ProductType.INAPP;
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$addToken$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                this.this$0.deviceCache.addSuccessfullyPostedToken(token, purchase.getIsAutoRenewing());
            }
        };
        if (!z) {
            if (!finishTransactions || zIsAcknowledged) {
                function1.invoke(purchase.getPurchaseToken());
                return;
            } else {
                acknowledge$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
                return;
            }
        }
        if (finishTransactions && shouldConsume) {
            consumePurchase$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
            return;
        }
        if (!finishTransactions || zIsAcknowledged) {
            function1.invoke(purchase.getPurchaseToken());
            return;
        }
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Not consuming in-app purchase according to server configuration. This is expected for non-consumable products. The user won't be able to purchase this product again.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        acknowledge$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
    }

    public final void consumePurchase$purchases_defaultsBc8Release(final String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onConsumed) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onConsumed, "onConsumed");
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumePurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(PurchaseStrings.CONSUMING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new ConsumePurchaseUseCase(new ConsumePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onConsumed, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumePurchase$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
            }
        }, new BillingWrapper$consumePurchase$3(this), new BillingWrapper$consumePurchase$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.endConnection$lambda$13(this.f$0);
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, final ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        Function1<? super PurchasesError, Unit> function1;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_TYPE, Arrays.copyOf(new Object[]{productId, productType.name()}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        Unit unit = null;
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(productType);
        if (googleProductType != null) {
            function1 = onError;
            BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, googleProductType, getAppInBackground()), new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$findPurchaseInPurchaseHistory$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                    invoke2((List<StoreTransaction>) list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<StoreTransaction> purchasesList) {
                    Object next;
                    Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
                    String str2 = productId;
                    Iterator<T> it = purchasesList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (((StoreTransaction) next).getProductIds().contains(str2)) {
                                break;
                            }
                        }
                    }
                    StoreTransaction storeTransaction = (StoreTransaction) next;
                    if (storeTransaction != null) {
                        onCompletion.invoke(storeTransaction);
                        return;
                    }
                    String str3 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{productId}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, str3));
                }
            }, function1, new BillingWrapper$findPurchaseInPurchaseHistory$2$2(this), new BillingWrapper$findPurchaseInPurchaseHistory$2$3(this)), 0L, 1, null);
            unit = Unit.INSTANCE;
        } else {
            function1 = onError;
        }
        if (unit == null) {
            function1.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.NOT_RECOGNIZED_PRODUCT_TYPE));
        }
    }

    public final boolean getAppInBackground() {
        return getPurchasesStateProvider().getPurchasesState().getAppInBackground();
    }

    public final synchronized BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final Map<String, PurchaseContext> getPurchaseContext$purchases_defaultsBc8Release() {
        return this.purchaseContext;
    }

    public final void getPurchaseType$purchases_defaultsBc8Release(final String purchaseToken, final Function1<? super ProductType, Unit> listener) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(listener, "listener");
        queryPurchaseType("subs", purchaseToken, listener, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    listener.invoke(ProductType.SUBS);
                    return;
                }
                BillingWrapper billingWrapper = this;
                String str = purchaseToken;
                Function1<ProductType, Unit> function1 = listener;
                final Function1<ProductType, Unit> function12 = listener;
                billingWrapper.queryPurchaseType("inapp", str, function1, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        Function1<ProductType, Unit> function13 = function12;
                        if (z2) {
                            function13.invoke(ProductType.INAPP);
                        } else {
                            function13.invoke(ProductType.UNKNOWN);
                        }
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INITIATE_GETTING_COUNTRY_CODE);
        }
        BillingClientUseCase.run$default(new GetBillingConfigUseCase(new GetBillingConfigUseCaseParams(getAppInBackground()), this.deviceCache, new Function1<BillingConfig, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.getStorefront.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BillingConfig billingConfig) {
                invoke2(billingConfig);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BillingConfig billingConfig) {
                Intrinsics.checkNotNullParameter(billingConfig, "billingConfig");
                Function1<String, Unit> function1 = onSuccess;
                String countryCode = billingConfig.getCountryCode();
                Intrinsics.checkNotNullExpressionValue(countryCode, "billingConfig.countryCode");
                function1.invoke(countryCode);
            }
        }, onError, new AnonymousClass3(this), new AnonymousClass4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            return billingClient.isReady();
        }
        return false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, final PurchasingData purchasingData, final ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, final Boolean isPersonalizedPrice) {
        String optionId;
        ReplacementMode replacementMode;
        List addOnProducts;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        final GooglePurchasingData googlePurchasingData = purchasingData instanceof GooglePurchasingData ? (GooglePurchasingData) purchasingData : null;
        if (googlePurchasingData == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str2 = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Play", "GooglePurchasingData"}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str2);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            optionId = null;
        } else {
            if (!(googlePurchasingData instanceof GooglePurchasingData.Subscription)) {
                throw new NoWhenBranchMatchedException();
            }
            optionId = ((GooglePurchasingData.Subscription) googlePurchasingData).getOptionId();
        }
        if (replaceProductInfo == null) {
            final LogIntent logIntent = LogIntent.PURCHASE;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str3 = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{googlePurchasingData.getProductId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    return sbAppend.append(str3).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.d("[Purchases] - " + logLevel.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
        } else {
            final LogIntent logIntent2 = LogIntent.PURCHASE;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str3 = String.format(PurchaseStrings.UPGRADING_SKU, Arrays.copyOf(new Object[]{replaceProductInfo.getOldPurchase().getProductIds().get(0), googlePurchasingData.getProductId()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    return sbAppend.append(str3).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        str = "[Purchases] - " + logLevel11.name();
                        strInvoke = function02.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler13.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        str = "[Purchases] - " + logLevel14.name();
                        strInvoke = function02.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler14.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        str = "[Purchases] - " + logLevel16.name();
                        strInvoke = function02.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        str = "[Purchases] - " + logLevel17.name();
                        strInvoke = function02.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                    break;
            }
        }
        synchronized (this) {
            if (replaceProductInfo != null) {
                try {
                    replacementMode = replaceProductInfo.getReplacementMode();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                replacementMode = null;
            }
            String productId = replacementMode == GoogleReplacementMode.DEFERRED ? (String) CollectionsKt.first((List) replaceProductInfo.getOldPurchase().getProductIds()) : googlePurchasingData.getProductId();
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            if (optionId != null) {
            }
            GooglePurchasingData.Subscription subscription = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
            if (subscription != null && (addOnProducts = subscription.getAddOnProducts()) != null) {
                ArrayList<GooglePurchasingData.Subscription> arrayList = new ArrayList();
                for (Object obj : addOnProducts) {
                    if (obj instanceof GooglePurchasingData.Subscription) {
                        arrayList.add(obj);
                    }
                }
                for (GooglePurchasingData.Subscription subscription2 : arrayList) {
                    mapCreateMapBuilder.put(subscription2.getProductId(), subscription2.getOptionId());
                }
                Unit unit2 = Unit.INSTANCE;
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            Map<String, PurchaseContext> map = this.purchaseContext;
            ProductType productType = googlePurchasingData.getProductType();
            ReplacementMode replacementMode2 = replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null;
            map.put(productId, new PurchaseContext(productType, presentedOfferingContext, optionId, replacementMode2 instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode2 : null, mapBuild));
            Unit unit3 = Unit.INSTANCE;
        }
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.makePurchaseAsync.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                invoke2(purchasesError2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError2) {
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2;
                StoreTransaction oldPurchase;
                List<String> productIds;
                Result resultBuildPurchaseParams = BillingWrapper.this.buildPurchaseParams((GooglePurchasingData) purchasingData, replaceProductInfo, appUserID, isPersonalizedPrice);
                if (!(resultBuildPurchaseParams instanceof Result.Success)) {
                    if (!(resultBuildPurchaseParams instanceof Result.Error) || (purchasesUpdatedListener2 = BillingWrapper.this.getPurchasesUpdatedListener()) == null) {
                        return;
                    }
                    purchasesUpdatedListener2.onPurchasesFailedToUpdate((PurchasesError) ((Result.Error) resultBuildPurchaseParams).getValue());
                    return;
                }
                BillingWrapper billingWrapper = BillingWrapper.this;
                GooglePurchasingData googlePurchasingData2 = googlePurchasingData;
                ReplaceProductInfo replaceProductInfo2 = replaceProductInfo;
                billingWrapper.trackPurchaseStartIfNeeded(googlePurchasingData2, (replaceProductInfo2 == null || (oldPurchase = replaceProductInfo2.getOldPurchase()) == null || (productIds = oldPurchase.getProductIds()) == null) ? null : (String) CollectionsKt.firstOrNull((List) productIds));
                BillingWrapper.this.launchBillingFlow(activity, (BillingFlowParams) ((Result.Success) resultBuildPurchaseParams).getValue());
            }
        }, 1, null);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingServiceDisconnected$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                BillingClient billingClient = this.getBillingClient();
                String str2 = String.format(BillingStrings.BILLING_SERVICE_DISCONNECTED_INSTANCE, Arrays.copyOf(new Object[]{billingClient != null ? billingClient.toString() : null}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGoogleBillingServiceDisconnected();
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(final BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
            diagnosticsTracker.trackGoogleBillingSetupFinished(responseCode, debugMessage, SequencesKt.count(SequencesKt.take(CollectionsKt.asSequence(this.serviceRequests), 100)));
        }
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.onBillingSetupFinished$lambda$39(billingResult, this);
            }
        });
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(final BillingResult billingResult, List<? extends Purchase> purchases) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        trackPurchaseUpdateReceivedIfNeeded(billingResult, purchases);
        final List<? extends Purchase> listEmptyList = purchases == null ? CollectionsKt.emptyList() : purchases;
        if (billingResult.getResponseCode() == 0 && !listEmptyList.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            Iterator<T> it = listEmptyList.iterator();
            while (it.hasNext()) {
                getStoreTransaction((Purchase) it.next(), new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction) {
                        invoke2(storeTransaction);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(StoreTransaction storeTxn) {
                        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
                        Intrinsics.checkNotNullParameter(storeTxn, "storeTxn");
                        arrayList.add(storeTxn);
                        if (arrayList.size() != listEmptyList.size() || (purchasesUpdatedListener = this.getPurchasesUpdatedListener()) == null) {
                            return;
                        }
                        purchasesUpdatedListener.onPurchasesUpdated(arrayList);
                    }
                });
            }
            return;
        }
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str2;
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                StringBuilder sb = new StringBuilder();
                String str3 = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                StringBuilder sbAppend2 = sb.append(str3);
                List list = listEmptyList;
                if (Boolean.valueOf(list.isEmpty()).booleanValue()) {
                    list = null;
                }
                if (list == null || (str2 = " Purchases:" + CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<Purchase, CharSequence>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Purchase it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return PurchaseExtensionsKt.toHumanReadableDescription(it2);
                    }
                }, 30, null)) == null) {
                    str2 = " No purchases received";
                }
                return sbAppend.append(sbAppend2.append(str2).toString()).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        String str2 = "Error updating purchases. " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult);
        int responseCode = billingResult.getResponseCode();
        if (purchases == null && billingResult.getResponseCode() == 0) {
            str2 = "Error: onPurchasesUpdated received an OK BillingResult with a Null purchases list.";
            responseCode = 6;
        }
        PurchasesError purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(responseCode, str2);
        LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesErrorBillingResponseToPurchasesError);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, final Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchaseHistoryAsync("subs", new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryAllPurchases.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                invoke2((List<StoreTransaction>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final List<StoreTransaction> subsPurchasesList) {
                Intrinsics.checkNotNullParameter(subsPurchasesList, "subsPurchasesList");
                BillingWrapper billingWrapper = BillingWrapper.this;
                final Function1<List<StoreTransaction>, Unit> function1 = onReceivePurchaseHistory;
                billingWrapper.queryPurchaseHistoryAsync("inapp", new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryAllPurchases.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                        invoke2((List<StoreTransaction>) list);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<StoreTransaction> inAppPurchasesList) {
                        Intrinsics.checkNotNullParameter(inAppPurchasesList, "inAppPurchasesList");
                        function1.invoke(CollectionsKt.plus((Collection) subsPurchasesList, (Iterable) inAppPurchasesList));
                    }
                }, onReceivePurchaseHistoryError);
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, final Set<String> productIds, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryProductDetailsAsync$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(OfferingStrings.FETCHING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(productIds, null, null, null, 0, null, null, 63, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productIds, productType, getAppInBackground()), onReceive, onError, new BillingWrapper$queryProductDetailsAsync$useCase$1(this), new BillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0L, 1, null);
    }

    public final void queryPurchaseHistoryAsync(final String productType, Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(RestoreStrings.QUERYING_PURCHASE_HISTORY, Arrays.copyOf(new Object[]{productType}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productType, getAppInBackground()), onReceivePurchaseHistory, onReceivePurchaseHistoryError, new C06622(this), new C06633(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Querying purchases";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryPurchasesUseCase(new QueryPurchasesUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground()), onSuccess, onError, new C06682(this), new C06693(this)), 0L, 1, null);
    }

    public final synchronized void setBillingClient(BillingClient billingClient) {
        this.billingClient = billingClient;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, final Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
        if (inAppMessageTypes.isEmpty()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", BillingStrings.BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES, null);
            return;
        }
        InAppMessageParams.Builder builderNewBuilder = InAppMessageParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        Iterator<? extends InAppMessageType> it = inAppMessageTypes.iterator();
        while (it.hasNext()) {
            builderNewBuilder.addInAppMessageCategoryToShow(it.next().getInAppMessageCategoryId());
        }
        final InAppMessageParams inAppMessageParamsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(inAppMessageParamsBuild, "inAppMessageParamsBuilder.build()");
        final WeakReference weakReference = new WeakReference(activity);
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.showInAppMessagesIfNeeded.2

            /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BillingWrapper.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
            static final class C01572 extends Lambda implements Function1<BillingClient, Unit> {
                final /* synthetic */ InAppMessageParams $inAppMessageParams;
                final /* synthetic */ Function0<Unit> $subscriptionStatusChange;
                final /* synthetic */ WeakReference<Activity> $weakActivity;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01572(WeakReference<Activity> weakReference, InAppMessageParams inAppMessageParams, Function0<Unit> function0) {
                    super(1);
                    this.$weakActivity = weakReference;
                    this.$inAppMessageParams = inAppMessageParams;
                    this.$subscriptionStatusChange = function0;
                }

                static final void invoke$lambda$8(Function0 function0, InAppMessageResult inAppMessageResult) {
                    Intrinsics.checkNotNullParameter(inAppMessageResult, "inAppMessageResult");
                    int responseCode = inAppMessageResult.getResponseCode();
                    if (responseCode == 0) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INAPP_MESSAGE_NONE);
                            return;
                        }
                        return;
                    }
                    if (responseCode != 1) {
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str = String.format(BillingStrings.BILLING_INAPP_MESSAGE_UNEXPECTED_CODE, Arrays.copyOf(new Object[]{Integer.valueOf(responseCode)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str, null);
                        return;
                    }
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.d("[Purchases] - " + logLevel2.name(), BillingStrings.BILLING_INAPP_MESSAGE_UPDATE);
                    }
                    function0.invoke();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                    invoke2(billingClient);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BillingClient withConnectedClient) {
                    View viewPeekDecorView;
                    Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                    Activity activity = this.$weakActivity.get();
                    if (activity == null) {
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Activity is null, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    if (activity.isFinishing()) {
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Activity is finishing, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    if (activity.isDestroyed()) {
                        LogLevel logLevel3 = LogLevel.DEBUG;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Activity is destroyed, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    Window window = activity.getWindow();
                    if (((window == null || (viewPeekDecorView = window.peekDecorView()) == null) ? null : viewPeekDecorView.getWindowToken()) != null) {
                        InAppMessageParams inAppMessageParams = this.$inAppMessageParams;
                        final Function0<Unit> function0 = this.$subscriptionStatusChange;
                        withConnectedClient.showInAppMessages(activity, inAppMessageParams, new InAppMessageResponseListener() { // from class: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$2$2$$ExternalSyntheticLambda0
                            @Override // com.android.billingclient.api.InAppMessageResponseListener
                            public final void onInAppMessageResponse(InAppMessageResult inAppMessageResult) {
                                BillingWrapper.C06702.C01572.invoke$lambda$8(function0, inAppMessageResult);
                            }
                        });
                    } else {
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), "Activity is not attached to a window, not showing Google Play in-app message.");
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                if (purchasesError == null) {
                    BillingWrapper.this.withConnectedClient(new C01572(weakReference, inAppMessageParamsBuild, subscriptionStatusChange));
                    return;
                }
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_INAPP_MESSAGES, Arrays.copyOf(new Object[]{purchasesError}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
            }
        }, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        String str;
        LogHandler currentLogHandler;
        String str2;
        String strInvoke;
        synchronized (this) {
            if (this.billingClient == null) {
                str = "[Purchases] - ";
                this.billingClient = this.clientFactory.buildClient(this);
            } else {
                str = "[Purchases] - ";
            }
            this.reconnectionAlreadyScheduled = false;
            final BillingClient billingClient = this.billingClient;
            if (billingClient != null) {
                if (!billingClient.isReady()) {
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$startConnection$lambda$9$lambda$8$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            String str3 = String.format(BillingStrings.BILLING_CLIENT_STARTING, Arrays.copyOf(new Object[]{billingClient}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            return sbAppend.append(str3).toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                        case 1:
                            LogLevel logLevel = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                str2 = "[Purchases] - " + logLevel.name();
                                strInvoke = function0.invoke();
                                currentLogHandler.d(str2, strInvoke);
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel2 = LogLevel.WARN;
                            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel3 = LogLevel.INFO;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                str2 = "[Purchases] - " + logLevel4.name();
                                strInvoke = function0.invoke();
                                currentLogHandler.d(str2, strInvoke);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                str2 = "[Purchases] - " + logLevel6.name();
                                strInvoke = function0.invoke();
                                currentLogHandler.d(str2, strInvoke);
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                str2 = "[Purchases] - " + logLevel7.name();
                                strInvoke = function0.invoke();
                                currentLogHandler.d(str2, strInvoke);
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel10 = LogLevel.WARN;
                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                    }
                    DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
                    if (diagnosticsTracker != null) {
                        diagnosticsTracker.trackGoogleBillingStartConnection();
                    }
                    try {
                        billingClient.startConnection(this);
                    } catch (IllegalStateException e) {
                        final LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$startConnection$lambda$9$lambda$8$$inlined$log$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                String str3 = String.format(BillingStrings.ILLEGAL_STATE_EXCEPTION_WHEN_CONNECTING, Arrays.copyOf(new Object[]{e}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                return sbAppend.append(str3).toString();
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                            case 1:
                                LogLevel logLevel11 = LogLevel.DEBUG;
                                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    currentLogHandler8.d("[Purchases] - " + logLevel11.name(), function02.invoke());
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel12 = LogLevel.WARN;
                                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                    currentLogHandler9.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel13 = LogLevel.INFO;
                                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                    currentLogHandler10.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel14 = LogLevel.DEBUG;
                                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                    currentLogHandler11.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel15 = LogLevel.INFO;
                                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                    currentLogHandler12.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel16 = LogLevel.DEBUG;
                                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                    currentLogHandler13.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                                }
                                break;
                            case 9:
                                LogLevel logLevel17 = LogLevel.DEBUG;
                                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                    currentLogHandler14.d(str + logLevel17.name(), function02.invoke());
                                }
                                break;
                            case 10:
                                LogLevel logLevel18 = LogLevel.WARN;
                                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                                }
                                break;
                            case 11:
                                LogLevel logLevel19 = LogLevel.WARN;
                                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                    currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                                }
                                break;
                            case 12:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                            case 13:
                                LogLevel logLevel20 = LogLevel.WARN;
                                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                    currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                                }
                                break;
                            case 14:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                        }
                        sendErrorsToAllPendingRequests(new PurchasesError(PurchasesErrorCode.StoreProblemError, e.getMessage()));
                    } catch (SecurityException e2) {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", BillingStrings.SECURITY_EXCEPTION_WHEN_CONNECTING, e2);
                        sendErrorsToAllPendingRequests(new PurchasesError(PurchasesErrorCode.StoreProblemError, e2.getMessage()));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long delayMilliseconds) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startConnection();
            }
        }, delayMilliseconds);
    }
}
