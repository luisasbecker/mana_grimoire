package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackendStoredEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0010"}, d2 = {"toBackendEvent", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "toBackendStoredEvent", "Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;", "appUserID", "", "appSessionID", "Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Open;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackendStoredEventKt {
    public static final BackendEvent toBackendEvent(BackendStoredEvent backendStoredEvent) {
        Intrinsics.checkNotNullParameter(backendStoredEvent, "<this>");
        if (backendStoredEvent instanceof BackendStoredEvent.Paywalls) {
            return ((BackendStoredEvent.Paywalls) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomerCenter) {
            return ((BackendStoredEvent.CustomerCenter) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.Ad) {
            return ((BackendStoredEvent.Ad) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomPaywall) {
            return ((BackendStoredEvent.CustomPaywall) backendStoredEvent).getEvent();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Displayed displayed, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(displayed, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(displayed.getId(), displayed.getEventVersion(), displayed.getType().getValue(), displayed.getTimestamp(), displayed.getNetworkName(), displayed.getMediatorName(), displayed.getAdFormat(), displayed.getPlacement(), displayed.getAdUnitId(), displayed.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.FailedToLoad failedToLoad, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(failedToLoad, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(failedToLoad.getId(), failedToLoad.getEventVersion(), failedToLoad.getType().getValue(), failedToLoad.getTimestamp(), (String) null, failedToLoad.getMediatorName(), failedToLoad.getAdFormat(), failedToLoad.getPlacement(), failedToLoad.getAdUnitId(), failedToLoad.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, failedToLoad.getMediatorErrorCode(), 28688, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Loaded loaded, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(loaded, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(loaded.getId(), loaded.getEventVersion(), loaded.getType().getValue(), loaded.getTimestamp(), loaded.getNetworkName(), loaded.getMediatorName(), loaded.getAdFormat(), loaded.getPlacement(), loaded.getAdUnitId(), loaded.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Open open, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(open, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(open.getId(), open.getEventVersion(), open.getType().getValue(), open.getTimestamp(), open.getNetworkName(), open.getMediatorName(), open.getAdFormat(), open.getPlacement(), open.getAdUnitId(), open.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Revenue revenue, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(revenue, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(revenue.getId(), revenue.getEventVersion(), revenue.getType().getValue(), revenue.getTimestamp(), revenue.getNetworkName(), revenue.getMediatorName(), revenue.getAdFormat(), revenue.getPlacement(), revenue.getAdUnitId(), revenue.getImpressionId(), appUserID, appSessionID, Long.valueOf(revenue.getRevenueMicros()), revenue.getCurrency(), revenue.getPrecision(), (Integer) null, 32768, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterImpressionEvent customerCenterImpressionEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterImpressionEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterImpressionEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterImpressionEvent.getData().getRevisionID(), customerCenterImpressionEvent.getData().getType(), appUserID, appSessionID, customerCenterImpressionEvent.getData().getTimestamp().getTime(), customerCenterImpressionEvent.getData().getDarkMode(), customerCenterImpressionEvent.getData().getLocale(), customerCenterImpressionEvent.getData().getDisplayMode(), null, null, null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterSurveyOptionChosenEvent customerCenterSurveyOptionChosenEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterSurveyOptionChosenEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterSurveyOptionChosenEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterSurveyOptionChosenEvent.getData().getRevisionID(), customerCenterSurveyOptionChosenEvent.getData().getType(), appUserID, appSessionID, customerCenterSurveyOptionChosenEvent.getData().getTimestamp().getTime(), customerCenterSurveyOptionChosenEvent.getData().getDarkMode(), customerCenterSurveyOptionChosenEvent.getData().getLocale(), customerCenterSurveyOptionChosenEvent.getData().getDisplayMode(), customerCenterSurveyOptionChosenEvent.getData().getPath(), customerCenterSurveyOptionChosenEvent.getData().getUrl(), customerCenterSurveyOptionChosenEvent.getData().getSurveyOptionID()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomPaywallEvent.Impression impression, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(impression, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = impression.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomPaywall(new BackendEvent.CustomPaywall(string, 1, "custom_paywall_impression", appUserID, appSessionID, impression.getCreationData().getDate().getTime(), impression.getData().getPaywallId(), impression.getData().getOfferingId()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(PaywallEvent paywallEvent, String appUserID) {
        Intrinsics.checkNotNullParameter(paywallEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (paywallEvent.getType() == PaywallEventType.PURCHASE_INITIATED || paywallEvent.getType() == PaywallEventType.PURCHASE_ERROR) {
            return null;
        }
        String string = paywallEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        String value = paywallEvent.getType().getValue();
        String string2 = paywallEvent.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "data.sessionIdentifier.toString()");
        String offeringIdentifier = paywallEvent.getData().getPresentedOfferingContext().getOfferingIdentifier();
        String paywallIdentifier = paywallEvent.getData().getPaywallIdentifier();
        int paywallRevision = paywallEvent.getData().getPaywallRevision();
        long time = paywallEvent.getCreationData().getDate().getTime();
        String displayMode = paywallEvent.getData().getDisplayMode();
        boolean darkMode = paywallEvent.getData().getDarkMode();
        String localeIdentifier = paywallEvent.getData().getLocaleIdentifier();
        ExitOfferType exitOfferType = paywallEvent.getData().getExitOfferType();
        return new BackendStoredEvent.Paywalls(new BackendEvent.Paywalls(string, 1, value, appUserID, string2, offeringIdentifier, paywallIdentifier, paywallRevision, time, displayMode, darkMode, localeIdentifier, exitOfferType != null ? exitOfferType.getValue() : null, paywallEvent.getData().getExitOfferingIdentifier(), paywallEvent.getData().getPackageIdentifier(), paywallEvent.getData().getProductIdentifier(), paywallEvent.getData().getErrorCode(), paywallEvent.getData().getErrorMessage()));
    }
}
