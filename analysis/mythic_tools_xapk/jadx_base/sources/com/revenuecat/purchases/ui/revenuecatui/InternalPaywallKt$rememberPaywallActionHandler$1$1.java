package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$rememberPaywallActionHandler$1$1", f = "InternalPaywall.kt", i = {}, l = {276, 281}, m = "invokeSuspend", n = {}, s = {})
final class InternalPaywallKt$rememberPaywallActionHandler$1$1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Context $context;
    final /* synthetic */ PaywallViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalPaywallKt$rememberPaywallActionHandler$1$1(PaywallViewModel paywallViewModel, Activity activity, Context context, Continuation<? super InternalPaywallKt$rememberPaywallActionHandler$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = paywallViewModel;
        this.$activity = activity;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InternalPaywallKt$rememberPaywallActionHandler$1$1 internalPaywallKt$rememberPaywallActionHandler$1$1 = new InternalPaywallKt$rememberPaywallActionHandler$1$1(this.$viewModel, this.$activity, this.$context, continuation);
        internalPaywallKt$rememberPaywallActionHandler$1$1.L$0 = obj;
        return internalPaywallKt$rememberPaywallActionHandler$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
        return ((InternalPaywallKt$rememberPaywallActionHandler$1$1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        if (r6.$viewModel.handleRestorePurchases(r6) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r6.$viewModel.handlePackagePurchase(r1, r7.getRcPackage(), r7.getResolvedOffer(), r6) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PaywallAction.External external = (PaywallAction.External) this.L$0;
            if (external instanceof PaywallAction.External.RestorePurchases) {
                this.label = 1;
            } else if (external instanceof PaywallAction.External.PurchasePackage) {
                Activity activity = this.$activity;
                if (activity == null) {
                    Logger.INSTANCE.e("Activity is null, not initiating package purchase");
                } else {
                    PaywallAction.External.PurchasePackage purchasePackage = (PaywallAction.External.PurchasePackage) external;
                    this.label = 2;
                }
            } else if (external instanceof PaywallAction.External.LaunchWebCheckout) {
                PaywallAction.External.LaunchWebCheckout launchWebCheckout = (PaywallAction.External.LaunchWebCheckout) external;
                String webCheckoutUrl = this.$viewModel.getWebCheckoutUrl(launchWebCheckout);
                if (webCheckoutUrl == null) {
                    Logger.INSTANCE.e("Web checkout URL cannot be found, not launching web checkout.");
                } else {
                    this.$viewModel.invalidateCustomerInfoCache();
                    InternalPaywallKt.handleUrlDestination(this.$context, webCheckoutUrl, launchWebCheckout.getOpenMethod());
                    if (launchWebCheckout.getAutoDismiss()) {
                        Logger.INSTANCE.d("Auto-dismissing paywall after launching web checkout.");
                        PaywallViewModel.DefaultImpls.closePaywall$default(this.$viewModel, null, 1, null);
                    }
                }
            } else if (external instanceof PaywallAction.External.NavigateBack) {
                PaywallViewModel.DefaultImpls.closePaywall$default(this.$viewModel, null, 1, null);
            } else if (external instanceof PaywallAction.External.NavigateTo) {
                PaywallAction.External.NavigateTo.Destination destination = ((PaywallAction.External.NavigateTo) external).getDestination();
                if (destination instanceof PaywallAction.External.NavigateTo.Destination.CustomerCenter) {
                    Logger.INSTANCE.w("Customer Center is not yet implemented on Android.");
                } else if (destination instanceof PaywallAction.External.NavigateTo.Destination.Url) {
                    PaywallAction.External.NavigateTo.Destination.Url url = (PaywallAction.External.NavigateTo.Destination.Url) destination;
                    InternalPaywallKt.handleUrlDestination(this.$context, url.getUrl(), url.getMethod());
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
