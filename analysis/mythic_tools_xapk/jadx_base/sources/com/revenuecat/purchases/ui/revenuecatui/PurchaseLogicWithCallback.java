package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseLogic.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Use PaywallPurchaseLogicWithCallback instead for product change and offer support.", replaceWith = @ReplaceWith(expression = "PaywallPurchaseLogicWithCallback", imports = {}))
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rH&J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rH&¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicWithCallback;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogic;", "()V", "performPurchase", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "activity", "Landroid/app/Activity;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performPurchaseWithCompletion", "", "completion", "Lkotlin/Function1;", "performRestore", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRestoreWithCompletion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PurchaseLogicWithCallback implements PurchaseLogic {
    public static final int $stable = 0;

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic
    public final Object performPurchase(Activity activity, Package r5, Continuation<? super PurchaseLogicResult> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        performPurchaseWithCompletion(activity, r5, new Function1<PurchaseLogicResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicWithCallback$performPurchase$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchaseLogicResult purchaseLogicResult) {
                invoke2(purchaseLogicResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Continuation<PurchaseLogicResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic, com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation<? super PurchaseLogicResult> continuation) {
        return PurchaseLogic.DefaultImpls.performPurchase(this, activity, paywallPurchaseLogicParams, continuation);
    }

    public abstract void performPurchaseWithCompletion(Activity activity, Package rcPackage, Function1<? super PurchaseLogicResult, Unit> completion);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public final Object performRestore(CustomerInfo customerInfo, Continuation<? super PurchaseLogicResult> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        performRestoreWithCompletion(customerInfo, new Function1<PurchaseLogicResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicWithCallback$performRestore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchaseLogicResult purchaseLogicResult) {
                invoke2(purchaseLogicResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Continuation<PurchaseLogicResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public abstract void performRestoreWithCompletion(CustomerInfo customerInfo, Function1<? super PurchaseLogicResult, Unit> completion);
}
