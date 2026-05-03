package com.revenuecat.purchases.common;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeKt;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.networking.PostReceiptResponseKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterRoot;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Backend.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ8\u0010h\u001a\u00020\u00142\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000f2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015J\u0006\u0010m\u001a\u00020\u0014J\u0006\u0010n\u001a\u00020\u0014J\u0018\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u0016H\u0002J6\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u00152\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015JS\u0010u\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020 2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u00152'\u0010x\u001a#\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00140\u001fJJ\u0010y\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020 2\u0018\u0010w\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u001f2\u0018\u0010x\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00140\u001fJ.\u0010z\u001a\u00020\u00142\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00140\u00152\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015J>\u0010{\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020 2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u00140\u00152\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015JD\u0010|\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000f0~2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u00140\u00152\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015JD\u0010\u007f\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000f2\u0018\u0010k\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015JI\u0010\u0080\u0001\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u000f2\u0007\u0010\u0082\u0001\u001a\u00020\u000f2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u00152\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u0015JD\u0010\u0083\u0001\u001a\u00020\u00142\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u0002010\u000e2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00140\u00152\u0018\u0010l\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001fJm\u0010\u0085\u0001\u001a\u00020\u00142\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00140\u001328\u0010l\u001a4\u0012\u0014\u0012\u00120\u0016¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u008c\u0001\u0012\u0014\u0012\u00120 ¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u008d\u0001\u0012\u0004\u0012\u00020\u00140\u001fJÕ\u0001\u0010\u008e\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020\u000f2\u0007\u0010\u0090\u0001\u001a\u00020 2\u0007\u0010\u0091\u0001\u001a\u00020 2#\u0010\u0092\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0093\u00010\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0016\u0010w\u001a\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00140\u0015j\u0002`F2B\u0010x\u001a>\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110H¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(I\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00140Gj\u0002`KJ-\u0010\u009c\u0001\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020\u000f2\u0013\u0010\u009e\u0001\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00140\u0015Jy\u0010\u009f\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010 \u0001\"\u0005\b\u0001\u0010¡\u0001*\"\u0012\u0004\u0012\u00020\u001d\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u0003H \u0001\u0012\u0005\u0012\u0003H¡\u00010\u00120\u00110\r2\b\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0007\u0010¤\u0001\u001a\u00020\u001d2\u0015\u0010¥\u0001\u001a\u0010\u0012\u0005\u0012\u0003H \u0001\u0012\u0005\u0012\u0003H¡\u00010\u00122\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002Jg\u0010¦\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010§\u0001\"\u0005\b\u0001\u0010¨\u0001*\u0016\u0012\u0005\u0012\u0003H§\u0001\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003H¨\u00010\u00110\r2\b\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010¤\u0001\u001a\u0003H§\u00012\b\u0010¥\u0001\u001a\u0003H¨\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002¢\u0006\u0003\u0010©\u0001R¢\u0001\u0010\u0018\u001a@\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012,\u0012*\u0012&\u0012$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`\u00170\u00110\r2D\u0010\f\u001a@\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012,\u0012*\u0012&\u0012$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`\u00170\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000RÄ\u0001\u0010%\u001aQ\u0012\u0004\u0012\u00020\u001d\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u0015\u0012%\u0012#\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`$0\u00110\r2U\u0010\f\u001aQ\u0012\u0004\u0012\u00020\u001d\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u0015\u0012%\u0012#\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`$0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u009a\u0001\u0010)\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`(0\u00110\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`(0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u009a\u0001\u0010.\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`-0\u00110\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`-0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cRº\u0001\u00103\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`20\u00110\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`20\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000Rº\u0001\u00107\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`60\u00110\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`60\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cRÐ\u0001\u0010>\u001aW\u0012\u0004\u0012\u00020\u001d\u0012M\u0012K\u0012G\u0012E\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110;¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`=0\u00110\r2[\u0010\f\u001aW\u0012\u0004\u0012\u00020\u001d\u0012M\u0012K\u0012G\u0012E\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110;¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`=0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR®\u0001\u0010B\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`A0\u00110\r2J\u0010\f\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f0\u0012j\u0002`A0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\u0096\u0002\u0010M\u001az\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012f\u0012d\u0012`\u0012^\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00140\u0015j\u0002`F\u0012@\u0012>\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110H¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(I\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00140Gj\u0002`K0\u0012j\u0002`L0\u00110\r2~\u0010\f\u001az\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012f\u0012d\u0012`\u0012^\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00140\u0015j\u0002`F\u0012@\u0012>\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110H¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(I\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00140Gj\u0002`K0\u0012j\u0002`L0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001a\"\u0004\bO\u0010\u001cR\u009a\u0001\u0010R\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`Q0\u00110\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`Q0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001a\"\u0004\bT\u0010\u001cRj\u0010W\u001a$\u0012\u0004\u0012\u00020\u000f\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00140\u0015j\u0002`V0\u00110\r2(\u0010\f\u001a$\u0012\u0004\u0012\u00020\u000f\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00140\u0015j\u0002`V0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001a\"\u0004\bY\u0010\u001cR\u0011\u0010Z\u001a\u00020[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u009a\u0001\u0010`\u001a<\u0012\u0004\u0012\u00020\u001d\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`_0\u00110\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020\u001d\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`_0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001a\"\u0004\bb\u0010\u001cR\u009a\u0001\u0010e\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`d0\u00110\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020\u000f\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00150\u0012j\u0002`d0\u00110\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u001a\"\u0004\bg\u0010\u001c¨\u0006«\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "eventsDispatcher", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;Lcom/revenuecat/purchases/common/BackendHelper;)V", "<set-?>", "", "", "", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function0;", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/AliasCallback;", "aliasCallbacks", "getAliasCallbacks", "()Ljava/util/Map;", "setAliasCallbacks", "(Ljava/util/Map;)V", "Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isServerError", "Lcom/revenuecat/purchases/common/CustomerInfoCallback;", "callbacks", "getCallbacks", "setCallbacks", "Lcom/revenuecat/purchases/common/CreateSupportTicketCallback;", "createSupportTicketCallbacks", "getCreateSupportTicketCallbacks", "setCreateSupportTicketCallbacks", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "Lcom/revenuecat/purchases/common/CustomerCenterCallback;", "customerCenterCallbacks", "getCustomerCenterCallbacks", "setCustomerCenterCallbacks", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/DiagnosticsCallback;", "diagnosticsCallbacks", "getDiagnosticsCallbacks", "setDiagnosticsCallbacks", "Lcom/revenuecat/purchases/common/IdentifyCallback;", "identifyCallbacks", "getIdentifyCallbacks", "setIdentifyCallbacks", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "Lcom/revenuecat/purchases/common/GetOfferingsErrorHandlingBehavior;", "errorHandlingBehavior", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "offeringsCallbacks", "getOfferingsCallbacks", "setOfferingsCallbacks", "Lcom/revenuecat/purchases/common/PaywallEventsCallback;", "paywallEventsCallbacks", "getPaywallEventsCallbacks", "setPaywallEventsCallbacks", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "postReceiptErrorHandlingBehavior", "body", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/ProductEntitlementCallback;", "productEntitlementCallbacks", "getProductEntitlementCallbacks", "setProductEntitlementCallbacks", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "Lcom/revenuecat/purchases/common/RedeemWebPurchaseCallback;", "redeemWebPurchaseCallbacks", "getRedeemWebPurchaseCallbacks", "setRedeemWebPurchaseCallbacks", "verificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "Lcom/revenuecat/purchases/common/VirtualCurrenciesCallback;", "virtualCurrenciesCallbacks", "getVirtualCurrenciesCallbacks", "setVirtualCurrenciesCallbacks", "Lcom/revenuecat/purchases/common/networking/WebBillingProductsResponse;", "Lcom/revenuecat/purchases/common/WebBillingProductsCallback;", "webBillingProductsCallbacks", "getWebBillingProductsCallbacks", "setWebBillingProductsCallbacks", "aliasUsers", "oldAppUserID", "newAppUserID", "onSuccessHandler", "onErrorHandler", "clearCaches", "close", "determinePostReceiptErrorHandlingBehavior", "responseCode", "", "purchasesError", "getCustomerCenterConfig", "appUserID", "getCustomerInfo", "appInBackground", "onSuccess", "onError", "getOfferings", "getProductEntitlementMapping", "getVirtualCurrencies", "getWebBillingProducts", "productIds", "", "logIn", "postCreateSupportTicket", "email", "description", "postDiagnostics", "diagnosticsList", "postEvents", "paywallEventRequest", "Lcom/revenuecat/purchases/common/events/EventsRequest;", "baseURL", "Ljava/net/URL;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "error", "shouldMarkAsSynced", "postReceiptData", com.facebook.appevents.internal.Constants.GP_IAP_PURCHASE_TOKEN, "isRestore", "finishTransactions", "subscriberAttributes", "", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "postRedeemWebPurchase", "redemptionToken", "onResultHandler", "addBackgroundAwareCallback", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, NotificationCompat.CATEGORY_CALL, "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "cacheKey", "functions", "addCallback", "K", "F", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/lang/Object;Ljava/lang/Object;Lcom/revenuecat/purchases/common/Delay;)V", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Backend {
    private static final String APP_USER_ID = "app_user_id";
    private static final String FETCH_TOKEN = "fetch_token";
    private static final String NEW_APP_USER_ID = "new_app_user_id";
    private static final int POST_RECEIPT_PAYLOAD_VERSION = 1;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> aliasCallbacks;
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> callbacks;
    private volatile Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> createSupportTicketCallbacks;
    private volatile Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> customerCenterCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> offeringsCallbacks;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> postReceiptCallbacks;
    private volatile Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> productEntitlementCallbacks;
    private volatile Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> redeemWebPurchaseCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> virtualCurrenciesCallbacks;
    private volatile Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> webBillingProductsCallbacks;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.Backend$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);

    /* JADX INFO: compiled from: Backend.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/common/Backend$Companion;", "", "()V", "APP_USER_ID", "", "FETCH_TOKEN", "NEW_APP_USER_ID", "POST_RECEIPT_PAYLOAD_VERSION", "", "json", "Lkotlinx/serialization/json/Json;", "getJson$purchases_defaultsBc8Release$annotations", "getJson$purchases_defaultsBc8Release", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJson$purchases_defaultsBc8Release$annotations() {
        }

        public final Json getJson$purchases_defaultsBc8Release() {
            return Backend.json;
        }
    }

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.aliasCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
        this.customerCenterCallbacks = new LinkedHashMap();
        this.createSupportTicketCallbacks = new LinkedHashMap();
        this.redeemWebPurchaseCallbacks = new LinkedHashMap();
        this.virtualCurrenciesCallbacks = new LinkedHashMap();
        this.webBillingProductsCallbacks = new LinkedHashMap();
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair<? extends S, ? extends E> pair, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
        boolean zContainsKey = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
        if (backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.d(str, str2);
            }
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKeyCopy$default;
        } else {
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
        }
        addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, pair, delay);
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
        boolean zContainsKey2 = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
        if (!backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey2) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                String str3 = "[Purchases] - " + logLevel2.name();
                String str4 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                currentLogHandler2.d(str3, str4);
            }
            List<Pair<S, E>> listRemove = map.remove(backgroundAwareCallbackCacheKeyCopy$default2);
            if (listRemove != null) {
                List<Pair<S, E>> list = listRemove.isEmpty() ? null : listRemove;
                if (list != null) {
                    if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                        List<Pair<S, E>> list2 = map.get(backgroundAwareCallbackCacheKey);
                        if (list2 != null) {
                            list2.addAll(list);
                        }
                    } else {
                        map.put(backgroundAwareCallbackCacheKey, list);
                    }
                }
            }
        }
    }

    static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair pair, Delay delay, int i, Object obj) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, pair, delay);
    }

    private final <K, F> void addCallback(Map<K, List<F>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k, F f, Delay delay) {
        if (!map.containsKey(k)) {
            map.put(k, CollectionsKt.mutableListOf(f));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        List<F> list = map.get(k);
        Intrinsics.checkNotNull(list);
        list.add(f);
    }

    static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Object obj2, Delay delay, int i, Object obj3) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, obj2, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int responseCode, PurchasesError purchasesError) {
        return RCHTTPStatusCodes.INSTANCE.isServerError(responseCode) ? PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME : purchasesError.getCode() == PurchasesErrorCode.UnsupportedError ? PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME : PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED;
    }

    public final void aliasUsers(final String oldAppUserID, final String newAppUserID, Function0<Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Backend backend;
        Intrinsics.checkNotNullParameter(oldAppUserID, "oldAppUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{oldAppUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$aliasUsers$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), new Endpoint.AliasUsers(oldAppUserID), MapsKt.mapOf(TuplesKt.to("app_user_id", oldAppUserID), TuplesKt.to("new_app_user_id", newAppUserID)), null, this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend2 = this;
                List<String> list = listListOfNotNull;
                synchronized (backend2) {
                    listRemove = backend2.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function0) ((Pair) it.next()).component1()).invoke();
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this;
                List<String> list = listListOfNotNull;
                synchronized (backend2) {
                    listRemove = backend2.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
            } catch (Throwable th) {
                th = th;
                backend = this;
            }
            try {
                addCallback$default(backend, this.aliasCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.to(onSuccessHandler, onErrorHandler), null, 16, null);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                throw th3;
            }
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> getAliasCallbacks() {
        return this.aliasCallbacks;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> getCreateSupportTicketCallbacks() {
        return this.createSupportTicketCallbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> getCustomerCenterCallbacks() {
        return this.customerCenterCallbacks;
    }

    public final void getCustomerCenterConfig(String appUserID, Function1<? super CustomerCenterConfigData, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Backend backend;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetCustomerCenterConfig getCustomerCenterConfig = new Endpoint.GetCustomerCenterConfig(appUserID);
        final String path$default = Endpoint.getPath$default(getCustomerCenterConfig, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerCenterConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerCenterConfig, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsBc8Release = Backend.INSTANCE.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.getSerializersModule();
                                function1.invoke(((CustomerCenterRoot) json$purchases_defaultsBc8Release.decodeFromString(CustomerCenterRoot.INSTANCE.serializer(), payload)).getCustomerCenter());
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
                try {
                    backend.addCallback(this.customerCenterCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.NONE);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                backend = this;
            }
        }
    }

    public final void getCustomerInfo(String appUserID, boolean appInBackground, Function1<? super CustomerInfo, Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Backend backend;
        Throwable th;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        Throwable th2;
        Backend backend2;
        Delay delay;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path$default = Endpoint.getPath$default(getCustomerInfo, false, 1, null);
        synchronized (this) {
            try {
                if (this.postReceiptCallbacks.isEmpty()) {
                    try {
                        backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(path$default), appInBackground);
                    } catch (Throwable th3) {
                        th = th3;
                        backend = this;
                        throw th;
                    }
                } else {
                    backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.plus((Collection<? extends String>) CollectionsKt.listOf(path$default), String.valueOf(this.callbacks.size())), appInBackground);
                }
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
            } catch (Throwable th4) {
                backend = this;
                th = th4;
            }
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerInfo, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend3 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                synchronized (backend3) {
                    listRemove = backend3.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function1.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                            }
                        } catch (JSONException e) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                            LogUtilsKt.errorLog(purchasesError2);
                            function2.invoke(purchasesError2, false);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend3 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                synchronized (backend3) {
                    listRemove = backend3.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                    }
                }
            }
        };
        synchronized (this) {
            if (appInBackground) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th5) {
                    th2 = th5;
                    backend2 = this;
                    throw th2;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th6) {
                    th = th6;
                    backend2 = this;
                    th2 = th;
                    throw th2;
                }
            }
            backend2 = this;
            try {
                backend2.addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, TuplesKt.to(onSuccess, onError), delay);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th7) {
                th = th7;
                th2 = th;
                throw th2;
            }
        }
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final void getOfferings(String appUserID, boolean appInBackground, Function2<? super JSONObject, ? super HTTPResponseOriginalSource, Unit> onSuccess, Function2<? super PurchasesError, ? super GetOfferingsErrorHandlingBehavior, Unit> onError) {
        Delay delay;
        Backend backend;
        Throwable th;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getOfferings, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getOfferings, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend2) {
                    listRemove = backend2.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function2 function2 = (Function2) pair.component1();
                        Function2 function22 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function2.invoke(result.getBody(), HTTPResponseOriginalSourceKt.getOriginalDataSource(result));
                            } catch (JSONException e) {
                                GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior = GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS;
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function22.invoke(purchasesError, getOfferingsErrorHandlingBehavior);
                            }
                        } else {
                            GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior2 = RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) ? GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS : GetOfferingsErrorHandlingBehavior.SHOULD_NOT_FALLBACK;
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function22.invoke(purchasesError2, getOfferingsErrorHandlingBehavior2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend2) {
                    listRemove = backend2.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS);
                    }
                }
            }
        };
        synchronized (this) {
            if (appInBackground) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    backend = this;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    backend = this;
                    th = th;
                    throw th;
                }
            }
            backend = this;
            try {
                backend.addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.to(onSuccess, onError), delay);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final void getProductEntitlementMapping(Function1<? super ProductEntitlementMapping, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Backend backend;
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path$default = Endpoint.getPath$default(getProductEntitlementMapping, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getProductEntitlementMapping, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(ProductEntitlementMapping.INSTANCE.fromNetwork$purchases_defaultsBc8Release(result.getBody(), result));
                            } catch (JSONException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function12.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
                try {
                    backend.addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                backend = this;
            }
        }
    }

    public final synchronized Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> getRedeemWebPurchaseCallbacks() {
        return this.redeemWebPurchaseCallbacks;
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final void getVirtualCurrencies(String appUserID, boolean appInBackground, Function1<? super VirtualCurrencies, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Delay delay;
        Backend backend;
        Throwable th;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetVirtualCurrencies getVirtualCurrencies = new Endpoint.GetVirtualCurrencies(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getVirtualCurrencies, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getVirtualCurrencies$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getVirtualCurrencies, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend2) {
                    listRemove = backend2.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(result));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            } catch (JSONException e3) {
                                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError3);
                                function12.invoke(purchasesError3);
                            }
                        } else {
                            PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError4);
                            function12.invoke(purchasesError4);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend2) {
                    listRemove = backend2.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            if (appInBackground) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    backend = this;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    backend = this;
                    th = th;
                    throw th;
                }
            }
            backend = this;
            try {
                backend.addBackgroundAwareCallback(this.virtualCurrenciesCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.to(onSuccess, onError), delay);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> getVirtualCurrenciesCallbacks() {
        return this.virtualCurrenciesCallbacks;
    }

    public final void getWebBillingProducts(String appUserID, Set<String> productIds, Function1<? super WebBillingProductsResponse, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Backend backend;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.WebBillingGetProducts webBillingGetProducts = new Endpoint.WebBillingGetProducts(appUserID, productIds);
        final String path$default = Endpoint.getPath$default(webBillingGetProducts, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWebBillingProducts$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), webBillingGetProducts, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsBc8Release = Backend.INSTANCE.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.getSerializersModule();
                                function1.invoke((WebBillingProductsResponse) json$purchases_defaultsBc8Release.decodeFromString(WebBillingProductsResponse.INSTANCE.serializer(), payload));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
            } catch (Throwable th) {
                th = th;
                backend = this;
            }
            try {
                backend.addCallback(this.webBillingProductsCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.to(onSuccess, onError), Delay.NONE);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                throw th3;
            }
        }
    }

    public final synchronized Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> getWebBillingProductsCallbacks() {
        return this.webBillingProductsCallbacks;
    }

    public final void logIn(final String appUserID, final String newAppUserID, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Backend backend;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{appUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, MapsKt.mapOf(TuplesKt.to("app_user_id", appUserID), TuplesKt.to("new_app_user_id", newAppUserID)), CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("app_user_id", appUserID), TuplesKt.to("new_app_user_id", newAppUserID)}), this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend2 = this;
                List<String> list = listListOfNotNull;
                synchronized (backend2) {
                    listRemove = backend2.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function2 function2 = (Function2) pair.component1();
                        Function1 function1 = (Function1) pair.component2();
                        boolean z = result.getResponseCode() == 201;
                        if (result.getBody().length() > 0) {
                            function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z));
                        } else {
                            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                            LogUtilsKt.errorLog(purchasesError2);
                            function1.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this;
                List<String> list = listListOfNotNull;
                synchronized (backend2) {
                    listRemove = backend2.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
            } catch (Throwable th) {
                th = th;
                backend = this;
            }
            try {
                addCallback$default(backend, this.identifyCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.to(onSuccessHandler, onErrorHandler), null, 16, null);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                throw th3;
            }
        }
    }

    public final void postCreateSupportTicket(String appUserID, String email, String description, Function1<? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.PostCreateSupportTicket postCreateSupportTicket = Endpoint.PostCreateSupportTicket.INSTANCE;
        final String path$default = Endpoint.getPath$default(postCreateSupportTicket, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(APP_USER_ID, appUserID), TuplesKt.to("customer_email", email), TuplesKt.to("issue_description", description));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postCreateSupportTicket$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postCreateSupportTicket, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(Boolean.valueOf(result.getBody().optBoolean("sent", false)));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.createSupportTicketCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, Function1<? super JSONObject, Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) throws Throwable {
        Backend backend;
        Intrinsics.checkNotNullParameter(diagnosticsList, "diagnosticsList");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        List<? extends JSONObject> list = diagnosticsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final ArrayList arrayList2 = arrayList;
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to("entries", new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.INSTANCE.getDiagnosticsURL(), Endpoint.PostDiagnostics.INSTANCE, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                List<String> list2 = arrayList2;
                synchronized (backend2) {
                    listRemove = backend2.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                List<String> list2 = arrayList2;
                synchronized (backend2) {
                    listRemove = backend2.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function2) ((Pair) it2.next()).component2()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
                try {
                    backend.addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList2, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                backend = this;
            }
        }
    }

    public final void postEvents(final EventsRequest paywallEventRequest, final URL baseURL, Delay delay, Function0<Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) {
        Backend backend;
        Intrinsics.checkNotNullParameter(paywallEventRequest, "paywallEventRequest");
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
        defaultJson.getSerializersModule();
        final Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(defaultJson.encodeToJsonElement(EventsRequest.INSTANCE.serializer(), paywallEventRequest));
        if (mapAsMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, true);
            return;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postEvents$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, baseURL, Endpoint.PostEvents.INSTANCE, mapAsMap, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend2) {
                    listRemove = backend2.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function0 function0 = (Function0) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function0.invoke();
                        } else {
                            function2.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend2) {
                    listRemove = backend2.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
                try {
                    backend.addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), TuplesKt.to(onSuccessHandler, onErrorHandler), delay);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                backend = this;
            }
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean isRestore, boolean finishTransactions, Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes, ReceiptInfo receiptInfo, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, Function1<? super PostReceiptResponse, Unit> onSuccess, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        int i;
        Map mapMapOf;
        ArrayList arrayList;
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes2 = subscriberAttributes;
        Intrinsics.checkNotNullParameter(subscriberAttributes2, "subscriberAttributes");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{purchaseToken, appUserID, String.valueOf(isRestore), String.valueOf(finishTransactions), subscriberAttributes2.toString(), receiptInfo.toString(), purchasesAreCompletedBy.toString()});
        Pair[] pairArr = new Pair[21];
        pairArr[0] = TuplesKt.to(FETCH_TOKEN, purchaseToken);
        pairArr[1] = TuplesKt.to(DiagnosticsTracker.PRODUCT_IDS_KEY, receiptInfo.getProductIDs());
        pairArr[2] = TuplesKt.to("platform_product_ids", receiptInfo.getPlatformProductIds());
        pairArr[3] = TuplesKt.to(APP_USER_ID, appUserID);
        pairArr[4] = TuplesKt.to("is_restore", Boolean.valueOf(isRestore));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        pairArr[5] = TuplesKt.to("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = receiptInfo.getPresentedOfferingContext();
        pairArr[6] = TuplesKt.to("presented_placement_identifier", presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext3 = receiptInfo.getPresentedOfferingContext();
        if (presentedOfferingContext3 == null || (targetingContext = presentedOfferingContext3.getTargetingContext()) == null) {
            i = 1;
            mapMapOf = null;
        } else {
            i = 1;
            mapMapOf = MapsKt.mapOf(TuplesKt.to("revision", Integer.valueOf(targetingContext.getRevision())), TuplesKt.to("rule_id", targetingContext.getRuleId()));
        }
        pairArr[7] = TuplesKt.to("applied_targeting_rule", mapMapOf);
        pairArr[8] = TuplesKt.to("observer_mode", Boolean.valueOf(!finishTransactions));
        String lowerCase = purchasesAreCompletedBy.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        pairArr[9] = TuplesKt.to("purchase_completed_by", lowerCase);
        pairArr[10] = TuplesKt.to(FirebaseAnalytics.Param.PRICE, receiptInfo.getPrice());
        pairArr[11] = TuplesKt.to(FirebaseAnalytics.Param.CURRENCY, receiptInfo.getCurrency());
        if (subscriberAttributes2.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes2 = null;
        }
        pairArr[12] = TuplesKt.to("attributes", subscriberAttributes2);
        pairArr[13] = TuplesKt.to("normal_duration", receiptInfo.getDuration());
        pairArr[14] = TuplesKt.to("store_user_id", receiptInfo.getStoreUserID());
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            List<PricingPhase> list = pricingPhases;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(BackendKt.toMap((PricingPhase) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        pairArr[15] = TuplesKt.to("pricing_phases", arrayList);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        pairArr[16] = TuplesKt.to("proration_mode", replacementMode != null ? ReplacementModeKt.getBackendName(replacementMode) : null);
        pairArr[17] = TuplesKt.to("initiation_source", initiationSource.getPostReceiptFieldValue());
        pairArr[18] = TuplesKt.to("paywall", paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null);
        pairArr[19] = TuplesKt.to("sdk_originated", Boolean.valueOf(receiptInfo.getSdkOriginated()));
        pairArr[20] = TuplesKt.to("payload_version", Integer.valueOf(i));
        final Map mapFilterNotNullValues = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr));
        Pair[] pairArr2 = new Pair[2];
        pairArr2[0] = TuplesKt.to(APP_USER_ID, appUserID);
        pairArr2[i] = TuplesKt.to(FETCH_TOKEN, purchaseToken);
        final List listListOf = CollectionsKt.listOf((Object[]) pairArr2);
        Pair[] pairArr3 = new Pair[2];
        pairArr3[0] = TuplesKt.to("price_string", receiptInfo.getFormattedPrice());
        pairArr3[i] = TuplesKt.to("marketplace", receiptInfo.getMarketplace());
        final Map mapFilterNotNullValues2 = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr3));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, mapFilterNotNullValues, listListOf, MapsKt.plus(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), mapFilterNotNullValues2), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Backend backend2 = this.this$0;
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function3 function3 = (Function3) pair.component2();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function1.invoke(PostReceiptResponseKt.buildPostReceiptResponse(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                function3.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError), result.getBody());
                            }
                        } catch (JSONException e) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                            LogUtilsKt.errorLog(purchasesError2);
                            function3.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function3) ((Pair) it2.next()).component2()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.to(onSuccess, onError), null, 16, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postRedeemWebPurchase(String appUserID, String redemptionToken, Function1<? super RedeemWebPurchaseListener.Result, Unit> onResultHandler) throws Throwable {
        Backend backend;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(redemptionToken, "redemptionToken");
        Intrinsics.checkNotNullParameter(onResultHandler, "onResultHandler");
        final Endpoint.PostRedeemWebPurchase postRedeemWebPurchase = Endpoint.PostRedeemWebPurchase.INSTANCE;
        final String path$default = Endpoint.getPath$default(postRedeemWebPurchase, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to("redemption_token", redemptionToken), TuplesKt.to(APP_USER_ID, appUserID));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postRedeemWebPurchase$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postRedeemWebPurchase, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Function1 function1 = (Function1) it.next();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(new RedeemWebPurchaseListener.Result.Success(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result)));
                        } else {
                            Integer backendErrorCode = result.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidWebRedemptionToken.getValue();
                            if (backendErrorCode != null && backendErrorCode.intValue() == value) {
                                function1.invoke(RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE);
                            } else {
                                int value2 = BackendErrorCode.BackendExpiredWebRedemptionToken.getValue();
                                if (backendErrorCode != null && backendErrorCode.intValue() == value2) {
                                    JSONObject body = result.getBody();
                                    JSONObject jSONObjectOptJSONObject = body.optJSONObject("purchase_redemption_error_info");
                                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("obfuscated_email") : null;
                                    if (strOptString == null) {
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing expired redemption token response: " + body, null);
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    } else {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Expired(strOptString));
                                    }
                                } else {
                                    int value3 = BackendErrorCode.BackendPurchaseBelongsToOtherUser.getValue();
                                    if (backendErrorCode != null && backendErrorCode.intValue() == value3) {
                                        function1.invoke(RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE);
                                    } else {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend2 = this.this$0;
                String str = path$default;
                synchronized (backend2) {
                    listRemove = backend2.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(new RedeemWebPurchaseListener.Result.Error(error));
                    }
                }
            }
        };
        synchronized (this) {
            try {
                backend = this;
                try {
                    backend.addCallback(this.redeemWebPurchaseCallbacks, asyncCall, this.dispatcher, path$default, onResultHandler, Delay.NONE);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                backend = this;
            }
        }
    }

    public final synchronized void setAliasCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.aliasCallbacks = map;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized void setCreateSupportTicketCallbacks(Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.createSupportTicketCallbacks = map;
    }

    public final synchronized void setCustomerCenterCallbacks(Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customerCenterCallbacks = map;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final synchronized void setRedeemWebPurchaseCallbacks(Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.redeemWebPurchaseCallbacks = map;
    }

    public final synchronized void setVirtualCurrenciesCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.virtualCurrenciesCallbacks = map;
    }

    public final synchronized void setWebBillingProductsCallbacks(Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.webBillingProductsCallbacks = map;
    }
}
