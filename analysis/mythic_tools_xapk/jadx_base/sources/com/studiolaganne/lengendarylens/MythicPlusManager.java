package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MythicPlusManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusManager;", "", "<init>", "()V", "TAG", "", "ENTITLEMENT_ID", "_isActiveFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isActiveFlow", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isActive", "context", "Landroid/content/Context;", "handleCustomerInfoUpdate", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "refreshStatus", "clearStatus", "setActive", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "initFromCache", "updateStatus", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusManager {
    public static final int $stable;
    public static final String ENTITLEMENT_ID = "Mythic+";
    public static final MythicPlusManager INSTANCE = new MythicPlusManager();
    private static final String TAG = "[MythicPlus]";
    private static final MutableStateFlow<Boolean> _isActiveFlow;
    private static final StateFlow<Boolean> isActiveFlow;

    static {
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        _isActiveFlow = MutableStateFlow;
        isActiveFlow = FlowKt.asStateFlow(MutableStateFlow);
        $stable = 8;
    }

    private MythicPlusManager() {
    }

    static final Unit refreshStatus$lambda$0(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e(TAG, "refreshStatus failed: " + error.getMessage() + " (code=" + error.getCode() + ")");
        return Unit.INSTANCE;
    }

    static final Unit refreshStatus$lambda$1(Context context, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        INSTANCE.handleCustomerInfoUpdate(context, customerInfo);
        return Unit.INSTANCE;
    }

    private final void updateStatus(Context context, boolean active) {
        MutableStateFlow<Boolean> mutableStateFlow = _isActiveFlow;
        boolean zBooleanValue = mutableStateFlow.getValue().booleanValue();
        new PreferencesManager(context).setMythicPlusActive(active);
        mutableStateFlow.setValue(Boolean.valueOf(active));
        if (zBooleanValue != active) {
            Log.d(TAG, "Status changed: " + zBooleanValue + " -> " + active);
        }
    }

    public final void clearStatus(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "clearStatus — resetting to false");
        updateStatus(context, false);
    }

    public final void handleCustomerInfoUpdate(Context context, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (customerInfo == null) {
            Log.w(TAG, "handleCustomerInfoUpdate called with null CustomerInfo");
            return;
        }
        EntitlementInfo entitlementInfo = customerInfo.getEntitlements().get(ENTITLEMENT_ID);
        boolean z = entitlementInfo != null && entitlementInfo.getIsActive();
        Log.d(TAG, "CustomerInfo update — appUserID=" + customerInfo.getOriginalAppUserId());
        Log.d(TAG, "  entitlements keys: " + customerInfo.getEntitlements().getAll().keySet());
        Log.d(TAG, "  'Mythic+' entitlement: " + (entitlementInfo != null) + ", isActive=" + z);
        if (entitlementInfo != null) {
            Log.d(TAG, "  productId=" + entitlementInfo.getProductIdentifier() + ", expiresDate=" + entitlementInfo.getExpirationDate() + ", willRenew=" + entitlementInfo.getWillRenew());
        }
        updateStatus(context, z);
    }

    public final void initFromCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsMythicPlusActive = new PreferencesManager(context).isMythicPlusActive();
        Log.d(TAG, "initFromCache — cached value: " + zIsMythicPlusActive);
        _isActiveFlow.setValue(Boolean.valueOf(zIsMythicPlusActive));
    }

    public final boolean isActive(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PreferencesManager(context).isMythicPlusActive();
    }

    public final StateFlow<Boolean> isActiveFlow() {
        return isActiveFlow;
    }

    public final void refreshStatus(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "refreshStatus — fetching CustomerInfo from RevenueCat...");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.INSTANCE.getSharedInstance(), new Function1() { // from class: com.studiolaganne.lengendarylens.MythicPlusManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MythicPlusManager.refreshStatus$lambda$0((PurchasesError) obj);
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.MythicPlusManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MythicPlusManager.refreshStatus$lambda$1(context, (CustomerInfo) obj);
            }
        });
    }

    public final void setActive(Context context, boolean active) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "setActive — " + active);
        updateStatus(context, active);
    }
}
