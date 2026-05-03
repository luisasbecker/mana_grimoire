package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0081@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"resolveButtonText", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "resolveOfferingSuspend", "Lcom/revenuecat/purchases/Offering;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScreenOfferingExtensionsKt {

    /* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.values().length];
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt", f = "ScreenOfferingExtensions.kt", i = {0}, l = {14}, m = "resolveOfferingSuspend", n = {"screenOffering"}, s = {"L$0"})
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
            return ScreenOfferingExtensionsKt.resolveOfferingSuspend(null, null, this);
        }
    }

    public static final String resolveButtonText(CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        String buttonText;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        return (offering == null || (buttonText = offering.getButtonText()) == null) ? localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BUY_SUBSCRIPTION) : buttonText;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveOfferingSuspend(CustomerCenterConfigData.Screen screen, PurchasesType purchasesType, Continuation<? super Offering> continuation) {
        AnonymousClass1 anonymousClass1;
        CustomerCenterConfigData.ScreenOffering offering;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitOfferings = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitOfferings);
            offering = screen.getOffering();
            if (offering == null) {
                return null;
            }
            anonymousClass1.L$0 = offering;
            anonymousClass1.label = 1;
            objAwaitOfferings = purchasesType.awaitOfferings(anonymousClass1);
            if (objAwaitOfferings == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            offering = (CustomerCenterConfigData.ScreenOffering) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwaitOfferings);
        }
        Offerings offerings = (Offerings) objAwaitOfferings;
        int i2 = WhenMappings.$EnumSwitchMapping$0[offering.getType().ordinal()];
        if (i2 == 1) {
            return offerings.getCurrent();
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        String offeringId = offering.getOfferingId();
        if (offeringId != null) {
            return offerings.getAll().get(offeringId);
        }
        return null;
    }
}
