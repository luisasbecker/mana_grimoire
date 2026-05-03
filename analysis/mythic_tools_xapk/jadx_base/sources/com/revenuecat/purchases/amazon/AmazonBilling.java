package com.revenuecat.purchases.amazon;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.LWAConsentStatus;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.amazon.handler.ProductDataHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler;
import com.revenuecat.purchases.amazon.handler.UserDataHandler;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AmazonBilling.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BA\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B{\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\b\u001a\u00020\u0017\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J(\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020*H\u0014J\b\u00102\u001a\u00020*H\u0002J\u001e\u00103\u001a\u00020*2\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020*0%H\u0002JH\u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002072\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0016J4\u0010=\u001a\u00020*2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020*0%2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%j\u0002`@H\u0016Jn\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u0002072\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2N\u0010;\u001aJ\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002070G¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(H\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020&0G¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020*0FH\u0002JM\u0010J\u001a\u00020*2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002070L2\u0006\u0010M\u001a\u0002072\u0018\u0010N\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0D\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0096\u0001J4\u0010P\u001a\u00020*2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020*0%2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%j\u0002`@H\u0016J\u0012\u0010Q\u001a\u0004\u0018\u0001072\u0006\u0010R\u001a\u00020SH\u0002J1\u0010T\u001a\u00020*2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0096\u0001J*\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020E2\u0006\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020O2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\b\u0010\\\u001a\u00020\u000bH\u0016J\u001c\u0010]\u001a\u00020*2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020&0GH\u0002JC\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020`2\u0006\u00106\u001a\u0002072\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010fJW\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u0002072\u0006\u0010i\u001a\u0002072\u0006\u0010j\u001a\u0002072!\u0010>\u001a\u001d\u0012\u0013\u0012\u001107¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0016J\u0010\u0010l\u001a\u00020*2\u0006\u0010R\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020&H\u0002J\u0010\u0010p\u001a\u00020*2\u0006\u0010R\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020*2\u0006\u0010R\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u00020*2\u0006\u0010R\u001a\u00020uH\u0016JW\u0010,\u001a\u00020*2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010_\u001a\u00020`2\u0006\u00106\u001a\u0002072\u0006\u0010Y\u001a\u00020O2\u0018\u0010>\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020*0F2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0096\u0001JB\u0010v\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0018\u0010w\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0D\u0012\u0004\u0012\u00020*0%2\u0016\u0010x\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%j\u0002`@H\u0016JT\u0010y\u001a\u00020*2\u0006\u00108\u001a\u0002092\f\u0010z\u001a\b\u0012\u0004\u0012\u0002070L2\u001c\u0010N\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0D\u0012\u0004\u0012\u00020*0%j\u0002`{2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%j\u0002`@H\u0016J=\u0010|\u001a\u00020*2\u001e\u0010>\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020*0F2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0096\u0001JD\u0010|\u001a\u00020*2\u0006\u0010}\u001a\u00020\u000b2\u001e\u0010>\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020-0G\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0002JD\u0010|\u001a\u00020*2\u0006\u00106\u001a\u0002072\u001e\u0010>\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020-0G\u0012\u0004\u0012\u00020*0%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0%H\u0016J\u0011\u0010~\u001a\u00020*2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u000bH\u0002J1\u0010\u0082\u0001\u001a\u00020*2\u0006\u0010_\u001a\u00020`2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010D2\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0086\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020*H\u0016J\u0013\u0010\u0088\u0001\u001a\u00020*2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J+\u0010\u008b\u0001\u001a\u00020*2\u0007\u0010\u008c\u0001\u001a\u00020\u000b2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002070LH\u0002J,\u0010\u0090\u0001\u001a\u00020*2\u0007\u0010\u008c\u0001\u001a\u00020\u000b2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0002J;\u0010\u0091\u0001\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020-0G*\b\u0012\u0004\u0012\u00020E0D2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002070G2\u0006\u0010X\u001a\u00020UH\u0002R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010#\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBilling;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;", "applicationContext", "Landroid/content/Context;", "cache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "finishTransactions", "", "mainHandler", "Landroid/os/Handler;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "stateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "diagnosticsTracker", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/caching/DeviceCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/common/BackendHelper;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;)V", "amazonBackend", "Lcom/revenuecat/purchases/amazon/AmazonBackend;", "Lcom/revenuecat/purchases/amazon/AmazonCache;", "diagnosticsTrackerIfEnabled", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "productDataHandler", "purchaseHandler", "purchaseUpdatesHandler", "userDataHandler", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lcom/revenuecat/purchases/amazon/AmazonBackend;Lcom/revenuecat/purchases/amazon/AmazonCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;Lcom/revenuecat/purchases/common/DateProvider;)V", "connected", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "consumeAndSave", FirebaseAnalytics.Event.PURCHASE, "Lcom/revenuecat/purchases/models/StoreTransaction;", "shouldConsume", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "request", "findPurchaseInPurchaseHistory", "appUserID", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getAmazonLWAConsentStatus", "onSuccess", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "getMissingSkusForReceipts", "amazonUserID", "receipts", "", "Lcom/amazon/device/iap/model/Receipt;", "Lkotlin/Function2;", "", "tokensToSkusMap", "errors", "getProductData", "skus", "", "marketplace", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "getStorefront", "getTermSkuFromJSON", "response", "Lorg/json/JSONObject;", "getUserData", "Lcom/amazon/device/iap/model/UserData;", "handleReceipt", "receipt", "userData", "storeProduct", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isConnected", "logErrorsIfAny", "makePurchaseAsync", "activity", "Landroid/app/Activity;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "isPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "normalizePurchaseData", "productID", Constants.GP_IAP_PURCHASE_TOKEN, "storeUserID", "correctProductID", "onProductDataResponse", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseError", "error", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, "productIds", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", InAppPurchaseConstants.METHOD_QUERY_PURCHASES, "filterOnlyActivePurchases", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "shouldFinishTransactions", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", InAppPurchaseConstants.METHOD_START_CONNECTION, "startConnectionOnMainThread", "delayMilliseconds", "", "trackAmazonQueryProductDetailsRequestIfNeeded", "wasSuccessful", "requestStartTime", "Ljava/util/Date;", "requestedProductIds", "trackAmazonQueryPurchasesRequestIfNeeded", "toMapOfReceiptHashesToRestoredPurchases", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AmazonBilling extends BillingAbstract implements ProductDataResponseListener, PurchaseResponseListener, PurchaseUpdatesResponseListener, UserDataResponseListener {
    private final AmazonBackend amazonBackend;
    private final Context applicationContext;
    private final AmazonCache cache;
    private boolean connected;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final boolean finishTransactions;
    private final Handler mainHandler;
    private final ProductDataResponseListener productDataHandler;
    private final PurchaseResponseListener purchaseHandler;
    private final PurchaseUpdatesResponseListener purchaseUpdatesHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final ConcurrentLinkedQueue<Function1<PurchasesError, Unit>> serviceRequests;
    private final UserDataResponseListener userDataHandler;

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$handleReceipt$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AmazonBilling.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C06342 extends FunctionReferenceImpl implements Function1<PurchasesError, Unit> {
        C06342(Object obj) {
            super(1, obj, AmazonBilling.class, "onPurchaseError", "onPurchaseError(Lcom/revenuecat/purchases/PurchasesError;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
            invoke2(purchasesError);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PurchasesError p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AmazonBilling) this.receiver).onPurchaseError(p0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, AmazonBackend amazonBackend, AmazonCache cache, boolean z, Handler mainHandler, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataHandler, PurchaseResponseListener purchaseHandler, PurchaseUpdatesResponseListener purchaseUpdatesHandler, UserDataResponseListener userDataHandler, DateProvider dateProvider) {
        super(stateProvider);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(amazonBackend, "amazonBackend");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(productDataHandler, "productDataHandler");
        Intrinsics.checkNotNullParameter(purchaseHandler, "purchaseHandler");
        Intrinsics.checkNotNullParameter(purchaseUpdatesHandler, "purchaseUpdatesHandler");
        Intrinsics.checkNotNullParameter(userDataHandler, "userDataHandler");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.applicationContext = applicationContext;
        this.amazonBackend = amazonBackend;
        this.cache = cache;
        this.finishTransactions = z;
        this.mainHandler = mainHandler;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.productDataHandler = productDataHandler;
        this.purchaseHandler = purchaseHandler;
        this.purchaseUpdatesHandler = purchaseUpdatesHandler;
        this.userDataHandler = userDataHandler;
        this.dateProvider = dateProvider;
        this.serviceRequests = new ConcurrentLinkedQueue<>();
    }

    public /* synthetic */ AmazonBilling(Context context, AmazonBackend amazonBackend, AmazonCache amazonCache, boolean z, Handler handler, PurchasesStateProvider purchasesStateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataResponseListener, PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponseListener userDataResponseListener, DateProvider dateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Handler handler2;
        ProductDataResponseListener productDataHandler;
        PurchasingServiceProvider defaultPurchasingServiceProvider = (i & 128) != 0 ? new DefaultPurchasingServiceProvider() : purchasingServiceProvider;
        if ((i & 256) != 0) {
            handler2 = handler;
            productDataHandler = new ProductDataHandler(defaultPurchasingServiceProvider, handler2);
        } else {
            handler2 = handler;
            productDataHandler = productDataResponseListener;
        }
        this(context, amazonBackend, amazonCache, z, handler, purchasesStateProvider, diagnosticsTracker, defaultPurchasingServiceProvider, productDataHandler, (i & 512) != 0 ? new PurchaseHandler(defaultPurchasingServiceProvider, context, diagnosticsTracker, null, 8, null) : purchaseResponseListener, (i & 1024) != 0 ? new PurchaseUpdatesHandler(defaultPurchasingServiceProvider) : purchaseUpdatesResponseListener, (i & 2048) != 0 ? new UserDataHandler(defaultPurchasingServiceProvider, handler2, null, 4, null) : userDataResponseListener, (i & 4096) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, DeviceCache cache, boolean z, Handler mainHandler, BackendHelper backendHelper, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker) {
        this(applicationContext, new AmazonBackend(backendHelper), new AmazonCache(cache), z, mainHandler, stateProvider, diagnosticsTracker, null, null, null, null, null, null, 8064, null);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
    }

    private final void executePendingRequests() {
        synchronized (this) {
            while (getConnected() && !this.serviceRequests.isEmpty()) {
                final Function1<PurchasesError, Unit> function1Remove = this.serviceRequests.remove();
                runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        function1Remove.invoke(null);
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final synchronized void executeRequestOnUIThread(Function1<? super PurchasesError, Unit> request) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(request);
            if (getConnected()) {
                executePendingRequests();
            } else {
                BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMissingSkusForReceipts(String amazonUserID, List<Receipt> receipts, Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> onCompletion) {
        Map<String, String> receiptSkus = this.cache.getReceiptSkus();
        final Map mutableMap = MapsKt.toMutableMap(receiptSkus);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Receipt> list = receipts;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Receipt) obj).getProductType() != ProductType.SUBSCRIPTION) {
                arrayList.add(obj);
            }
        }
        ArrayList<Receipt> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Receipt receipt : arrayList2) {
            arrayList3.add(TuplesKt.to(receipt.getReceiptId(), receipt.getSku()));
        }
        MapsKt.putAll(mutableMap, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (((Receipt) obj2).getProductType() == ProductType.SUBSCRIPTION) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : arrayList4) {
            if (!receiptSkus.containsKey(((Receipt) obj3).getReceiptId())) {
                arrayList5.add(obj3);
            }
        }
        ArrayList<Receipt> arrayList6 = arrayList5;
        if (arrayList6.isEmpty()) {
            onCompletion.invoke(mutableMap, linkedHashMap);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = arrayList6.size();
        for (final Receipt receipt2 : arrayList6) {
            AmazonBackend amazonBackend = this.amazonBackend;
            String receiptId = receipt2.getReceiptId();
            Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
            final Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function2 = onCompletion;
            Function1<JSONObject, Unit> function1 = new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) throws JSONException {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final JSONObject response) throws JSONException {
                    LogHandler currentLogHandler;
                    String str;
                    String strInvoke;
                    Intrinsics.checkNotNullParameter(response, "response");
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$1$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            String str2 = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
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
                    Map<String, String> map = mutableMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    Object obj4 = response.get("termSku");
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    map.put(receiptId2, (String) obj4);
                    intRef.element--;
                    if (intRef.element == 0) {
                        this.cache.cacheSkusByToken(mutableMap);
                        function2.invoke(mutableMap, linkedHashMap);
                    }
                }
            };
            final Map map = mutableMap;
            mutableMap = map;
            amazonBackend.getAmazonReceiptData(receiptId, amazonUserID, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$2
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
                public final void invoke2(final PurchasesError error) {
                    LogHandler currentLogHandler;
                    String str;
                    String strInvoke;
                    Intrinsics.checkNotNullParameter(error, "error");
                    final LogIntent logIntent = LogIntent.AMAZON_ERROR;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$2$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            String str2 = String.format(AmazonStrings.ERROR_FETCHING_RECEIPT_INFO, Arrays.copyOf(new Object[]{error}, 1));
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
                    Map<String, PurchasesError> map2 = linkedHashMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    map2.put(receiptId2, error);
                    intRef.element--;
                    if (intRef.element == 0) {
                        function2.invoke(map, linkedHashMap);
                    }
                }
            });
            onCompletion = function2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTermSkuFromJSON(JSONObject response) {
        try {
            return response.getString("termSku");
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReceipt(final Receipt receipt, final UserData userData, StoreProduct storeProduct, final PresentedOfferingContext presentedOfferingContext) {
        if (receipt.getProductType() != ProductType.SUBSCRIPTION) {
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, storeProduct.getId(), presentedOfferingContext, PurchaseState.PURCHASED, userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
                return;
            }
            return;
        }
        AmazonBackend amazonBackend = this.amazonBackend;
        String receiptId = receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        String userId = userData.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
        amazonBackend.getAmazonReceiptData(receiptId, userId, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.handleReceipt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) throws JSONException {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject response) throws JSONException {
                Intrinsics.checkNotNullParameter(response, "response");
                Object obj = response.get("termSku");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                StoreTransaction storeTransaction2 = StoreTransactionConversionsKt.toStoreTransaction(receipt, (String) obj, presentedOfferingContext, PurchaseState.PURCHASED, userData);
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2 = this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener2 != null) {
                    purchasesUpdatedListener2.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction2));
                }
            }
        }, new C06342(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logErrorsIfAny(Map<String, PurchasesError> errors) {
        if (errors.isEmpty()) {
            return;
        }
        final String strJoinToString$default = CollectionsKt.joinToString$default(errors.keySet(), "\n", null, null, 0, null, null, 62, null);
        final LogIntent logIntent = LogIntent.AMAZON_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$logErrorsIfAny$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str = String.format(AmazonStrings.ERROR_FETCHING_RECEIPTS, Arrays.copyOf(new Object[]{strJoinToString$default}, 1));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchaseError(PurchasesError error) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(error);
        }
    }

    private final void queryPurchases(final boolean filterOnlyActivePurchases, final Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1
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
            public final void invoke2(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    onError.invoke(purchasesError);
                    return;
                }
                final Date now = AmazonBilling.this.dateProvider.getNow();
                PurchaseUpdatesResponseListener purchaseUpdatesResponseListener = AmazonBilling.this.purchaseUpdatesHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final boolean z = filterOnlyActivePurchases;
                final Function1<Map<String, StoreTransaction>, Unit> function1 = onSuccess;
                final Function1<PurchasesError, Unit> function12 = onError;
                Function2<List<? extends Receipt>, UserData, Unit> function2 = new Function2<List<? extends Receipt>, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Receipt> list, UserData userData) {
                        invoke2((List<Receipt>) list, userData);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<Receipt> receipts, final UserData userData) {
                        Intrinsics.checkNotNullParameter(receipts, "receipts");
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        amazonBilling.trackAmazonQueryPurchasesRequestIfNeeded(true, now, receipts);
                        if (z) {
                            AmazonBilling amazonBilling2 = amazonBilling;
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : receipts) {
                                Receipt receipt = (Receipt) obj;
                                if (receipt.getCancelDate() == null || receipt.getCancelDate().compareTo(amazonBilling2.dateProvider.getNow()) > 0) {
                                    arrayList.add(obj);
                                }
                            }
                            receipts = arrayList;
                        }
                        final List<Receipt> list = receipts;
                        if (list.isEmpty()) {
                            function1.invoke(MapsKt.emptyMap());
                            return;
                        }
                        AmazonBilling amazonBilling3 = amazonBilling;
                        String userId = userData.getUserId();
                        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
                        final AmazonBilling amazonBilling4 = amazonBilling;
                        final Function1<PurchasesError, Unit> function13 = function12;
                        final Function1<Map<String, StoreTransaction>, Unit> function14 = function1;
                        amazonBilling3.getMissingSkusForReceipts(userId, list, new Function2<Map<String, ? extends String>, Map<String, ? extends PurchasesError>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map, Map<String, ? extends PurchasesError> map2) {
                                invoke2((Map<String, String>) map, (Map<String, PurchasesError>) map2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Map<String, String> tokensToSkusMap, Map<String, PurchasesError> errors) {
                                Intrinsics.checkNotNullParameter(tokensToSkusMap, "tokensToSkusMap");
                                Intrinsics.checkNotNullParameter(errors, "errors");
                                amazonBilling4.logErrorsIfAny(errors);
                                if (tokensToSkusMap.isEmpty()) {
                                    function13.invoke(new PurchasesError(PurchasesErrorCode.InvalidReceiptError, AmazonStrings.ERROR_FETCHING_PURCHASE_HISTORY_ALL_RECEIPTS_INVALID));
                                } else {
                                    function14.invoke(amazonBilling4.toMapOfReceiptHashesToRestoredPurchases(list, tokensToSkusMap, userData));
                                }
                            }
                        });
                    }
                };
                final AmazonBilling amazonBilling2 = AmazonBilling.this;
                final Function1<PurchasesError, Unit> function13 = onError;
                purchaseUpdatesResponseListener.queryPurchases(function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                        invoke2(purchasesError2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        amazonBilling2.trackAmazonQueryPurchasesRequestIfNeeded(false, now, null);
                        function13.invoke(it);
                    }
                });
            }
        });
    }

    private final void runOnUIThread(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }

    private final boolean shouldFinishTransactions() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (this.finishTransactions) {
            return true;
        }
        final LogIntent logIntent = LogIntent.AMAZON_WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$shouldFinishTransactions$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Attempting to interact with the Amazon App Store while RevenueCat is configured not to complete purchases won't do anything. (See AmazonConfiguration.Builder.purchasesAreCompletedBy().) Please use syncAmazonPurchase to send purchases to RevenueCat instead.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel.name();
                strInvoke = function0.invoke();
                break;
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                return false;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
                    return false;
                }
                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                return false;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) > 0) {
                    return false;
                }
                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                return false;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel4.name();
                strInvoke = function0.invoke();
                break;
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                return false;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) > 0) {
                    return false;
                }
                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                return false;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel6.name();
                strInvoke = function0.invoke();
                break;
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel7.name();
                strInvoke = function0.invoke();
                break;
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) > 0) {
                    return false;
                }
                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                return false;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) > 0) {
                    return false;
                }
                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                return false;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                return false;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) > 0) {
                    return false;
                }
                currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                return false;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                return false;
            default:
                return false;
        }
        currentLogHandler.d(str, strInvoke);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfReceiptHashesToRestoredPurchases(List<Receipt> list, Map<String, String> map, UserData userData) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        ArrayList arrayList = new ArrayList();
        for (Receipt receipt : list) {
            String str2 = map.get(receipt.getReceiptId());
            Pair pair = null;
            if (str2 == null) {
                final LogIntent logIntent = LogIntent.AMAZON_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Couldn't find sku for token %s";
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
            } else {
                StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, str2, null, PurchaseState.UNSPECIFIED_STATE, userData);
                String receiptId = receipt.getReceiptId();
                Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
                pair = TuplesKt.to(UtilsKt.sha1(receiptId), storeTransaction);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryProductDetailsRequestIfNeeded(boolean wasSuccessful, Date requestStartTime, Set<String> requestedProductIds) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m10338trackAmazonQueryProductDetailsRequestKLykuaI(DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.dateProvider.getNow()), wasSuccessful, requestedProductIds);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryPurchasesRequestIfNeeded(boolean wasSuccessful, Date requestStartTime, List<Receipt> receipts) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.dateProvider.getNow());
            if (receipts != null) {
                List<Receipt> list = receipts;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Receipt) it.next()).getSku());
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            diagnosticsTracker.m10339trackAmazonQueryPurchasesRequestKLykuaI(jBetween, wasSuccessful, arrayList);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean finishTransactions, final StoreTransaction purchase, boolean shouldConsume, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (!shouldFinishTransactions() || purchase.getType() == com.revenuecat.purchases.ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        if (finishTransactions) {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.consumeAndSave.1
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
                        AmazonBilling.this.purchasingServiceProvider.notifyFulfillment(purchase.getPurchaseToken(), FulfillmentResult.FULFILLED);
                    } else {
                        LogUtilsKt.errorLog(purchasesError);
                    }
                }
            });
        }
        this.cache.addSuccessfullyPostedToken(purchase.getPurchaseToken(), purchase.getIsAutoRenewing());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, final com.revenuecat.purchases.ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1
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
        queryAllPurchases(appUserID, new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.findPurchaseInPurchaseHistory.2
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
            public final void invoke2(List<StoreTransaction> it) {
                Object next;
                Intrinsics.checkNotNullParameter(it, "it");
                String str2 = productId;
                Iterator<T> it2 = it.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (Intrinsics.areEqual(str2, ((StoreTransaction) next).getProductIds().get(0))) {
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
        }, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getAmazonLWAConsentStatus(final Function1<? super AmazonLWAConsentStatus, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1
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
            public final void invoke2(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str, null);
                    onError.invoke(purchasesError);
                    return;
                }
                UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final Function1<AmazonLWAConsentStatus, Unit> function1 = onSuccess;
                final Function1<PurchasesError, Unit> function12 = onError;
                Function1<UserData, Unit> function13 = new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1.1

                    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1$1$WhenMappings */
                    /* JADX INFO: compiled from: AmazonBilling.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LWAConsentStatus.values().length];
                            try {
                                iArr[LWAConsentStatus.CONSENTED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[LWAConsentStatus.UNAVAILABLE.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
                        invoke2(userData);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(UserData userData) {
                        AmazonLWAConsentStatus amazonLWAConsentStatus;
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        LWAConsentStatus lWAConsentStatus = userData.getLWAConsentStatus();
                        if (lWAConsentStatus == null) {
                            function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_LWA_CONSENT_STATUS_NULL_STORE_PROBLEM));
                            return;
                        }
                        Function1<AmazonLWAConsentStatus, Unit> function14 = function1;
                        int i = WhenMappings.$EnumSwitchMapping$0[lWAConsentStatus.ordinal()];
                        if (i == 1) {
                            amazonLWAConsentStatus = AmazonLWAConsentStatus.CONSENTED;
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            amazonLWAConsentStatus = AmazonLWAConsentStatus.UNAVAILABLE;
                        }
                        function14.invoke(amazonLWAConsentStatus);
                    }
                };
                final Function1<PurchasesError, Unit> function14 = onError;
                userDataResponseListener.getUserData(function13, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                        invoke2(purchasesError2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str2 = String.format(BillingStrings.BILLING_AMAZON_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{error}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str2, null);
                        function14.invoke(error);
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.productDataHandler.getProductData(skus, marketplace, onReceive, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1
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
            public final void invoke2(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_STORE_COUNTRY, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str, null);
                    onError.invoke(purchasesError);
                    return;
                }
                UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final Function1<String, Unit> function1 = onSuccess;
                final Function1<PurchasesError, Unit> function12 = onError;
                Function1<UserData, Unit> function13 = new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
                        invoke2(userData);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(UserData userData) {
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        String marketplace = userData.getMarketplace();
                        if (marketplace == null) {
                            function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM));
                        } else {
                            function1.invoke(marketplace);
                        }
                    }
                };
                final Function1<PurchasesError, Unit> function14 = onError;
                userDataResponseListener.getUserData(function13, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                        invoke2(purchasesError2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str2 = String.format(BillingStrings.BILLING_AMAZON_ERROR_STOREFRONT, Arrays.copyOf(new Object[]{error}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str2, null);
                        function14.invoke(error);
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void getUserData(Function1<? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.userDataHandler.getUserData(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    /* JADX INFO: renamed from: isConnected, reason: from getter */
    public boolean getConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, final PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        AmazonPurchasingData.Product product = purchasingData instanceof AmazonPurchasingData.Product ? (AmazonPurchasingData.Product) purchasingData : null;
        if (product == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Amazon", "AmazonPurchaseInfo"}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
            }
            return;
        }
        final AmazonStoreProduct storeProduct = product.getStoreProduct();
        if (shouldFinishTransactions()) {
            if (replaceProductInfo == null) {
                executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2
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
                        AmazonBilling amazonBilling = AmazonBilling.this;
                        if (purchasesError2 != null) {
                            amazonBilling.onPurchaseError(purchasesError2);
                            return;
                        }
                        PurchaseResponseListener purchaseResponseListener = amazonBilling.purchaseHandler;
                        Handler handler = AmazonBilling.this.mainHandler;
                        Activity activity2 = activity;
                        String str2 = appUserID;
                        AmazonStoreProduct amazonStoreProduct = storeProduct;
                        final AmazonBilling amazonBilling2 = AmazonBilling.this;
                        final AmazonStoreProduct amazonStoreProduct2 = storeProduct;
                        final PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                        Function2<Receipt, UserData, Unit> function2 = new Function2<Receipt, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Receipt receipt, UserData userData) {
                                invoke2(receipt, userData);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Receipt receipt, UserData userData) {
                                Intrinsics.checkNotNullParameter(receipt, "receipt");
                                Intrinsics.checkNotNullParameter(userData, "userData");
                                amazonBilling2.handleReceipt(receipt, userData, amazonStoreProduct2, presentedOfferingContext2);
                            }
                        };
                        final AmazonBilling amazonBilling3 = AmazonBilling.this;
                        purchaseResponseListener.purchase(handler, activity2, str2, amazonStoreProduct, function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError3) {
                                invoke2(purchasesError3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                amazonBilling3.onPurchaseError(it);
                            }
                        });
                    }
                });
                return;
            }
            final LogIntent logIntent = LogIntent.AMAZON_WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Amazon doesn't support product changes";
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

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void normalizePurchaseData(String productID, final String purchaseToken, String storeUserID, final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        String str = this.cache.getReceiptSkus().get(purchaseToken);
        if (str != null) {
            onSuccess.invoke(str);
        } else {
            this.amazonBackend.getAmazonReceiptData(purchaseToken, storeUserID, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.normalizePurchaseData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final JSONObject response) {
                    LogHandler currentLogHandler;
                    String str2;
                    String strInvoke;
                    Intrinsics.checkNotNullParameter(response, "response");
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            String str3 = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
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
                    String termSkuFromJSON = AmazonBilling.this.getTermSkuFromJSON(response);
                    if (termSkuFromJSON == null) {
                        onError.invoke(ErrorsKt.missingTermSkuError(response));
                    } else {
                        AmazonBilling.this.cache.cacheSkusByToken(MapsKt.mapOf(TuplesKt.to(purchaseToken, termSkuFromJSON)));
                        onSuccess.invoke(termSkuFromJSON);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.normalizePurchaseData.3
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
                    onError.invoke(ErrorsKt.errorGettingReceiptInfo(error));
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.productDataHandler.onProductDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseResponse(PurchaseResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseHandler.onPurchaseResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseUpdatesHandler.onPurchaseUpdatesResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void onUserDataResponse(UserDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.userDataHandler.onUserDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseHandler.purchase(mainHandler, activity, appUserID, storeProduct, onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchases(false, (Function1<? super Map<String, StoreTransaction>, Unit>) new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryAllPurchases.1
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
            public final void invoke2(Map<String, StoreTransaction> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onReceivePurchaseHistory.invoke(CollectionsKt.toList(it.values()));
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(com.revenuecat.purchases.ProductType productType, final Set<String> productIds, final Function1<? super List<? extends StoreProduct>, Unit> onReceive, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (shouldFinishTransactions()) {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1
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
                public final void invoke2(PurchasesError purchasesError) {
                    if (purchasesError != null) {
                        onError.invoke(purchasesError);
                        return;
                    }
                    UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                    final AmazonBilling amazonBilling = AmazonBilling.this;
                    final Set<String> set = productIds;
                    final Function1<List<? extends StoreProduct>, Unit> function1 = onReceive;
                    final Function1<PurchasesError, Unit> function12 = onError;
                    userDataResponseListener.getUserData(new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
                            invoke2(userData);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(UserData userData) {
                            Intrinsics.checkNotNullParameter(userData, "userData");
                            final Date now = amazonBilling.dateProvider.getNow();
                            ProductDataResponseListener productDataResponseListener = amazonBilling.productDataHandler;
                            Set<String> set2 = set;
                            String marketplace = userData.getMarketplace();
                            Intrinsics.checkNotNullExpressionValue(marketplace, "userData.marketplace");
                            final AmazonBilling amazonBilling2 = amazonBilling;
                            final Set<String> set3 = set;
                            final Function1<List<? extends StoreProduct>, Unit> function13 = function1;
                            Function1<List<? extends StoreProduct>, Unit> function14 = new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                                    invoke2(list);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(List<? extends StoreProduct> it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    amazonBilling2.trackAmazonQueryProductDetailsRequestIfNeeded(true, now, set3);
                                    function13.invoke(it);
                                }
                            };
                            final AmazonBilling amazonBilling3 = amazonBilling;
                            final Set<String> set4 = set;
                            final Function1<PurchasesError, Unit> function15 = function12;
                            productDataResponseListener.getProductData(set2, marketplace, function14, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                                    invoke2(purchasesError2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PurchasesError it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    amazonBilling3.trackAmazonQueryProductDetailsRequestIfNeeded(false, now, set4);
                                    function15.invoke(it);
                                }
                            });
                        }
                    }, onError);
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (shouldFinishTransactions()) {
            queryPurchases(true, onSuccess, onError);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseUpdatesHandler.queryPurchases(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        if (shouldFinishTransactions()) {
            this.purchasingServiceProvider.registerListener(this.applicationContext, this);
            this.connected = true;
            BillingAbstract.StateListener stateListener = getStateListener();
            if (stateListener != null) {
                stateListener.onConnected();
            }
            executePendingRequests();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long delayMilliseconds) {
        runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startConnection();
            }
        });
    }
}
