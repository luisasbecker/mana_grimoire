package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.net.MailTo;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.SharedConstants;
import com.revenuecat.purchases.customercenter.CustomActionData;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.customercenter.CustomerCenterManagementOption;
import com.revenuecat.purchases.customercenter.Resumable;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleStoreProductKt;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgs;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.extensions.SubscriptionOptionExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterNavigationState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.DefaultDateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpener;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpeningMethod;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: CustomerCenterViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ·\u00012\u00020\u00012\u00020\u0002:\u0002·\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010 \u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J8\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0082@¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010:\u001a\u00020)H\u0016J\u000e\u0010;\u001a\u00020&H\u0096@¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020&H\u0016J&\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@2\u0014\u0010A\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010C\u0012\u0004\u0012\u00020&0BH\u0002J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u0002030(2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010E\u001a\u00020FH\u0002J \u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020/H\u0082@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u0016H\u0002J\u001a\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020JH\u0002J \u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020JH\u0082@¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020&H\u0002J\u001c\u0010Y\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010Z\u001a\u0004\u0018\u000101H\u0002J\u0018\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020^H\u0002J<\u0010_\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\b\u0010V\u001a\u0004\u0018\u00010J2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010`\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0082@¢\u0006\u0002\u0010aJ4\u0010b\u001a\u00020&2\u0006\u0010c\u001a\u00020/2\u0006\u0010d\u001a\u00020/2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020&0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020&0fH\u0002J\u001a\u0010h\u001a\u00020\f2\u0006\u0010`\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0002J\u001a\u0010i\u001a\u00020\f2\u0006\u0010`\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0002J\u0018\u0010j\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010k\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020&H\u0002J8\u0010n\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010V\u001a\u00020J2\u0006\u0010T\u001a\u00020U2\u0006\u0010:\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0096@¢\u0006\u0002\u0010aJ\u000e\u0010o\u001a\u00020&H\u0097@¢\u0006\u0002\u0010<J\u0016\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010qJ,\u0010r\u001a\b\u0012\u0004\u0012\u0002010(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0082@¢\u0006\u0002\u0010sJ$\u0010t\u001a\u00020&2\u0006\u0010`\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010Z\u001a\u0004\u0018\u000101H\u0002J\u0010\u0010u\u001a\u00020&2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020&2\u0006\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020&H\u0002J\u001a\u0010{\u001a\u00020&2\u0006\u0010`\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0002J\u0018\u0010|\u001a\u00020&2\u0006\u0010E\u001a\u00020F2\u0006\u00102\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020&2\u0006\u0010E\u001a\u00020FH\u0002J\u0011\u0010\u007f\u001a\u00020&2\u0007\u0010\u0080\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0081\u0001\u001a\u00020&H\u0002J%\u0010\u0082\u0001\u001a\u00020&2\u0007\u0010\u0083\u0001\u001a\u00020P2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0096@¢\u0006\u0003\u0010\u0086\u0001J\t\u0010\u0087\u0001\u001a\u00020&H\u0016J\t\u0010\u0088\u0001\u001a\u00020&H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020&2\u0007\u0010\u008a\u0001\u001a\u00020\fH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020&2\u0006\u0010v\u001a\u00020wH\u0016J \u0010\u008c\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020&0fH\u0016J$\u0010\u008e\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0007\u0010\u008f\u0001\u001a\u00020/2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J#\u0010\u0092\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010`\u001a\u00020)2\b\u0010Z\u001a\u0004\u0018\u000101H\u0016J\u001b\u0010\u0093\u0001\u001a\u00020&2\u0007\u0010\u0094\u0001\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\fH\u0016J\u000f\u0010\u0096\u0001\u001a\u00020&H\u0096@¢\u0006\u0002\u0010<J\t\u0010\u0097\u0001\u001a\u00020&H\u0016J\u000f\u0010\u0098\u0001\u001a\u00020&H\u0096@¢\u0006\u0002\u0010<J\u0012\u0010\u0099\u0001\u001a\u00020&2\u0007\u0010\u009a\u0001\u001a\u000201H\u0016J#\u0010\u009b\u0001\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u009c\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010\u009d\u0001J\t\u0010\u009e\u0001\u001a\u00020&H\u0016J\u001a\u0010\u009f\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0007\u0010 \u0001\u001a\u00020/H\u0002J\u0011\u0010¡\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\t\u0010¢\u0001\u001a\u00020&H\u0016J\u001b\u0010£\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0019\u0010¦\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010V\u001a\u00020JH\u0002J\u001b\u0010§\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J,\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020)0(2\t\u0010©\u0001\u001a\u0004\u0018\u0001012\b\u0010ª\u0001\u001a\u00030«\u00012\u0006\u00106\u001a\u000207H\u0002J&\u0010¬\u0001\u001a\u00020&2\u0007\u0010`\u001a\u00030\u00ad\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010®\u0001\u001a\u00020/H\u0002J\t\u0010¯\u0001\u001a\u00020&H\u0016J\u0011\u0010°\u0001\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010±\u0001\u001a\u00020H*\u00030²\u0001H\u0002J\u001e\u0010³\u0001\u001a\u00020**\u00020*2\u0006\u0010p\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\u0018H\u0002J\r\u0010µ\u0001\u001a\u00020**\u00020*H\u0002J,\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020)0(*\b\u0012\u0004\u0012\u00020)0(2\t\u0010©\u0001\u001a\u0004\u0018\u0001012\u0006\u00106\u001a\u000207H\u0002R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¸\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "dateFormatter", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;Ljava/util/Locale;Landroidx/compose/material3/ColorScheme;ZLcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "_actionError", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/PurchasesError;", "_colorScheme", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_lastLocaleList", "Landroidx/core/os/LocaleListCompat;", "_state", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "actionError", "Landroidx/compose/runtime/State;", "getActionError", "()Landroidx/compose/runtime/State;", "impressionCreationData", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$CreationData;", "shouldRefreshOnResume", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "wasBackgrounded", "clearActionError", "", "computeMainScreenPaths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;", "contactSupport", "context", "Landroid/content/Context;", "supportEmail", "", "createPurchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "transaction", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails;", "entitlement", "Lcom/revenuecat/purchases/EntitlementInfo;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails;Lcom/revenuecat/purchases/EntitlementInfo;Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;Ljava/util/Locale;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissPromotionalOffer", "originalPath", "dismissRestoreDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissSupportTicketSuccessSnackbar", "displayFeedbackSurvey", "feedbackSurvey", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "onAnswerSubmitted", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "findActiveTransactions", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "findLatestExpiredSubscription", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails$Subscription;", "findTargetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "targetProductId", "sourceBasePlan", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentLocaleList", "getCustomerCenterSubscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "offerIdentifier", "targetProduct", "getPromotionalSubscriptionOption", "promotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "product", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/models/StoreProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goBackToMain", "handleCancelPath", "purchaseInformation", "handlePaywallError", "message", "errorCode", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "handlePromotionalOffer", "path", "(Landroid/content/Context;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSupportTicketSubmit", "email", "description", "onSuccess", "Lkotlin/Function0;", "onError", "isPathAllowedForStore", "isPathAllowedForSubscriptionState", "launchPaywallActivity", "offering", "Lcom/revenuecat/purchases/Offering;", "launchRefreshIfPossible", "loadAndDisplayPromotionalOffer", "loadCustomerCenter", "isRefresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPurchases", "(Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;Ljava/util/Locale;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainPathAction", "notifyListenersForCustomActionSelected", "customActionData", "Lcom/revenuecat/purchases/customercenter/CustomActionData;", "notifyListenersForFeedbackSurveyCompleted", "feedbackSurveyOptionId", "notifyListenersForManageSubscription", "notifyListenersForManagementOptionSelected", "notifyListenersForPromotionalOfferSucceeded", "Lcom/revenuecat/purchases/models/StoreTransaction;", "notifyListenersForRestoreCompleted", "notifyListenersForRestoreFailed", "error", "notifyListenersForRestoreStarted", "onAcceptedPromotionalOffer", "subscriptionOption", "activity", "Landroid/app/Activity;", "(Lcom/revenuecat/purchases/models/SubscriptionOption;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResumed", "onActivityStarted", "onActivityStopped", "isChangingConfigurations", "onCustomActionSelected", "onNavigationButtonPressed", "onDismiss", "openURL", "url", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "pathButtonPressed", "refreshColors", "currentColorScheme", "isSystemInDarkTheme", "refreshCustomerCenter", "refreshStateIfLocaleChanged", "restorePurchases", "selectPurchase", FirebaseAnalytics.Event.PURCHASE, "shouldResumeRestorePurchases", "listenerName", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCreateSupportTicket", "showManageSubscriptions", "productId", "showPaywall", "showVirtualCurrencyBalances", "startAmazonCancellation", "managementURL", "Landroid/net/Uri;", "startGoogleProductCancellation", "startManagementUrlCancellation", "supportedPaths", "selectedPurchaseInformation", AndroidContextPlugin.SCREEN_KEY, "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "trackCustomerCenterEventOptionChosen", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "surveyOptionID", "trackImpressionIfNeeded", "tryFallbackToCurrentOffering", "asTransactionDetails", "Lcom/revenuecat/purchases/SubscriptionInfo;", "preservingUIStateIfRefresh", "previousState", "resetToMainScreen", "transformPathsOnSubscriptionState", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterViewModelImpl extends ViewModel implements CustomerCenterViewModel {
    private static final long STOP_FLOW_TIMEOUT = 5000;
    private final MutableState<PurchasesError> _actionError;
    private final MutableStateFlow<ColorScheme> _colorScheme;
    private final MutableStateFlow<LocaleListCompat> _lastLocaleList;
    private final MutableStateFlow<CustomerCenterState> _state;
    private final ColorScheme colorScheme;
    private final DateFormatter dateFormatter;
    private CustomerCenterImpressionEvent.CreationData impressionCreationData;
    private boolean isDarkMode;
    private final CustomerCenterListener listener;
    private final Locale locale;
    private final PurchasesType purchases;
    private boolean shouldRefreshOnResume;
    private final StateFlow<CustomerCenterState> state;
    private boolean wasBackgrounded;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomerCenterConfigData.HelpPath.PathType.values().length];
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CustomerCenterConfigData.HelpPath.OpenMethod.values().length];
            try {
                iArr2[CustomerCenterConfigData.HelpPath.OpenMethod.IN_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$createPurchaseInformation$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0, 0, 0, 0}, l = {797}, m = "createPurchaseInformation", n = {"transaction", "entitlement", "dateFormatter", AndroidContextPlugin.LOCALE_KEY, "localization"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.createPurchaseInformation(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findTargetProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {}, l = {1257}, m = "findTargetProduct", n = {}, s = {})
    static final class C09031 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09031(Continuation<? super C09031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.findTargetProduct(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$getPromotionalSubscriptionOption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0, 0}, l = {1232}, m = "getPromotionalSubscriptionOption", n = {"this", "product", "crossProductPromotion"}, s = {"L$0", "L$1", "L$2"})
    static final class C09041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09041(Continuation<? super C09041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.getPromotionalSubscriptionOption(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$handleSupportTicketSubmit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$handleSupportTicketSubmit$1", f = "CustomerCenterViewModel.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {})
    static final class C09051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $email;
        final /* synthetic */ Function0<Unit> $onError;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ CustomerCenterViewModelImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09051(String str, String str2, CustomerCenterViewModelImpl customerCenterViewModelImpl, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C09051> continuation) {
            super(2, continuation);
            this.$email = str;
            this.$description = str2;
            this.this$0 = customerCenterViewModelImpl;
            this.$onSuccess = function0;
            this.$onError = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09051(this.$email, this.$description, this.this$0, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objAwaitCreateSupportTicket;
            Object value;
            CustomerCenterState.Success successCopy$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Logger.INSTANCE.d("Creating support ticket - email: " + this.$email + ", Description: " + this.$description);
                    this.label = 1;
                    objAwaitCreateSupportTicket = this.this$0.purchases.awaitCreateSupportTicket(this.$email, this.$description, this);
                    if (objAwaitCreateSupportTicket == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objAwaitCreateSupportTicket = obj;
                }
                if (((CreateSupportTicketResult) objAwaitCreateSupportTicket).getSuccess()) {
                    Logger.INSTANCE.d("Support ticket created successfully");
                    MutableStateFlow mutableStateFlow = this.this$0._state;
                    do {
                        value = mutableStateFlow.getValue();
                        successCopy$default = (CustomerCenterState) value;
                        if (successCopy$default instanceof CustomerCenterState.Success) {
                            successCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) successCopy$default, null, null, null, null, null, null, ((CustomerCenterState.Success) successCopy$default).getNavigationState().pop(), ((CustomerCenterState.Success) successCopy$default).getNavigationState().pop().getCanNavigateBack() ? CustomerCenterState.NavigationButtonType.BACK : CustomerCenterState.NavigationButtonType.CLOSE, null, true, false, 1343, null);
                        }
                    } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
                    this.$onSuccess.invoke();
                } else {
                    Logger.INSTANCE.e("Support ticket creation returned false");
                    this.$onError.invoke();
                }
            } catch (PurchasesException e) {
                Logger.INSTANCE.e("Error creating support ticket", e);
                this.$onError.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$launchRefreshIfPossible$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$launchRefreshIfPossible$1", f = "CustomerCenterViewModel.kt", i = {}, l = {1109}, m = "invokeSuspend", n = {}, s = {})
    static final class C09061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09061(Continuation<? super C09061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerCenterViewModelImpl.this.new C09061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CustomerCenterViewModelImpl.this.refreshCustomerCenter(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadAndDisplayPromotionalOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0, 0, 0}, l = {862}, m = "loadAndDisplayPromotionalOffer", n = {"this", "promotionalOffer", "originalPath", "purchaseInformation"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C09071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09071(Continuation<? super C09071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadAndDisplayPromotionalOffer(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadCustomerCenter$2, reason: invalid class name */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, Imgcodecs.IMWRITE_GIF_QUALITY, 1034}, m = "loadCustomerCenter", n = {"this", "isRefresh", "this", "customerCenterConfigData", "isRefresh", "this", "customerCenterConfigData", "purchaseInformationList", "isRefresh", "this", "customerCenterConfigData", "purchaseInformationList", "virtualCurrencies", "isRefresh"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadCustomerCenter(false, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadPurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 719, 741}, m = "loadPurchases", n = {"this", "dateFormatter", AndroidContextPlugin.LOCALE_KEY, "localization", "this", "dateFormatter", AndroidContextPlugin.LOCALE_KEY, "localization", "customerInfo", "destination$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class C09081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C09081(Continuation<? super C09081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadPurchases(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$onAcceptedPromotionalOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 1}, l = {TypedValues.Custom.TYPE_REFERENCE, 914}, m = "onAcceptedPromotionalOffer", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C09091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09091(Continuation<? super C09091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.onAcceptedPromotionalOffer(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$2", f = "CustomerCenterViewModel.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
    static final class C09102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ CustomerCenterConfigData.HelpPath $path;
        final /* synthetic */ PurchaseInformation $purchaseInformation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09102(Context context, PurchaseInformation purchaseInformation, CustomerCenterConfigData.HelpPath helpPath, Continuation<? super C09102> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$purchaseInformation = purchaseInformation;
            this.$path = helpPath;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerCenterViewModelImpl.this.new C09102(this.$context, this.$purchaseInformation, this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CustomerCenterViewModelImpl customerCenterViewModelImpl = CustomerCenterViewModelImpl.this;
                Context context = this.$context;
                PurchaseInformation purchaseInformation = this.$purchaseInformation;
                StoreProduct product = purchaseInformation != null ? purchaseInformation.getProduct() : null;
                this.label = 1;
                obj = customerCenterViewModelImpl.handlePromotionalOffer(context, product, this.$path.getPromotionalOffer(), this.$path, this.$purchaseInformation, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                CustomerCenterViewModelImpl.this.mainPathAction(this.$path, this.$context, this.$purchaseInformation);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 1, 2}, l = {Videoio.CAP_PROP_XI_TRG_DELAY, Videoio.CAP_PROP_XI_TS_RST_MODE, Videoio.CAP_PROP_XI_HDR_T1}, m = "restorePurchases", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
    static final class C09111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09111(Continuation<? super C09111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.restorePurchases(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomerCenterViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", i = {0, 0}, l = {1473}, m = "shouldResumeRestorePurchases", n = {ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "listenerName"}, s = {"L$0", "L$1"})
    static final class C09121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09121(Continuation<? super C09121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.shouldResumeRestorePurchases(null, null, this);
        }
    }

    public CustomerCenterViewModelImpl(PurchasesType purchases, DateFormatter dateFormatter, Locale locale, ColorScheme colorScheme, boolean z, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.purchases = purchases;
        this.dateFormatter = dateFormatter;
        this.locale = locale;
        this.colorScheme = colorScheme;
        this.isDarkMode = z;
        this.listener = customerCenterListener;
        this._lastLocaleList = StateFlowKt.MutableStateFlow(getCurrentLocaleList());
        this._colorScheme = StateFlowKt.MutableStateFlow(colorScheme);
        MutableStateFlow<CustomerCenterState> MutableStateFlow = StateFlowKt.MutableStateFlow(CustomerCenterState.NotLoaded.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.stateIn(FlowKt.onStart(MutableStateFlow, new CustomerCenterViewModelImpl$state$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CustomerCenterState.Loading.INSTANCE);
        this._actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomerCenterViewModelImpl(PurchasesType purchasesType, DefaultDateFormatter defaultDateFormatter, Locale locale, ColorScheme colorScheme, boolean z, CustomerCenterListener customerCenterListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DateFormatter defaultDateFormatter2 = (i & 2) != 0 ? new DefaultDateFormatter() : defaultDateFormatter;
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        this(purchasesType, defaultDateFormatter2, locale, colorScheme, z, (i & 32) != 0 ? null : customerCenterListener);
    }

    private final TransactionDetails.Subscription asTransactionDetails(SubscriptionInfo subscriptionInfo) {
        return new TransactionDetails.Subscription(subscriptionInfo.getProductIdentifier(), subscriptionInfo.getProductPlanIdentifier(), subscriptionInfo.getStore(), subscriptionInfo.getIsActive(), subscriptionInfo.getWillRenew(), subscriptionInfo.getExpiresDate(), subscriptionInfo.getPeriodType() == PeriodType.TRIAL, subscriptionInfo.getManagementURL(), subscriptionInfo.getPrice(), subscriptionInfo.getIsSandbox());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<CustomerCenterConfigData.HelpPath> computeMainScreenPaths(CustomerCenterState.Success state) {
        CustomerCenterConfigData.Screen noActiveScreen;
        List<CustomerCenterConfigData.HelpPath> listEmptyList;
        if (!state.getPurchases().isEmpty()) {
            List purchases = state.getPurchases();
            if ((purchases instanceof Collection) && purchases.isEmpty()) {
                noActiveScreen = state.getCustomerCenterConfigData().getNoActiveScreen();
            } else {
                Iterator it = purchases.iterator();
                while (it.hasNext()) {
                    if (!((PurchaseInformation) it.next()).isExpired()) {
                        noActiveScreen = state.getCustomerCenterConfigData().getManagementScreen();
                        break;
                    }
                }
                noActiveScreen = state.getCustomerCenterConfigData().getNoActiveScreen();
            }
        }
        if (noActiveScreen == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = supportedPaths(state.getPurchases().size() == 1 ? (PurchaseInformation) CollectionsKt.first(state.getPurchases()) : null, noActiveScreen, state.getCustomerCenterConfigData().getLocalization());
            if (listEmptyList == null) {
            }
        }
        return state.getPurchases().size() > 1 ? PathUtils.INSTANCE.filterGeneralPaths(listEmptyList) : listEmptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createPurchaseInformation(TransactionDetails transactionDetails, EntitlementInfo entitlementInfo, DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization, Continuation<? super PurchaseInformation> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreProduct storeProduct;
        CustomerCenterConfigData.Localization localization2;
        TransactionDetails transactionDetails2;
        EntitlementInfo entitlementInfo2;
        DateFormatter dateFormatter2;
        Locale locale2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitGetProduct = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitGetProduct);
            storeProduct = null;
            if (transactionDetails.getStore() != Store.PLAY_STORE) {
                localization2 = localization;
                Logger.INSTANCE.w("Active product is not from Google, loading without product information: " + transactionDetails.getStore());
                transactionDetails2 = transactionDetails;
                entitlementInfo2 = entitlementInfo;
                dateFormatter2 = dateFormatter;
                locale2 = locale;
                return new PurchaseInformation(entitlementInfo2, storeProduct, transactionDetails2, dateFormatter2, locale2, localization2);
            }
            PurchasesType purchasesType = this.purchases;
            String productIdentifier = transactionDetails.getProductIdentifier();
            TransactionDetails.Subscription subscription = transactionDetails instanceof TransactionDetails.Subscription ? (TransactionDetails.Subscription) transactionDetails : null;
            String productPlanIdentifier = subscription != null ? subscription.getProductPlanIdentifier() : null;
            anonymousClass1.L$0 = transactionDetails;
            anonymousClass1.L$1 = entitlementInfo;
            anonymousClass1.L$2 = dateFormatter;
            anonymousClass1.L$3 = locale;
            localization2 = localization;
            anonymousClass1.L$4 = localization2;
            anonymousClass1.label = 1;
            objAwaitGetProduct = purchasesType.awaitGetProduct(productIdentifier, productPlanIdentifier, anonymousClass1);
            if (objAwaitGetProduct == coroutine_suspended) {
                return coroutine_suspended;
            }
            transactionDetails2 = transactionDetails;
            entitlementInfo2 = entitlementInfo;
            dateFormatter2 = dateFormatter;
            locale2 = locale;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CustomerCenterConfigData.Localization localization3 = (CustomerCenterConfigData.Localization) anonymousClass1.L$4;
            Locale locale3 = (Locale) anonymousClass1.L$3;
            dateFormatter2 = (DateFormatter) anonymousClass1.L$2;
            entitlementInfo2 = (EntitlementInfo) anonymousClass1.L$1;
            TransactionDetails transactionDetails3 = (TransactionDetails) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwaitGetProduct);
            localization2 = localization3;
            locale2 = locale3;
            transactionDetails2 = transactionDetails3;
        }
        storeProduct = (StoreProduct) objAwaitGetProduct;
        if (storeProduct == null) {
            Logger.INSTANCE.w("Could not find product, loading without product information: " + transactionDetails2.getProductIdentifier());
        }
        return new PurchaseInformation(entitlementInfo2, storeProduct, transactionDetails2, dateFormatter2, locale2, localization2);
    }

    private final void displayFeedbackSurvey(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1<? super CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> onAnswerSubmitted) {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            successCopy$default = value;
            if (successCopy$default instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) successCopy$default;
                successCopy$default = CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(new CustomerCenterDestination.FeedbackSurvey(new FeedbackSurveyData(feedbackSurvey, onAnswerSubmitted), feedbackSurvey.getTitle())), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
    }

    private final List<TransactionDetails> findActiveTransactions(CustomerInfo customerInfo) {
        Object objAsTransactionDetails;
        Collection<SubscriptionInfo> collectionValues = customerInfo.getSubscriptionsByProductIdentifier().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((SubscriptionInfo) obj).getIsActive()) {
                arrayList.add(obj);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findActiveTransactions$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SubscriptionInfo) t).getExpiresDate(), ((SubscriptionInfo) t2).getExpiresDate());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listSortedWith) {
            if (((SubscriptionInfo) obj2).getStore() == Store.PLAY_STORE) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<Transaction> nonSubscriptionTransactions = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : nonSubscriptionTransactions) {
            if (((Transaction) obj3).getStore() == Store.PLAY_STORE) {
                arrayList4.add(obj3);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : listSortedWith) {
            if (((SubscriptionInfo) obj4).getStore() != Store.PLAY_STORE) {
                arrayList6.add(obj4);
            }
        }
        ArrayList arrayList7 = arrayList6;
        List<Transaction> nonSubscriptionTransactions2 = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList8 = new ArrayList();
        for (Object obj5 : nonSubscriptionTransactions2) {
            if (((Transaction) obj5).getStore() != Store.PLAY_STORE) {
                arrayList8.add(obj5);
            }
        }
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList5), (Iterable) arrayList7), (Iterable) arrayList8);
        ArrayList arrayList9 = new ArrayList();
        for (Object obj6 : listPlus) {
            if (obj6 instanceof SubscriptionInfo) {
                objAsTransactionDetails = asTransactionDetails((SubscriptionInfo) obj6);
            } else if (obj6 instanceof Transaction) {
                Transaction transaction = (Transaction) obj6;
                objAsTransactionDetails = (TransactionDetails) new TransactionDetails.NonSubscription(transaction.getProductIdentifier(), transaction.getStore(), transaction.getPrice(), transaction.getIsSandbox());
            } else {
                objAsTransactionDetails = null;
            }
            if (objAsTransactionDetails != null) {
                arrayList9.add(objAsTransactionDetails);
            }
        }
        return arrayList9;
    }

    private final TransactionDetails.Subscription findLatestExpiredSubscription(CustomerInfo customerInfo) {
        Object next;
        Collection<SubscriptionInfo> collectionValues = customerInfo.getSubscriptionsByProductIdentifier().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) obj;
            if (!subscriptionInfo.getIsActive() && subscriptionInfo.getExpiresDate() != null) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Date expiresDate = ((SubscriptionInfo) next).getExpiresDate();
                Intrinsics.checkNotNull(expiresDate);
                Date date = expiresDate;
                do {
                    Object next2 = it.next();
                    Date expiresDate2 = ((SubscriptionInfo) next2).getExpiresDate();
                    Intrinsics.checkNotNull(expiresDate2);
                    Date date2 = expiresDate2;
                    if (date.compareTo(date2) < 0) {
                        next = next2;
                        date = date2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) next;
        if (subscriptionInfo2 != null) {
            return asTransactionDetails(subscriptionInfo2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findTargetProduct(String str, String str2, Continuation<? super StoreProduct> continuation) {
        C09031 c09031;
        if (continuation instanceof C09031) {
            c09031 = (C09031) continuation;
            if ((c09031.label & Integer.MIN_VALUE) != 0) {
                c09031.label -= Integer.MIN_VALUE;
            } else {
                c09031 = new C09031(continuation);
            }
        }
        Object objAwaitGetProduct = c09031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitGetProduct);
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
            String str3 = (String) CollectionsKt.first(listSplit$default);
            String str4 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
            if (str4 != null) {
                str2 = str4;
            }
            PurchasesType purchasesType = this.purchases;
            c09031.label = 1;
            objAwaitGetProduct = purchasesType.awaitGetProduct(str3, str2, c09031);
            if (objAwaitGetProduct == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitGetProduct);
        }
        return (StoreProduct) objAwaitGetProduct;
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
            Intrinsics.checkNotNullExpressionValue(localeListCompatCreate, "{\n            val locale….create(locale)\n        }");
            return localeListCompatCreate;
        } catch (IllegalArgumentException unused) {
            Logger.INSTANCE.w("Invalid preferred locale format: " + preferredUILocaleOverride + ". Using system default.");
            LocaleListCompat localeListCompat2 = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat2, "{\n            Logger.w(\"…at.getDefault()\n        }");
            return localeListCompat2;
        }
    }

    private final SubscriptionOption getCustomerCenterSubscriptionOption(String offerIdentifier, StoreProduct targetProduct) {
        SubscriptionOptions subscriptionOptions = targetProduct.getSubscriptionOptions();
        SubscriptionOption subscriptionOption = null;
        if (subscriptionOptions == null) {
            return null;
        }
        Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption next = it.next();
            SubscriptionOption subscriptionOption2 = next;
            if ((subscriptionOption2 instanceof GoogleSubscriptionOption) && subscriptionOption2.getTags().contains(SharedConstants.RC_CUSTOMER_CENTER_TAG) && Intrinsics.areEqual(((GoogleSubscriptionOption) subscriptionOption2).getOfferId(), offerIdentifier)) {
                subscriptionOption = next;
                break;
            }
        }
        return subscriptionOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getPromotionalSubscriptionOption(CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, StoreProduct storeProduct, Continuation<? super SubscriptionOption> continuation) {
        C09041 c09041;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion crossProductPromotion;
        StoreProduct storeProduct2;
        if (continuation instanceof C09041) {
            c09041 = (C09041) continuation;
            if ((c09041.label & Integer.MIN_VALUE) != 0) {
                c09041.label -= Integer.MIN_VALUE;
            } else {
                c09041 = new C09041(continuation);
            }
        }
        Object objFindTargetProduct = c09041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFindTargetProduct);
            GoogleStoreProduct googleProduct = GoogleStoreProductKt.getGoogleProduct(storeProduct);
            crossProductPromotion = promotionalOffer.getCrossProductPromotions().get(storeProduct.getId());
            if (crossProductPromotion == null) {
                crossProductPromotion = googleProduct != null ? promotionalOffer.getCrossProductPromotions().get(googleProduct.getProductId()) : null;
                if (crossProductPromotion == null) {
                    String str = promotionalOffer.getProductMapping().get(storeProduct.getId());
                    crossProductPromotion = str != null ? new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion(str, storeProduct.getId()) : null;
                }
            }
            if (crossProductPromotion == null) {
                Logger.INSTANCE.d("No promotional offer configured for product " + storeProduct.getId());
                return null;
            }
            if (Intrinsics.areEqual(crossProductPromotion.getTargetProductId(), storeProduct.getId())) {
                storeProduct2 = storeProduct;
            } else {
                if ((googleProduct != null ? googleProduct.getBasePlanId() : null) != null) {
                    String targetProductId = crossProductPromotion.getTargetProductId();
                    String basePlanId = googleProduct.getBasePlanId();
                    Intrinsics.checkNotNull(basePlanId);
                    c09041.L$0 = this;
                    c09041.L$1 = storeProduct;
                    c09041.L$2 = crossProductPromotion;
                    c09041.label = 1;
                    objFindTargetProduct = findTargetProduct(targetProductId, basePlanId, c09041);
                    if (objFindTargetProduct == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    storeProduct2 = storeProduct;
                    storeProduct = null;
                }
            }
            if (storeProduct == null) {
                return this.getCustomerCenterSubscriptionOption(crossProductPromotion.getStoreOfferIdentifier(), storeProduct);
            }
            Logger.INSTANCE.d("Could not find discount of product (" + crossProductPromotion.getTargetProductId() + ") for active subscription " + storeProduct2.getId());
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion crossProductPromotion2 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion) c09041.L$2;
        StoreProduct storeProduct3 = (StoreProduct) c09041.L$1;
        CustomerCenterViewModelImpl customerCenterViewModelImpl = (CustomerCenterViewModelImpl) c09041.L$0;
        ResultKt.throwOnFailure(objFindTargetProduct);
        crossProductPromotion = crossProductPromotion2;
        this = customerCenterViewModelImpl;
        storeProduct = storeProduct3;
        StoreProduct storeProduct4 = storeProduct;
        storeProduct = (StoreProduct) objFindTargetProduct;
        storeProduct2 = storeProduct4;
        if (storeProduct == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goBackToMain() {
        CustomerCenterState value;
        CustomerCenterState.Success successResetToMainScreen;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            successResetToMainScreen = value;
            if (successResetToMainScreen instanceof CustomerCenterState.Success) {
                successResetToMainScreen = resetToMainScreen((CustomerCenterState.Success) successResetToMainScreen);
            }
        } while (!mutableStateFlow.compareAndSet(value, successResetToMainScreen));
    }

    private final void handleCancelPath(Context context, PurchaseInformation purchaseInformation) {
        CustomerCenterState value = this._state.getValue();
        CustomerCenterState.Success success = value instanceof CustomerCenterState.Success ? (CustomerCenterState.Success) value : null;
        if (success == null) {
            return;
        }
        if (purchaseInformation == null) {
            CustomerCenterDestination currentDestination = success.getCurrentDestination();
            purchaseInformation = currentDestination instanceof CustomerCenterDestination.SelectedPurchaseDetail ? ((CustomerCenterDestination.SelectedPurchaseDetail) currentDestination).getPurchaseInformation() : success.getPurchases().size() == 1 ? (PurchaseInformation) CollectionsKt.first(success.getPurchases()) : null;
        }
        if ((purchaseInformation != null ? purchaseInformation.getStore() : null) == Store.PLAY_STORE && purchaseInformation.getProduct() != null) {
            startGoogleProductCancellation(context, purchaseInformation.getProduct());
            return;
        }
        if ((purchaseInformation != null ? purchaseInformation.getStore() : null) == Store.AMAZON && purchaseInformation.getManagementURL() != null) {
            startAmazonCancellation(context, purchaseInformation.getManagementURL());
            return;
        }
        if ((purchaseInformation != null ? purchaseInformation.getManagementURL() : null) != null) {
            startManagementUrlCancellation(context, purchaseInformation.getManagementURL());
        } else {
            Logger.INSTANCE.e("No product or management URL available for cancel path");
        }
    }

    static /* synthetic */ void handleCancelPath$default(CustomerCenterViewModelImpl customerCenterViewModelImpl, Context context, PurchaseInformation purchaseInformation, int i, Object obj) {
        if ((i & 2) != 0) {
            purchaseInformation = null;
        }
        customerCenterViewModelImpl.handleCancelPath(context, purchaseInformation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePaywallError(String message, PurchasesErrorCode errorCode) {
        Logger.INSTANCE.e(message);
        this._actionError.setValue(new PurchasesError(errorCode, message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handlePromotionalOffer(Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation<? super Boolean> continuation) {
        return (storeProduct == null || promotionalOffer == null) ? Boxing.boxBoolean(false) : loadAndDisplayPromotionalOffer(context, storeProduct, promotionalOffer, helpPath, purchaseInformation, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSupportTicketSubmit(String email, String description, Function0<Unit> onSuccess, Function0<Unit> onError) {
        if (this._state.getValue() instanceof CustomerCenterState.Success) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09051(email, description, this, onSuccess, onError, null), 3, null);
        }
    }

    private final boolean isPathAllowedForStore(CustomerCenterConfigData.HelpPath path, PurchaseInformation purchaseInformation) {
        switch (WhenMappings.$EnumSwitchMapping$0[path.getType().ordinal()]) {
            case 2:
                if ((purchaseInformation != null ? purchaseInformation.getStore() : null) != Store.PLAY_STORE) {
                    if ((purchaseInformation != null ? purchaseInformation.getManagementURL() : null) == null) {
                        return false;
                    }
                }
            case 1:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isPathAllowedForSubscriptionState(CustomerCenterConfigData.HelpPath path, PurchaseInformation purchaseInformation) {
        if (path.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
            return (purchaseInformation == null || !purchaseInformation.isSubscription() || purchaseInformation.isExpired()) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPaywallActivity(Context context, Offering offering) {
        try {
            Logger.INSTANCE.d("Showing paywall for offering: " + offering.getIdentifier());
            String identifier = offering.getIdentifier();
            Package r4 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            PaywallActivityArgs paywallActivityArgs = new PaywallActivityArgs((String) null, new OfferingSelection.IdAndPresentedOfferingContext(identifier, r4 != null ? r4.getPresentedOfferingContext() : null), (Map) null, true, false, false, (Map) null, (Integer) null, 245, (DefaultConstructorMarker) null);
            Intent intent = new Intent(context, (Class<?>) PaywallActivity.class);
            intent.putExtra(PaywallActivity.ARGS_EXTRA, paywallActivityArgs);
            intent.addFlags(268435456);
            context.startActivity(intent);
            Logger.INSTANCE.d("Successfully launched paywall for offering: " + offering.getIdentifier());
        } catch (ActivityNotFoundException e) {
            handlePaywallError("PaywallActivity not found: " + e.getMessage(), PurchasesErrorCode.ConfigurationError);
        } catch (IllegalArgumentException e2) {
            handlePaywallError("Invalid argument for paywall: " + e2.getMessage(), PurchasesErrorCode.UnknownError);
        } catch (SecurityException e3) {
            handlePaywallError("Security error launching paywall: " + e3.getMessage(), PurchasesErrorCode.UnknownError);
        }
    }

    private final void launchRefreshIfPossible() {
        CustomerCenterState value = this._state.getValue();
        if (!(value instanceof CustomerCenterState.Success) || ((CustomerCenterState.Success) value).isRefreshing()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09061(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ee, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ef, code lost:
    
        r5 = r0;
        r11 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023d A[EDGE_INSN: B:105:0x023d->B:91:0x023d BREAK  A[LOOP:0: B:76:0x01bd->B:79:0x01ec], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130 A[Catch: PurchasesException -> 0x01ee, TryCatch #2 {PurchasesException -> 0x01ee, blocks: (B:75:0x019d, B:76:0x01bd, B:73:0x0180, B:60:0x014e, B:62:0x0157, B:54:0x011c, B:56:0x0130, B:50:0x00fe, B:47:0x00ee), top: B:97:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ec A[LOOP:0: B:76:0x01bd->B:79:0x01ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadCustomerCenter(boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass2 anonymousClass2;
        CustomerCenterState value;
        CustomerCenterState.Loading loadingCopy$default;
        CustomerCenterConfigData customerCenterConfigData;
        List list;
        List list2;
        CustomerCenterConfigData customerCenterConfigData2;
        VirtualCurrencies virtualCurrencies;
        List list3;
        CustomerCenterConfigData customerCenterConfigData3;
        CustomerCenterConfigData.Screen noActiveScreen;
        List list4;
        CustomerCenterViewModelImpl customerCenterViewModelImpl;
        boolean z2;
        VirtualCurrencies virtualCurrencies2;
        CustomerCenterConfigData customerCenterConfigData4;
        boolean z3;
        PurchasesException purchasesException;
        MutableStateFlow<CustomerCenterState> mutableStateFlow;
        CustomerCenterState value2;
        CustomerCenterState.Error error;
        CustomerCenterState.Success success;
        List<CustomerCenterConfigData.HelpPath> listComputeMainScreenPaths;
        MutableStateFlow<CustomerCenterState> mutableStateFlow2;
        CustomerCenterState value3;
        CustomerCenterState.Success success2;
        CustomerCenterViewModelImpl customerCenterViewModelImpl2 = this;
        boolean z4 = z;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = customerCenterViewModelImpl2.new AnonymousClass2(continuation);
            }
        }
        Object objAwaitCustomerCenterConfigData = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        Offering offering = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitCustomerCenterConfigData);
            MutableStateFlow<CustomerCenterState> mutableStateFlow3 = customerCenterViewModelImpl2._state;
            do {
                value = mutableStateFlow3.getValue();
                loadingCopy$default = value;
                if (z4 && (loadingCopy$default instanceof CustomerCenterState.Success)) {
                    loadingCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) loadingCopy$default, null, null, null, null, null, null, null, null, null, false, true, 1023, null);
                } else if (!(loadingCopy$default instanceof CustomerCenterState.Loading)) {
                    loadingCopy$default = CustomerCenterState.Loading.INSTANCE;
                }
            } while (!mutableStateFlow3.compareAndSet(value, loadingCopy$default));
            PurchasesType purchasesType = customerCenterViewModelImpl2.purchases;
            anonymousClass2.L$0 = customerCenterViewModelImpl2;
            anonymousClass2.Z$0 = z4;
            anonymousClass2.label = 1;
            objAwaitCustomerCenterConfigData = purchasesType.awaitCustomerCenterConfigData(anonymousClass2);
            if (objAwaitCustomerCenterConfigData == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                boolean z5 = anonymousClass2.Z$0;
                CustomerCenterConfigData customerCenterConfigData5 = (CustomerCenterConfigData) anonymousClass2.L$1;
                CustomerCenterViewModelImpl customerCenterViewModelImpl3 = (CustomerCenterViewModelImpl) anonymousClass2.L$0;
                try {
                    ResultKt.throwOnFailure(objAwaitCustomerCenterConfigData);
                    z4 = z5;
                    customerCenterViewModelImpl2 = customerCenterViewModelImpl3;
                    customerCenterConfigData = customerCenterConfigData5;
                    list = (List) objAwaitCustomerCenterConfigData;
                } catch (PurchasesException e) {
                    z3 = z5;
                    customerCenterViewModelImpl2 = customerCenterViewModelImpl3;
                    purchasesException = e;
                    mutableStateFlow = customerCenterViewModelImpl2._state;
                    do {
                        value2 = mutableStateFlow.getValue();
                        CustomerCenterState customerCenterState = value2;
                        if (z3) {
                            error = new CustomerCenterState.Error(purchasesException.getError());
                        }
                    } while (!mutableStateFlow.compareAndSet(value2, error));
                }
                if (Intrinsics.areEqual(customerCenterConfigData.getSupport().getDisplayVirtualCurrencies(), Boxing.boxBoolean(true))) {
                    list2 = list;
                    customerCenterConfigData2 = customerCenterConfigData;
                    virtualCurrencies = null;
                    noActiveScreen = customerCenterConfigData2.getNoActiveScreen();
                    if (noActiveScreen != null) {
                    }
                    success = new CustomerCenterState.Success(customerCenterConfigData2, list2, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, offering, null, null, virtualCurrencies, false, false, 720, null);
                    listComputeMainScreenPaths = customerCenterViewModelImpl2.computeMainScreenPaths(success);
                    mutableStateFlow2 = customerCenterViewModelImpl2._state;
                    while (true) {
                        value3 = mutableStateFlow2.getValue();
                        success2 = success;
                        if (!mutableStateFlow2.compareAndSet(value3, customerCenterViewModelImpl2.preservingUIStateIfRefresh(CustomerCenterState.Success.copy$default(success2, null, null, listComputeMainScreenPaths, null, null, null, null, null, null, false, false, 2043, null), z4, value3))) {
                        }
                        success = success2;
                    }
                    return Unit.INSTANCE;
                }
                customerCenterViewModelImpl2.purchases.invalidateVirtualCurrenciesCache();
                PurchasesType purchasesType2 = customerCenterViewModelImpl2.purchases;
                anonymousClass2.L$0 = customerCenterViewModelImpl2;
                anonymousClass2.L$1 = customerCenterConfigData;
                anonymousClass2.L$2 = list;
                anonymousClass2.Z$0 = z4;
                anonymousClass2.label = 3;
                Object objAwaitGetVirtualCurrencies = purchasesType2.awaitGetVirtualCurrencies(anonymousClass2);
                if (objAwaitGetVirtualCurrencies == coroutine_suspended) {
                    return coroutine_suspended;
                }
                CustomerCenterConfigData customerCenterConfigData6 = customerCenterConfigData;
                list3 = list;
                objAwaitCustomerCenterConfigData = objAwaitGetVirtualCurrencies;
                customerCenterConfigData3 = customerCenterConfigData6;
                customerCenterConfigData2 = customerCenterConfigData3;
                list2 = list3;
                virtualCurrencies = (VirtualCurrencies) objAwaitCustomerCenterConfigData;
                noActiveScreen = customerCenterConfigData2.getNoActiveScreen();
                if (noActiveScreen != null) {
                }
                success = new CustomerCenterState.Success(customerCenterConfigData2, list2, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, offering, null, null, virtualCurrencies, false, false, 720, null);
                listComputeMainScreenPaths = customerCenterViewModelImpl2.computeMainScreenPaths(success);
                mutableStateFlow2 = customerCenterViewModelImpl2._state;
                while (true) {
                    value3 = mutableStateFlow2.getValue();
                    success2 = success;
                    if (!mutableStateFlow2.compareAndSet(value3, customerCenterViewModelImpl2.preservingUIStateIfRefresh(CustomerCenterState.Success.copy$default(success2, null, null, listComputeMainScreenPaths, null, null, null, null, null, null, false, false, 2043, null), z4, value3))) {
                    }
                    success = success2;
                }
                return Unit.INSTANCE;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z2 = anonymousClass2.Z$0;
                virtualCurrencies2 = (VirtualCurrencies) anonymousClass2.L$3;
                list4 = (List) anonymousClass2.L$2;
                customerCenterConfigData4 = (CustomerCenterConfigData) anonymousClass2.L$1;
                customerCenterViewModelImpl = (CustomerCenterViewModelImpl) anonymousClass2.L$0;
                try {
                    ResultKt.throwOnFailure(objAwaitCustomerCenterConfigData);
                    offering = (Offering) objAwaitCustomerCenterConfigData;
                    customerCenterConfigData2 = customerCenterConfigData4;
                    virtualCurrencies = virtualCurrencies2;
                } catch (PurchasesException e2) {
                    e = e2;
                    customerCenterConfigData2 = customerCenterConfigData4;
                    virtualCurrencies = virtualCurrencies2;
                    z4 = z2;
                    customerCenterViewModelImpl2 = customerCenterViewModelImpl;
                    Logger.INSTANCE.d("Failed to resolve NO_ACTIVE screen offering: " + e);
                    customerCenterViewModelImpl = customerCenterViewModelImpl2;
                    z2 = z4;
                }
                list2 = list4;
                z4 = z2;
                customerCenterViewModelImpl2 = customerCenterViewModelImpl;
                success = new CustomerCenterState.Success(customerCenterConfigData2, list2, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, offering, null, null, virtualCurrencies, false, false, 720, null);
                listComputeMainScreenPaths = customerCenterViewModelImpl2.computeMainScreenPaths(success);
                mutableStateFlow2 = customerCenterViewModelImpl2._state;
                while (true) {
                    value3 = mutableStateFlow2.getValue();
                    success2 = success;
                    if (!mutableStateFlow2.compareAndSet(value3, customerCenterViewModelImpl2.preservingUIStateIfRefresh(CustomerCenterState.Success.copy$default(success2, null, null, listComputeMainScreenPaths, null, null, null, null, null, null, false, false, 2043, null), z4, value3))) {
                        break;
                    }
                    success = success2;
                }
                return Unit.INSTANCE;
            }
            boolean z6 = anonymousClass2.Z$0;
            List list5 = (List) anonymousClass2.L$2;
            CustomerCenterConfigData customerCenterConfigData7 = (CustomerCenterConfigData) anonymousClass2.L$1;
            CustomerCenterViewModelImpl customerCenterViewModelImpl4 = (CustomerCenterViewModelImpl) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(objAwaitCustomerCenterConfigData);
                z4 = z6;
                customerCenterViewModelImpl2 = customerCenterViewModelImpl4;
                customerCenterConfigData3 = customerCenterConfigData7;
                list3 = list5;
                customerCenterConfigData2 = customerCenterConfigData3;
                list2 = list3;
                virtualCurrencies = (VirtualCurrencies) objAwaitCustomerCenterConfigData;
                noActiveScreen = customerCenterConfigData2.getNoActiveScreen();
                if (noActiveScreen != null) {
                    try {
                        PurchasesType purchasesType3 = customerCenterViewModelImpl2.purchases;
                        anonymousClass2.L$0 = customerCenterViewModelImpl2;
                        anonymousClass2.L$1 = customerCenterConfigData2;
                        anonymousClass2.L$2 = list2;
                        anonymousClass2.L$3 = virtualCurrencies;
                        anonymousClass2.Z$0 = z4;
                        anonymousClass2.label = 4;
                        objAwaitCustomerCenterConfigData = ScreenOfferingExtensionsKt.resolveOfferingSuspend(noActiveScreen, purchasesType3, anonymousClass2);
                    } catch (PurchasesException e3) {
                        e = e3;
                        list4 = list2;
                        Logger.INSTANCE.d("Failed to resolve NO_ACTIVE screen offering: " + e);
                        customerCenterViewModelImpl = customerCenterViewModelImpl2;
                        z2 = z4;
                    }
                    if (objAwaitCustomerCenterConfigData != coroutine_suspended) {
                        customerCenterViewModelImpl = customerCenterViewModelImpl2;
                        z2 = z4;
                        virtualCurrencies2 = virtualCurrencies;
                        list4 = list2;
                        customerCenterConfigData4 = customerCenterConfigData2;
                        offering = (Offering) objAwaitCustomerCenterConfigData;
                        customerCenterConfigData2 = customerCenterConfigData4;
                        virtualCurrencies = virtualCurrencies2;
                        list2 = list4;
                        z4 = z2;
                        customerCenterViewModelImpl2 = customerCenterViewModelImpl;
                    }
                    return coroutine_suspended;
                }
                success = new CustomerCenterState.Success(customerCenterConfigData2, list2, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, offering, null, null, virtualCurrencies, false, false, 720, null);
                listComputeMainScreenPaths = customerCenterViewModelImpl2.computeMainScreenPaths(success);
                mutableStateFlow2 = customerCenterViewModelImpl2._state;
                while (true) {
                    value3 = mutableStateFlow2.getValue();
                    success2 = success;
                    if (!mutableStateFlow2.compareAndSet(value3, customerCenterViewModelImpl2.preservingUIStateIfRefresh(CustomerCenterState.Success.copy$default(success2, null, null, listComputeMainScreenPaths, null, null, null, null, null, null, false, false, 2043, null), z4, value3))) {
                    }
                    success = success2;
                }
            } catch (PurchasesException e4) {
                purchasesException = e4;
                z3 = z6;
                customerCenterViewModelImpl2 = customerCenterViewModelImpl4;
                mutableStateFlow = customerCenterViewModelImpl2._state;
                do {
                    value2 = mutableStateFlow.getValue();
                    CustomerCenterState customerCenterState2 = value2;
                    if (z3) {
                    }
                } while (!mutableStateFlow.compareAndSet(value2, error));
            }
            return Unit.INSTANCE;
        }
        boolean z7 = anonymousClass2.Z$0;
        CustomerCenterViewModelImpl customerCenterViewModelImpl5 = (CustomerCenterViewModelImpl) anonymousClass2.L$0;
        try {
            ResultKt.throwOnFailure(objAwaitCustomerCenterConfigData);
            z4 = z7;
            customerCenterViewModelImpl2 = customerCenterViewModelImpl5;
        } catch (PurchasesException e5) {
            purchasesException = e5;
            z3 = z7;
            customerCenterViewModelImpl2 = customerCenterViewModelImpl5;
            mutableStateFlow = customerCenterViewModelImpl2._state;
            do {
                value2 = mutableStateFlow.getValue();
                CustomerCenterState customerCenterState22 = value2;
                if (z3) {
                }
            } while (!mutableStateFlow.compareAndSet(value2, error));
        }
        mutableStateFlow = customerCenterViewModelImpl2._state;
        do {
            value2 = mutableStateFlow.getValue();
            CustomerCenterState customerCenterState222 = value2;
            if (z3 && (customerCenterState222 instanceof CustomerCenterState.Success)) {
                Logger.INSTANCE.e("Error refreshing Customer Center data, keeping existing state", purchasesException);
                error = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) customerCenterState222, null, null, null, null, null, null, null, null, null, false, false, 1023, null);
            } else {
                error = new CustomerCenterState.Error(purchasesException.getError());
            }
        } while (!mutableStateFlow.compareAndSet(value2, error));
        return Unit.INSTANCE;
        CustomerCenterConfigData customerCenterConfigData8 = (CustomerCenterConfigData) objAwaitCustomerCenterConfigData;
        DateFormatter dateFormatter = customerCenterViewModelImpl2.dateFormatter;
        Locale locale = customerCenterViewModelImpl2.locale;
        CustomerCenterConfigData.Localization localization = customerCenterConfigData8.getLocalization();
        anonymousClass2.L$0 = customerCenterViewModelImpl2;
        anonymousClass2.L$1 = customerCenterConfigData8;
        anonymousClass2.Z$0 = z4;
        anonymousClass2.label = 2;
        Object objLoadPurchases = customerCenterViewModelImpl2.loadPurchases(dateFormatter, locale, localization, anonymousClass2);
        if (objLoadPurchases == coroutine_suspended) {
            return coroutine_suspended;
        }
        customerCenterConfigData = customerCenterConfigData8;
        objAwaitCustomerCenterConfigData = objLoadPurchases;
        list = (List) objAwaitCustomerCenterConfigData;
        if (Intrinsics.areEqual(customerCenterConfigData.getSupport().getDisplayVirtualCurrencies(), Boxing.boxBoolean(true))) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0201, code lost:
    
        if (r1 == r2) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0170 -> B:51:0x0171). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadPurchases(DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization, Continuation<? super List<PurchaseInformation>> continuation) {
        C09081 c09081;
        Locale locale2;
        CustomerCenterViewModelImpl customerCenterViewModelImpl;
        DateFormatter dateFormatter2;
        CustomerCenterConfigData.Localization localization2;
        ArrayList arrayList;
        DateFormatter dateFormatter3;
        CustomerCenterConfigData.Localization localization3;
        C09081 c090812;
        Locale locale3;
        CustomerInfo customerInfo;
        CustomerCenterViewModelImpl customerCenterViewModelImpl2;
        Iterator it;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        if (continuation instanceof C09081) {
            c09081 = (C09081) continuation;
            if ((c09081.label & Integer.MIN_VALUE) != 0) {
                c09081.label -= Integer.MIN_VALUE;
            } else {
                c09081 = new C09081(continuation);
            }
        }
        C09081 c090813 = c09081;
        Object objAwaitCustomerInfo = c090813.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c090813.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitCustomerInfo);
            PurchasesType purchasesType = this.purchases;
            CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.FETCH_CURRENT;
            c090813.L$0 = this;
            c090813.L$1 = dateFormatter;
            locale2 = locale;
            c090813.L$2 = locale2;
            c090813.L$3 = localization;
            c090813.label = 1;
            objAwaitCustomerInfo = purchasesType.awaitCustomerInfo(cacheFetchPolicy, c090813);
            if (objAwaitCustomerInfo != coroutine_suspended) {
                customerCenterViewModelImpl = this;
                dateFormatter2 = dateFormatter;
                localization2 = localization;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            CustomerCenterConfigData.Localization localization4 = (CustomerCenterConfigData.Localization) c090813.L$3;
            Locale locale4 = (Locale) c090813.L$2;
            dateFormatter2 = (DateFormatter) c090813.L$1;
            CustomerCenterViewModelImpl customerCenterViewModelImpl3 = (CustomerCenterViewModelImpl) c090813.L$0;
            ResultKt.throwOnFailure(objAwaitCustomerInfo);
            locale2 = locale4;
            customerCenterViewModelImpl = customerCenterViewModelImpl3;
            localization2 = localization4;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwaitCustomerInfo);
                return CollectionsKt.listOf(objAwaitCustomerInfo);
            }
            Collection collection = (Collection) c090813.L$7;
            it = (Iterator) c090813.L$6;
            arrayList = (Collection) c090813.L$5;
            customerInfo = (CustomerInfo) c090813.L$4;
            CustomerCenterConfigData.Localization localization5 = (CustomerCenterConfigData.Localization) c090813.L$3;
            Locale locale5 = (Locale) c090813.L$2;
            dateFormatter3 = (DateFormatter) c090813.L$1;
            CustomerCenterViewModelImpl customerCenterViewModelImpl4 = (CustomerCenterViewModelImpl) c090813.L$0;
            ResultKt.throwOnFailure(objAwaitCustomerInfo);
            localization3 = localization5;
            c090812 = c090813;
            customerCenterViewModelImpl2 = customerCenterViewModelImpl4;
            locale3 = locale5;
            collection.add((PurchaseInformation) objAwaitCustomerInfo);
            collection = arrayList;
            if (it.hasNext()) {
                TransactionDetails transactionDetails = (TransactionDetails) it.next();
                Iterator<T> it2 = customerInfo.getEntitlements().getActive().values().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it2.next();
                    if (Intrinsics.areEqual(((EntitlementInfo) next3).getProductIdentifier(), transactionDetails.getProductIdentifier())) {
                        break;
                    }
                }
                EntitlementInfo entitlementInfo = (EntitlementInfo) next3;
                if (entitlementInfo == null) {
                    Iterator<T> it3 = customerInfo.getEntitlements().getAll().values().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it3.next();
                        if (Intrinsics.areEqual(((EntitlementInfo) next4).getProductIdentifier(), transactionDetails.getProductIdentifier())) {
                            break;
                        }
                    }
                    entitlementInfo = (EntitlementInfo) next4;
                }
                c090812.L$0 = customerCenterViewModelImpl2;
                c090812.L$1 = dateFormatter3;
                c090812.L$2 = locale3;
                c090812.L$3 = localization3;
                c090812.L$4 = customerInfo;
                c090812.L$5 = collection;
                c090812.L$6 = it;
                c090812.L$7 = collection;
                c090812.label = 2;
                objAwaitCustomerInfo = customerCenterViewModelImpl2.createPurchaseInformation(transactionDetails, entitlementInfo, dateFormatter3, locale3, localization3, c090812);
                if (objAwaitCustomerInfo != coroutine_suspended) {
                    arrayList = collection;
                    collection.add((PurchaseInformation) objAwaitCustomerInfo);
                    collection = arrayList;
                    if (it.hasNext()) {
                        return (List) collection;
                    }
                }
                return coroutine_suspended;
            }
        }
        CustomerInfo customerInfo2 = (CustomerInfo) objAwaitCustomerInfo;
        boolean zIsEmpty = customerInfo2.getActiveSubscriptions().isEmpty();
        boolean zIsEmpty2 = customerInfo2.getNonSubscriptionTransactions().isEmpty();
        if (!zIsEmpty || !zIsEmpty2) {
            List<TransactionDetails> listFindActiveTransactions = customerCenterViewModelImpl.findActiveTransactions(customerInfo2);
            if (listFindActiveTransactions.isEmpty()) {
                Logger.INSTANCE.w("Could not find subscription information");
            } else {
                List<TransactionDetails> list = listFindActiveTransactions;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                dateFormatter3 = dateFormatter2;
                localization3 = localization2;
                c090812 = c090813;
                locale3 = locale2;
                customerInfo = customerInfo2;
                customerCenterViewModelImpl2 = customerCenterViewModelImpl;
                it = list.iterator();
                collection = arrayList;
                if (it.hasNext()) {
                }
            }
        }
        TransactionDetails.Subscription subscriptionFindLatestExpiredSubscription = customerCenterViewModelImpl.findLatestExpiredSubscription(customerInfo2);
        if (subscriptionFindLatestExpiredSubscription == null) {
            return CollectionsKt.emptyList();
        }
        Iterator<T> it4 = customerInfo2.getEntitlements().getActive().values().iterator();
        while (true) {
            if (!it4.hasNext()) {
                next = null;
                break;
            }
            next = it4.next();
            if (Intrinsics.areEqual(((EntitlementInfo) next).getProductIdentifier(), subscriptionFindLatestExpiredSubscription.getProductIdentifier())) {
                break;
            }
        }
        EntitlementInfo entitlementInfo2 = (EntitlementInfo) next;
        if (entitlementInfo2 == null) {
            Iterator<T> it5 = customerInfo2.getEntitlements().getAll().values().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it5.next();
                if (Intrinsics.areEqual(((EntitlementInfo) next2).getProductIdentifier(), subscriptionFindLatestExpiredSubscription.getProductIdentifier())) {
                    break;
                }
            }
            entitlementInfo2 = (EntitlementInfo) next2;
        }
        c090813.L$0 = null;
        c090813.L$1 = null;
        c090813.L$2 = null;
        c090813.L$3 = null;
        c090813.label = 3;
        objAwaitCustomerInfo = customerCenterViewModelImpl.createPurchaseInformation(subscriptionFindLatestExpiredSubscription, entitlementInfo2, dateFormatter2, locale2, localization2, c090813);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mainPathAction(CustomerCenterConfigData.HelpPath path, Context context, PurchaseInformation purchaseInformation) {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        String actionIdentifier;
        StoreProduct product;
        int i = WhenMappings.$EnumSwitchMapping$0[path.getType().ordinal()];
        if (i == 1) {
            MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
                successCopy$default = value;
                if (successCopy$default instanceof CustomerCenterState.Success) {
                    successCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) successCopy$default, null, null, null, null, RestorePurchasesState.RESTORING, null, null, null, null, false, false, 2031, null);
                }
            } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
            return;
        }
        if (i == 2) {
            handleCancelPath(context, purchaseInformation);
            return;
        }
        if (i != 3) {
            if (i == 4 && (actionIdentifier = path.getActionIdentifier()) != null) {
                onCustomActionSelected(new CustomActionData(actionIdentifier, (purchaseInformation == null || (product = purchaseInformation.getProduct()) == null) ? null : product.getId()));
                return;
            }
            return;
        }
        String url = path.getUrl();
        if (url != null) {
            CustomerCenterConfigData.HelpPath.OpenMethod openMethod = path.getOpenMethod();
            if (openMethod == null) {
                openMethod = CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL;
            }
            openURL(context, url, openMethod);
        }
    }

    static /* synthetic */ void mainPathAction$default(CustomerCenterViewModelImpl customerCenterViewModelImpl, CustomerCenterConfigData.HelpPath helpPath, Context context, PurchaseInformation purchaseInformation, int i, Object obj) {
        if ((i & 4) != 0) {
            purchaseInformation = null;
        }
        customerCenterViewModelImpl.mainPathAction(helpPath, context, purchaseInformation);
    }

    private final void notifyListenersForCustomActionSelected(CustomActionData customActionData) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onCustomActionSelected(customActionData.getActionIdentifier(), customActionData.getPurchaseIdentifier());
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onCustomActionSelected(customActionData.getActionIdentifier(), customActionData.getPurchaseIdentifier());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListenersForFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
        }
    }

    private final void notifyListenersForManageSubscription() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onShowingManageSubscriptions();
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onShowingManageSubscriptions();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void notifyListenersForManagementOptionSelected(CustomerCenterConfigData.HelpPath path, PurchaseInformation purchaseInformation) {
        CustomerCenterManagementOption.MissingPurchase customUrl;
        StoreProduct product;
        int i = WhenMappings.$EnumSwitchMapping$0[path.getType().ordinal()];
        if (i == 1) {
            customUrl = CustomerCenterManagementOption.MissingPurchase.INSTANCE;
        } else if (i != 2) {
            id = null;
            String id = null;
            CustomerCenterManagementOption.CustomAction customAction = null;
            customUrl = null;
            if (i == 3) {
                String url = path.getUrl();
                customUrl = url != null ? new CustomerCenterManagementOption.CustomUrl(Uri.parse(url)) : null;
            } else if (i == 4) {
                String actionIdentifier = path.getActionIdentifier();
                if (actionIdentifier != null) {
                    if (purchaseInformation != null && (product = purchaseInformation.getProduct()) != null) {
                        id = product.getId();
                    }
                    customAction = new CustomerCenterManagementOption.CustomAction(actionIdentifier, id);
                }
                customUrl = customAction;
            }
        } else {
            customUrl = CustomerCenterManagementOption.Cancel.INSTANCE;
        }
        if (customUrl != null) {
            CustomerCenterListener customerCenterListener = this.listener;
            if (customerCenterListener != null) {
                customerCenterListener.onManagementOptionSelected(customUrl);
            }
            CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
            if (customerCenterListener2 != null) {
                customerCenterListener2.onManagementOptionSelected(customUrl);
            }
        }
    }

    private final void notifyListenersForPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onPromotionalOfferSucceeded(customerInfo, transaction);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onPromotionalOfferSucceeded(customerInfo, transaction);
        }
    }

    private final void notifyListenersForRestoreCompleted(CustomerInfo customerInfo) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreCompleted(customerInfo);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreCompleted(customerInfo);
        }
    }

    private final void notifyListenersForRestoreFailed(PurchasesError error) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreFailed(error);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreFailed(error);
        }
    }

    private final void notifyListenersForRestoreStarted() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreStarted();
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreStarted();
        }
    }

    private final CustomerCenterState.Success preservingUIStateIfRefresh(CustomerCenterState.Success success, boolean z, CustomerCenterState customerCenterState) {
        if (!z || !(customerCenterState instanceof CustomerCenterState.Success)) {
            return success;
        }
        CustomerCenterState.Success success2 = (CustomerCenterState.Success) customerCenterState;
        CustomerCenterNavigationState navigationState = success2.getNavigationState();
        CustomerCenterState.NavigationButtonType navigationButtonType = customerCenterState.getNavigationButtonType();
        return CustomerCenterState.Success.copy$default(success, null, null, null, success2.getDetailScreenPaths(), success2.getRestorePurchasesState(), null, navigationState, navigationButtonType, null, success2.getShowSupportTicketSuccessSnackbar(), false, 1319, null);
    }

    private final CustomerCenterState.Success resetToMainScreen(CustomerCenterState.Success success) {
        return CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().popToMain(), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1839, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object shouldResumeRestorePurchases(CustomerCenterListener customerCenterListener, String str, Continuation<? super Boolean> continuation) {
        C09121 c09121;
        Unit unit;
        if (continuation instanceof C09121) {
            c09121 = (C09121) continuation;
            if ((c09121.label & Integer.MIN_VALUE) != 0) {
                c09121.label -= Integer.MIN_VALUE;
            } else {
                c09121 = new C09121(continuation);
            }
        }
        Object result = c09121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09121.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            c09121.L$0 = customerCenterListener;
            c09121.L$1 = str;
            c09121.label = 1;
            C09121 c091212 = c09121;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c091212), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Logger.INSTANCE.d("Restore Purchases Initiated… waiting for " + str + " to proceed.");
            if (customerCenterListener != null) {
                customerCenterListener.onRestoreInitiated(new Resumable() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$shouldResume$1$1
                    @Override // com.revenuecat.purchases.customercenter.Resumable
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
                DebugProbesKt.probeCoroutineSuspended(c091212);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        boolean zBooleanValue = ((Boolean) result).booleanValue();
        Logger.INSTANCE.d("Restore Purchases gate complete. The SDK **" + (zBooleanValue ? "will" : "will not") + "** attempt to restore purchases.");
        return Boxing.boxBoolean(zBooleanValue);
    }

    private final void showManageSubscriptions(Context context, String productId) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions?sku=" + productId + "&package=" + context.getPackageName())));
        } catch (ActivityNotFoundException e) {
            Logger.INSTANCE.e("Error opening manage subscriptions", e);
        }
    }

    private final void startAmazonCancellation(Context context, Uri managementURL) {
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/library/subscriptions")));
        } catch (ActivityNotFoundException unused) {
            String string = managementURL.toString();
            Intrinsics.checkNotNullExpressionValue(string, "managementURL.toString()");
            openURL(context, string, CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL);
        }
    }

    private final void startGoogleProductCancellation(Context context, StoreProduct product) {
        GoogleStoreProduct googleStoreProduct = product instanceof GoogleStoreProduct ? (GoogleStoreProduct) product : null;
        if (googleStoreProduct == null) {
            Logger.INSTANCE.e("Expected GoogleStoreProduct for Play Store cancellation");
            return;
        }
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        showManageSubscriptions(context, googleStoreProduct.getProductId());
    }

    private final void startManagementUrlCancellation(Context context, Uri managementURL) {
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        String string = managementURL.toString();
        Intrinsics.checkNotNullExpressionValue(string, "managementURL.toString()");
        openURL(context, string, CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL);
    }

    private final List<CustomerCenterConfigData.HelpPath> supportedPaths(PurchaseInformation selectedPurchaseInformation, CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        List<CustomerCenterConfigData.HelpPath> paths = screen.getPaths();
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (isPathAllowedForStore((CustomerCenterConfigData.HelpPath) obj, selectedPurchaseInformation)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (isPathAllowedForSubscriptionState((CustomerCenterConfigData.HelpPath) obj2, selectedPurchaseInformation)) {
                arrayList2.add(obj2);
            }
        }
        return transformPathsOnSubscriptionState(arrayList2, selectedPurchaseInformation, localization);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackCustomerCenterEventOptionChosen(CustomerCenterConfigData.HelpPath.PathType path, String url, String surveyOptionID) {
        Locale locale = this._lastLocaleList.getValue().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Date date = new Date();
        boolean z = this.isDarkMode;
        String string = locale.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        this.purchases.track(new CustomerCenterSurveyOptionChosenEvent(null, new CustomerCenterSurveyOptionChosenEvent.Data(date, z, string, 0, 0, null, path, url, surveyOptionID, null, 568, null), 1, null));
    }

    private final List<CustomerCenterConfigData.HelpPath> transformPathsOnSubscriptionState(List<CustomerCenterConfigData.HelpPath> list, PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        List<CustomerCenterConfigData.HelpPath> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CustomerCenterConfigData.HelpPath helpPathCopy$default : list2) {
            if (helpPathCopy$default.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL && purchaseInformation != null && purchaseInformation.isCancelled()) {
                helpPathCopy$default = CustomerCenterConfigData.HelpPath.copy$default(helpPathCopy$default, null, localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.RESUBSCRIBE), null, null, null, null, null, null, 229, null);
            }
            arrayList.add(helpPathCopy$default);
        }
        return arrayList;
    }

    private final void tryFallbackToCurrentOffering(final Context context) {
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.tryFallbackToCurrentOffering.1
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
                CustomerCenterViewModelImpl.this.handlePaywallError("Failed to get current offering: " + error.getMessage(), error.getCode());
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.tryFallbackToCurrentOffering.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                invoke2(offerings);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                Offering current = offerings.getCurrent();
                if (current == null) {
                    CustomerCenterViewModelImpl.this.handlePaywallError("No offering available for paywall presentation", PurchasesErrorCode.ConfigurationError);
                } else {
                    Logger.INSTANCE.d("Falling back to current offering: " + current.getIdentifier());
                    CustomerCenterViewModelImpl.this.launchPaywallActivity(context, current);
                }
            }
        });
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void clearActionError() {
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void contactSupport(Context context, String supportEmail) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(supportEmail, "supportEmail");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME + supportEmail));
        intent.putExtra("android.intent.extra.SUBJECT", "Support Request");
        intent.putExtra("android.intent.extra.TEXT", "Support request details...");
        context.startActivity(Intent.createChooser(intent, "Contact Support"));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void dismissPromotionalOffer(Context context, CustomerCenterConfigData.HelpPath originalPath) {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        CustomerCenterState value2 = this._state.getValue();
        CustomerCenterState.Success success = value2 instanceof CustomerCenterState.Success ? (CustomerCenterState.Success) value2 : null;
        CustomerCenterDestination currentDestination = success != null ? success.getCurrentDestination() : null;
        mainPathAction(originalPath, context, currentDestination instanceof CustomerCenterDestination.PromotionalOffer ? ((CustomerCenterDestination.PromotionalOffer) currentDestination).getPurchaseInformation() : null);
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            successCopy$default = value;
            if (successCopy$default instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success2 = (CustomerCenterState.Success) successCopy$default;
                successCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, success2.getNavigationState().popToMain(), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1855, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object dismissRestoreDialog(Continuation<? super Unit> continuation) {
        Object objLoadCustomerCenter = loadCustomerCenter(continuation);
        return objLoadCustomerCenter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLoadCustomerCenter : Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void dismissSupportTicketSuccessSnackbar() {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            successCopy$default = value;
            if (successCopy$default instanceof CustomerCenterState.Success) {
                successCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) successCopy$default, null, null, null, null, null, null, null, null, null, false, false, 1535, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public StateFlow<CustomerCenterState> getState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadAndDisplayPromotionalOffer(Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation<? super Boolean> continuation) {
        C09071 c09071;
        CustomerCenterConfigData.HelpPath helpPath2;
        PurchaseInformation purchaseInformation2;
        Object promotionalSubscriptionOption;
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        CustomerCenterViewModelImpl customerCenterViewModelImpl = this;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer2 = promotionalOffer;
        if (continuation instanceof C09071) {
            c09071 = (C09071) continuation;
            if ((c09071.label & Integer.MIN_VALUE) != 0) {
                c09071.label -= Integer.MIN_VALUE;
            } else {
                c09071 = customerCenterViewModelImpl.new C09071(continuation);
            }
        }
        Object obj = c09071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09071.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!promotionalOffer2.getEligible()) {
                Logger.INSTANCE.d("User not eligible for promo with id '" + promotionalOffer2.getAndroidOfferId() + "'. Check eligibility configuration in the dashboard, and make sure the user has an active/expired subscription for the product with id '" + storeProduct.getId() + "'.");
                return Boxing.boxBoolean(false);
            }
            c09071.L$0 = customerCenterViewModelImpl;
            c09071.L$1 = promotionalOffer2;
            helpPath2 = helpPath;
            c09071.L$2 = helpPath2;
            purchaseInformation2 = purchaseInformation;
            c09071.L$3 = purchaseInformation2;
            c09071.label = 1;
            promotionalSubscriptionOption = customerCenterViewModelImpl.getPromotionalSubscriptionOption(promotionalOffer2, storeProduct, c09071);
            if (promotionalSubscriptionOption == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PurchaseInformation purchaseInformation3 = (PurchaseInformation) c09071.L$3;
            CustomerCenterConfigData.HelpPath helpPath3 = (CustomerCenterConfigData.HelpPath) c09071.L$2;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer3 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) c09071.L$1;
            CustomerCenterViewModelImpl customerCenterViewModelImpl2 = (CustomerCenterViewModelImpl) c09071.L$0;
            ResultKt.throwOnFailure(obj);
            purchaseInformation2 = purchaseInformation3;
            customerCenterViewModelImpl = customerCenterViewModelImpl2;
            promotionalSubscriptionOption = obj;
            helpPath2 = helpPath3;
            promotionalOffer2 = promotionalOffer3;
        }
        SubscriptionOption subscriptionOption = (SubscriptionOption) promotionalSubscriptionOption;
        if (subscriptionOption == null) {
            return Boxing.boxBoolean(false);
        }
        MutableStateFlow<CustomerCenterState> mutableStateFlow = customerCenterViewModelImpl._state;
        do {
            value = mutableStateFlow.getValue();
            successCopy$default = value;
            if (successCopy$default instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) successCopy$default;
                CustomerCenterDestination.PromotionalOffer promotionalOffer4 = new CustomerCenterDestination.PromotionalOffer(new PromotionalOfferData(promotionalOffer2, subscriptionOption, helpPath2, SubscriptionOptionExtensionsKt.getLocalizedDescription(subscriptionOption, success.getCustomerCenterConfigData().getLocalization(), customerCenterViewModelImpl.locale)), purchaseInformation2);
                CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(promotionalOffer4), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1855, null);
                successCopy$default = CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(promotionalOffer4), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1855, null);
                z = true;
            }
        } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
        return Boxing.boxBoolean(z);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object loadCustomerCenter(Continuation<? super Unit> continuation) {
        Object objLoadCustomerCenter = loadCustomerCenter(false, continuation);
        return objLoadCustomerCenter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLoadCustomerCenter : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
    
        if (r5.loadCustomerCenter(r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onAcceptedPromotionalOffer(SubscriptionOption subscriptionOption, Activity activity, Continuation<? super Unit> continuation) {
        C09091 c09091;
        if (continuation instanceof C09091) {
            c09091 = (C09091) continuation;
            if ((c09091.label & Integer.MIN_VALUE) != 0) {
                c09091.label -= Integer.MIN_VALUE;
            } else {
                c09091 = new C09091(continuation);
            }
        }
        Object objAwaitPurchase = c09091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09091.label;
        try {
        } catch (PurchasesException e) {
            if (e.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
                this._actionError.setValue(e.getError());
                goBackToMain();
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitPurchase);
            if (activity == null) {
                Logger.INSTANCE.e("Activity is null when accepting promotional offer");
                this._actionError.setValue(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "Couldn't perform purchase"));
                return Unit.INSTANCE;
            }
            PurchaseParams.Builder builder = new PurchaseParams.Builder(activity, subscriptionOption);
            PurchasesType purchasesType = this.purchases;
            c09091.L$0 = this;
            c09091.label = 1;
            objAwaitPurchase = purchasesType.awaitPurchase(builder, c09091);
            if (objAwaitPurchase == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitPurchase);
            return Unit.INSTANCE;
        }
        this = (CustomerCenterViewModelImpl) c09091.L$0;
        ResultKt.throwOnFailure(objAwaitPurchase);
        PurchaseResult purchaseResult = (PurchaseResult) objAwaitPurchase;
        this.notifyListenersForPromotionalOfferSucceeded(purchaseResult.getCustomerInfo(), purchaseResult.getStoreTransaction());
        c09091.L$0 = this;
        c09091.label = 2;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityResumed() {
        if (this.shouldRefreshOnResume) {
            this.shouldRefreshOnResume = false;
            Logger.INSTANCE.d("Refreshing Customer Center after returning from manage subscriptions");
            launchRefreshIfPossible();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityStarted() {
        if (this.wasBackgrounded) {
            this.wasBackgrounded = false;
            if (this.shouldRefreshOnResume) {
                return;
            }
            launchRefreshIfPossible();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityStopped(boolean isChangingConfigurations) {
        if (isChangingConfigurations) {
            return;
        }
        this.wasBackgrounded = true;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onCustomActionSelected(CustomActionData customActionData) {
        Intrinsics.checkNotNullParameter(customActionData, "customActionData");
        notifyListenersForCustomActionSelected(customActionData);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onNavigationButtonPressed(Context context, Function0<Unit> onDismiss) {
        CustomerCenterState value;
        CustomerCenterState.NotLoaded notLoadedCopy$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        CustomerCenterState value2 = this._state.getValue();
        if (value2 instanceof CustomerCenterState.Success) {
            CustomerCenterState.Success success = (CustomerCenterState.Success) value2;
            if (success.getCurrentDestination() instanceof CustomerCenterDestination.PromotionalOffer) {
                CustomerCenterDestination currentDestination = success.getCurrentDestination();
                Intrinsics.checkNotNull(currentDestination, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination.PromotionalOffer");
                dismissPromotionalOffer(context, ((CustomerCenterDestination.PromotionalOffer) currentDestination).getData().getOriginalPath());
                return;
            }
        }
        CustomerCenterState.NavigationButtonType navigationButtonType = getState().getValue().getNavigationButtonType();
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            CustomerCenterState customerCenterState = value;
            if ((customerCenterState instanceof CustomerCenterState.Success) && navigationButtonType == CustomerCenterState.NavigationButtonType.BACK) {
                CustomerCenterState.Success success2 = (CustomerCenterState.Success) customerCenterState;
                if (success2.getNavigationState().getCanNavigateBack()) {
                    CustomerCenterNavigationState customerCenterNavigationStatePop = success2.getNavigationState().pop();
                    notLoadedCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, customerCenterNavigationStatePop, customerCenterNavigationStatePop.getCanNavigateBack() ? CustomerCenterState.NavigationButtonType.BACK : CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1855, null);
                } else {
                    notLoadedCopy$default = CustomerCenterState.NotLoaded.INSTANCE;
                }
            } else {
                notLoadedCopy$default = CustomerCenterState.NotLoaded.INSTANCE;
            }
        } while (!mutableStateFlow.compareAndSet(value, notLoadedCopy$default));
        if (navigationButtonType == CustomerCenterState.NavigationButtonType.CLOSE) {
            onDismiss.invoke();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void openURL(Context context, String url, CustomerCenterConfigData.HelpPath.OpenMethod method) {
        URLOpeningMethod uRLOpeningMethod;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        int i = WhenMappings.$EnumSwitchMapping$1[method.ordinal()];
        if (i == 1) {
            uRLOpeningMethod = URLOpeningMethod.IN_APP_BROWSER;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            uRLOpeningMethod = URLOpeningMethod.EXTERNAL_BROWSER;
        }
        URLOpener.INSTANCE.openURL$revenuecatui_defaultsBc8Release(context, url, uRLOpeningMethod);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void pathButtonPressed(final Context context, final CustomerCenterConfigData.HelpPath path, final PurchaseInformation purchaseInformation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        notifyListenersForManagementOptionSelected(path, purchaseInformation);
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = path.getFeedbackSurvey();
        if (feedbackSurvey != null) {
            displayFeedbackSurvey(feedbackSurvey, new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                    if (option != null) {
                        CustomerCenterViewModelImpl customerCenterViewModelImpl = this.this$0;
                        CustomerCenterConfigData.HelpPath helpPath = path;
                        Context context2 = context;
                        PurchaseInformation purchaseInformation2 = purchaseInformation;
                        customerCenterViewModelImpl.trackCustomerCenterEventOptionChosen(helpPath.getType(), helpPath.getUrl(), option.getId());
                        customerCenterViewModelImpl.notifyListenersForFeedbackSurveyCompleted(option.getId());
                        if (BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(customerCenterViewModelImpl), null, null, new CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(customerCenterViewModelImpl, context2, purchaseInformation2, option, helpPath, null), 3, null) != null) {
                            return;
                        }
                    }
                    this.this$0.goBackToMain();
                    Unit unit = Unit.INSTANCE;
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09102(context, purchaseInformation, path, null), 3, null);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void refreshColors(ColorScheme currentColorScheme, boolean isSystemInDarkTheme) {
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        this.isDarkMode = isSystemInDarkTheme;
        this._colorScheme.setValue(currentColorScheme);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object refreshCustomerCenter(Continuation<? super Unit> continuation) {
        Object objLoadCustomerCenter = loadCustomerCenter(true, continuation);
        return objLoadCustomerCenter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLoadCustomerCenter : Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void refreshStateIfLocaleChanged() {
        LocaleListCompat currentLocaleList = getCurrentLocaleList();
        if (Intrinsics.areEqual(this._lastLocaleList.getValue(), currentLocaleList)) {
            return;
        }
        this._lastLocaleList.setValue(currentLocaleList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0125, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0126, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0145, code lost:
    
        r2 = com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success.copy$default((com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success) r2, null, null, null, null, com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState.PURCHASES_NOT_FOUND, null, null, null, null, false, false, 2031, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fb A[Catch: PurchasesException -> 0x003a, TryCatch #1 {PurchasesException -> 0x003a, blocks: (B:14:0x0035, B:44:0x00cf, B:46:0x00dd, B:50:0x00eb, B:51:0x00f0, B:53:0x00fb, B:55:0x0100, B:57:0x0105, B:56:0x0103, B:58:0x011e), top: B:75:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object restorePurchases(Continuation<? super Unit> continuation) {
        C09111 c09111;
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        CustomerCenterViewModelImpl customerCenterViewModelImpl;
        CustomerCenterState value2;
        CustomerCenterState.Success successCopy$default2;
        CustomerInfo customerInfo;
        MutableStateFlow<CustomerCenterState> mutableStateFlow;
        CustomerCenterState value3;
        CustomerCenterState.Success successCopy$default3;
        CustomerCenterViewModelImpl customerCenterViewModelImpl2 = this;
        if (continuation instanceof C09111) {
            c09111 = (C09111) continuation;
            if ((c09111.label & Integer.MIN_VALUE) != 0) {
                c09111.label -= Integer.MIN_VALUE;
            } else {
                c09111 = customerCenterViewModelImpl2.new C09111(continuation);
            }
        }
        Object objShouldResumeRestorePurchases = c09111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09111.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objShouldResumeRestorePurchases);
            CustomerCenterListener customerCenterListener = customerCenterViewModelImpl2.listener;
            c09111.L$0 = customerCenterViewModelImpl2;
            c09111.label = 1;
            objShouldResumeRestorePurchases = customerCenterViewModelImpl2.shouldResumeRestorePurchases(customerCenterListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, c09111);
            if (objShouldResumeRestorePurchases != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                customerCenterViewModelImpl = (CustomerCenterViewModelImpl) c09111.L$0;
                try {
                    ResultKt.throwOnFailure(objShouldResumeRestorePurchases);
                    customerInfo = (CustomerInfo) objShouldResumeRestorePurchases;
                    if (customerInfo.getActiveSubscriptions().isEmpty() && customerInfo.getNonSubscriptionTransactions().isEmpty()) {
                        z = false;
                    }
                    customerCenterViewModelImpl.notifyListenersForRestoreCompleted(customerInfo);
                    mutableStateFlow = customerCenterViewModelImpl._state;
                    do {
                        value3 = mutableStateFlow.getValue();
                        successCopy$default3 = value3;
                        if (successCopy$default3 instanceof CustomerCenterState.Success) {
                            successCopy$default3 = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) successCopy$default3, null, null, null, null, z ? RestorePurchasesState.PURCHASES_RECOVERED : RestorePurchasesState.PURCHASES_NOT_FOUND, null, null, null, null, false, false, 2031, null);
                        }
                    } while (!mutableStateFlow.compareAndSet(value3, successCopy$default3));
                } catch (PurchasesException e) {
                    e = e;
                    Logger.INSTANCE.e("Error restoring purchases", e);
                    customerCenterViewModelImpl.notifyListenersForRestoreFailed(e.getError());
                    MutableStateFlow<CustomerCenterState> mutableStateFlow2 = customerCenterViewModelImpl._state;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        successCopy$default2 = value2;
                        if (successCopy$default2 instanceof CustomerCenterState.Success) {
                        }
                    } while (!mutableStateFlow2.compareAndSet(value2, successCopy$default2));
                }
                return Unit.INSTANCE;
            }
            customerCenterViewModelImpl2 = (CustomerCenterViewModelImpl) c09111.L$0;
            ResultKt.throwOnFailure(objShouldResumeRestorePurchases);
            CustomerCenterViewModelImpl customerCenterViewModelImpl3 = customerCenterViewModelImpl2;
            if (((Boolean) objShouldResumeRestorePurchases).booleanValue()) {
                customerCenterViewModelImpl3.notifyListenersForRestoreStarted();
                MutableStateFlow<CustomerCenterState> mutableStateFlow3 = customerCenterViewModelImpl3._state;
                do {
                    value = mutableStateFlow3.getValue();
                    successCopy$default = value;
                    if (successCopy$default instanceof CustomerCenterState.Success) {
                        successCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) successCopy$default, null, null, null, null, RestorePurchasesState.RESTORING, null, null, null, null, false, false, 2031, null);
                    }
                } while (!mutableStateFlow3.compareAndSet(value, successCopy$default));
                PurchasesType purchasesType = customerCenterViewModelImpl3.purchases;
                c09111.L$0 = customerCenterViewModelImpl3;
                c09111.label = 3;
                objShouldResumeRestorePurchases = purchasesType.awaitRestore(c09111);
                if (objShouldResumeRestorePurchases != coroutine_suspended) {
                    customerCenterViewModelImpl = customerCenterViewModelImpl3;
                    customerInfo = (CustomerInfo) objShouldResumeRestorePurchases;
                    if (customerInfo.getActiveSubscriptions().isEmpty()) {
                        z = false;
                    }
                    customerCenterViewModelImpl.notifyListenersForRestoreCompleted(customerInfo);
                    mutableStateFlow = customerCenterViewModelImpl._state;
                    do {
                        value3 = mutableStateFlow.getValue();
                        successCopy$default3 = value3;
                        if (successCopy$default3 instanceof CustomerCenterState.Success) {
                        }
                    } while (!mutableStateFlow.compareAndSet(value3, successCopy$default3));
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        customerCenterViewModelImpl2 = (CustomerCenterViewModelImpl) c09111.L$0;
        ResultKt.throwOnFailure(objShouldResumeRestorePurchases);
        if (((Boolean) objShouldResumeRestorePurchases).booleanValue()) {
            CustomerCenterListener customerCenterListener2 = customerCenterViewModelImpl2.purchases.getCustomerCenterListener();
            c09111.L$0 = customerCenterViewModelImpl2;
            c09111.label = 2;
            objShouldResumeRestorePurchases = customerCenterViewModelImpl2.shouldResumeRestorePurchases(customerCenterListener2, "purchases.customerCenterListener", c09111);
            if (objShouldResumeRestorePurchases != coroutine_suspended) {
                CustomerCenterViewModelImpl customerCenterViewModelImpl32 = customerCenterViewModelImpl2;
                if (((Boolean) objShouldResumeRestorePurchases).booleanValue()) {
                }
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void selectPurchase(PurchaseInformation purchase) {
        CustomerCenterState value;
        CustomerCenterState.Error error;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            error = value;
            if (error instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) error;
                CustomerCenterConfigData.Screen managementScreen = success.getCustomerCenterConfigData().getManagementScreen();
                if (managementScreen != null) {
                    error = CustomerCenterState.Success.copy$default(success, null, null, null, PathUtils.INSTANCE.filterSubscriptionSpecificPaths(supportedPaths(purchase, managementScreen, success.getCustomerCenterConfigData().getLocalization())), null, null, success.getNavigationState().push(new CustomerCenterDestination.SelectedPurchaseDetail(purchase, managementScreen.getTitle())), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1847, null);
                } else {
                    Logger.INSTANCE.e("No management screen available in the customer center config data");
                    error = new CustomerCenterState.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "No management screen available in the customer center config data"));
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, error));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showCreateSupportTicket() {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        CustomerCenterState value2 = this._state.getValue();
        if (value2 instanceof CustomerCenterState.Success) {
            MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
                successCopy$default = value;
                if (successCopy$default instanceof CustomerCenterState.Success) {
                    CustomerCenterState.Success success = (CustomerCenterState.Success) successCopy$default;
                    successCopy$default = CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(new CustomerCenterDestination.CreateSupportTicket(new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$1
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Function0<? extends Unit> function0, Function0<? extends Unit> function02) {
                            invoke2(str, str2, (Function0<Unit>) function0, (Function0<Unit>) function02);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String email, String description, Function0<Unit> onSuccess, Function0<Unit> onError) {
                            Intrinsics.checkNotNullParameter(email, "email");
                            Intrinsics.checkNotNullParameter(description, "description");
                            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
                            Intrinsics.checkNotNullParameter(onError, "onError");
                            this.this$0.handleSupportTicketSubmit(email, description, onSuccess, onError);
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            this.this$0.goBackToMain();
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$3
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            this.this$0.goBackToMain();
                        }
                    }), ((CustomerCenterState.Success) value2).getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUPPORT_TICKET_CREATE))), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
                }
            } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showPaywall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomerCenterState value = this._state.getValue();
        if (value instanceof CustomerCenterState.Success) {
            Offering noActiveScreenOffering = ((CustomerCenterState.Success) value).getNoActiveScreenOffering();
            if (noActiveScreenOffering != null) {
                launchPaywallActivity(context, noActiveScreenOffering);
            } else {
                tryFallbackToCurrentOffering(context);
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showVirtualCurrencyBalances() {
        CustomerCenterState value;
        CustomerCenterState.Success successCopy$default;
        CustomerCenterState value2 = this._state.getValue();
        if (value2 instanceof CustomerCenterState.Success) {
            CustomerCenterState.Success success = (CustomerCenterState.Success) value2;
            if (Intrinsics.areEqual((Object) success.getCustomerCenterConfigData().getSupport().getDisplayVirtualCurrencies(), (Object) true)) {
                MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
                do {
                    value = mutableStateFlow.getValue();
                    successCopy$default = value;
                    if (successCopy$default instanceof CustomerCenterState.Success) {
                        CustomerCenterState.Success success2 = (CustomerCenterState.Success) successCopy$default;
                        successCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, success2.getNavigationState().push(new CustomerCenterDestination.VirtualCurrencyBalances(success.getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER))), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
                    }
                } while (!mutableStateFlow.compareAndSet(value, successCopy$default));
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void trackImpressionIfNeeded() {
        if (this.impressionCreationData == null) {
            this.impressionCreationData = new CustomerCenterImpressionEvent.CreationData(null, null, 3, null);
            Locale locale = this._lastLocaleList.getValue().get(0);
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Date date = new Date();
            boolean z = this.isDarkMode;
            String string = locale.toString();
            Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
            this.purchases.track(new CustomerCenterImpressionEvent(null, new CustomerCenterImpressionEvent.Data(date, z, string, 0, 0, null, 56, null), 1, null));
        }
    }
}
