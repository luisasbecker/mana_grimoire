package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOfferingExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042#\b\u0002\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¨\u0006\u000e"}, d2 = {"resolveOffering", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "error", "onSuccess", "Lcom/revenuecat/purchases/Offering;", "offering", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScreenOfferingExtensionsKt {
    public static final void resolveOffering(CustomerCenterConfigData.Screen screen, Purchases purchases, Function1<? super PurchasesError, Unit> onError, final Function1<? super Offering, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        final CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        if (offering == null) {
            onSuccess.invoke(null);
        } else {
            ListenerConversionsCommonKt.getOfferingsWith(purchases, onError, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt.resolveOffering.2

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt$resolveOffering$2$WhenMappings */
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    Offering current;
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    int i = WhenMappings.$EnumSwitchMapping$0[offering.getType().ordinal()];
                    if (i == 1) {
                        current = offerings.getCurrent();
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String offeringId = offering.getOfferingId();
                        current = offeringId != null ? offerings.getAll().get(offeringId) : null;
                    }
                    onSuccess.invoke(current);
                }
            });
        }
    }

    public static /* synthetic */ void resolveOffering$default(CustomerCenterConfigData.Screen screen, Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt.resolveOffering.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        resolveOffering(screen, purchases, function1, function12);
    }
}
