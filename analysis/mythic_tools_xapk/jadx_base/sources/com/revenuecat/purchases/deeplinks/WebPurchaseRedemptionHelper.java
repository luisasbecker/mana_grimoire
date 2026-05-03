package com.revenuecat.purchases.deeplinks;

import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.CustomerInfoUpdateHandler;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebPurchaseRedemptionHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/deeplinks/WebPurchaseRedemptionHelper;", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Landroid/os/Handler;)V", "dispatch", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "dispatchResult", "resultListener", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "result", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "handleRedeemWebPurchase", "webPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebPurchaseRedemptionHelper {
    private final Backend backend;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final IdentityManager identityManager;
    private final Handler mainHandler;
    private final OfflineEntitlementsManager offlineEntitlementsManager;

    public WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        this.backend = backend;
        this.identityManager = identityManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.mainHandler = handler;
    }

    public /* synthetic */ WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backend, identityManager, offlineEntitlementsManager, customerInfoUpdateHandler, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    private final void dispatch(final Function0<Unit> action) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            action.invoke();
            return;
        }
        Handler handler = this.mainHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchResult(final RedeemWebPurchaseListener resultListener, final RedeemWebPurchaseListener.Result result) {
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper.dispatchResult.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                resultListener.handleResult(result);
            }
        });
    }

    public final void handleRedeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, final RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Starting web purchase redemption.");
        }
        this.backend.postRedeemWebPurchase(this.identityManager.getCurrentAppUserID(), webPurchaseRedemption.getRedemptionToken(), new Function1<RedeemWebPurchaseListener.Result, Unit>() { // from class: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper.handleRedeemWebPurchase.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RedeemWebPurchaseListener.Result result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RedeemWebPurchaseListener.Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!(result instanceof RedeemWebPurchaseListener.Result.Success)) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error redeeming web purchase: " + result, null);
                    WebPurchaseRedemptionHelper.this.dispatchResult(listener, result);
                    return;
                }
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Successfully redeemed web purchase. Updating customer info.");
                }
                WebPurchaseRedemptionHelper.this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                WebPurchaseRedemptionHelper.this.customerInfoUpdateHandler.cacheAndNotifyListeners(((RedeemWebPurchaseListener.Result.Success) result).getCustomerInfo());
                WebPurchaseRedemptionHelper.this.dispatchResult(listener, result);
            }
        });
    }
}
