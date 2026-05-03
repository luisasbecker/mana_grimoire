package com.revenuecat.purchases.galaxy;

import android.content.Context;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.caching.DeviceCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalaxyBillingWrapperFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/galaxy/GalaxyBillingWrapperFactory;", "", "()V", "createGalaxyBillingWrapper", "Lcom/revenuecat/purchases/common/BillingAbstract;", "stateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "context", "Landroid/content/Context;", "billingMode", "Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalaxyBillingWrapperFactory {
    public static final GalaxyBillingWrapperFactory INSTANCE = new GalaxyBillingWrapperFactory();

    private GalaxyBillingWrapperFactory() {
    }

    public final BillingAbstract createGalaxyBillingWrapper(PurchasesStateProvider stateProvider, Context context, GalaxyBillingMode billingMode, DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(billingMode, "billingMode");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        try {
            Object objNewInstance = Class.forName("com.revenuecat.purchases.galaxy.GalaxyBillingWrapper").getDeclaredConstructor(PurchasesStateProvider.class, Context.class, GalaxyBillingMode.class, DeviceCache.class).newInstance(stateProvider, context, billingMode, deviceCache);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.revenuecat.purchases.common.BillingAbstract");
            return (BillingAbstract) objNewInstance;
        } catch (ClassNotFoundException e) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e.getMessage());
            noClassDefFoundError.initCause(e);
            throw noClassDefFoundError;
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Failed to find GalaxyBillingWrapper constructor. Please ensure that you've declared a dependency on the purchases-galaxy module.", e2);
        } catch (ReflectiveOperationException e3) {
            throw new IllegalStateException("Failed to create GalaxyBillingWrapper", e3);
        }
    }
}
