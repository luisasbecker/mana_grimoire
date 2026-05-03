package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HelperFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\"\u0010\r\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tH\u0080@¢\u0006\u0002\u0010\u000f\u001a?\u0010\r\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00100\tH\u0000\u001a\r\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0018"}, d2 = {"LocalActivity", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/app/Activity;", "getLocalActivity", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "isInPreviewMode", "", "(Landroidx/compose/runtime/Composer;I)Z", "shouldDisplayBlockForEntitlementIdentifier", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "entitlement", "", "shouldDisplayPaywall", "shouldDisplayBlock", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "result", "Lkotlin/ParameterName;", "name", "shouldDisplay", "windowAspectRatio", "", "(Landroidx/compose/runtime/Composer;I)F", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HelperFunctionsKt {
    private static final ProvidableCompositionLocal<Activity> LocalActivity = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Activity>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt$LocalActivity$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Activity invoke() {
            return null;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<Activity> getLocalActivity() {
        return LocalActivity;
    }

    public static final boolean isInPreviewMode(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 774792703, "C(isInPreviewMode)24@956L7:HelperFunctions.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(774792703, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.isInPreviewMode (HelperFunctions.kt:24)");
        }
        ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localInspectionMode);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zBooleanValue = ((Boolean) objConsume).booleanValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zBooleanValue;
    }

    public static final Function1<CustomerInfo, Boolean> shouldDisplayBlockForEntitlementIdentifier(final String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        return new Function1<CustomerInfo, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                EntitlementInfo entitlementInfo = customerInfo.getEntitlements().get(entitlement);
                boolean z = false;
                if (entitlementInfo != null && entitlementInfo.getIsActive()) {
                    z = true;
                }
                return Boolean.valueOf(!z);
            }
        };
    }

    public static final Object shouldDisplayPaywall(Function1<? super CustomerInfo, Boolean> function1, Continuation<? super Boolean> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        shouldDisplayPaywall(function1, new HelperFunctionsKt$shouldDisplayPaywall$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final void shouldDisplayPaywall(final Function1<? super CustomerInfo, Boolean> shouldDisplayBlock, final Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        Intrinsics.checkNotNullParameter(result, "result");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.3
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
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Logger.INSTANCE.e("Error fetching customer info to display paywall", new PurchasesException(it));
                result.invoke(false);
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                boolean zBooleanValue = shouldDisplayBlock.invoke(it).booleanValue();
                if (zBooleanValue) {
                    Logger.INSTANCE.d("Displaying paywall according to display logic");
                } else {
                    Logger.INSTANCE.d("Not displaying paywall according to display logic");
                }
                result.invoke(Boolean.valueOf(zBooleanValue));
            }
        });
    }

    public static final float windowAspectRatio(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1944383602, "C(windowAspectRatio)29@1082L7:HelperFunctions.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1944383602, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.windowAspectRatio (HelperFunctions.kt:28)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        float f = configuration.screenHeightDp / configuration.screenWidthDp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }
}
