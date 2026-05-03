package com.revenuecat.purchases;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Offerings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"withPresentedContext", "Lcom/revenuecat/purchases/Offering;", "placementId", "", "targeting", "Lcom/revenuecat/purchases/Offerings$Targeting;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingsKt {
    public static final Offering withPresentedContext(Offering offering, String str, Offerings.Targeting targeting) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        for (Package r3 : availablePackages) {
            PresentedOfferingContext presentedOfferingContext = r3.getPresentedOfferingContext();
            PresentedOfferingContext presentedOfferingContextCopy$default = PresentedOfferingContext.copy$default(presentedOfferingContext, null, str == null ? presentedOfferingContext.getPlacementIdentifier() : str, targeting != null ? new PresentedOfferingContext.TargetingContext(targeting.getRevision(), targeting.getRuleId()) : presentedOfferingContext.getTargetingContext(), 1, null);
            arrayList.add(new Package(r3.getIdentifier(), r3.getPackageType(), r3.getProduct().copyWithPresentedOfferingContext(presentedOfferingContextCopy$default), presentedOfferingContextCopy$default, r3.getWebCheckoutURL()));
        }
        return new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), arrayList, offering.getPaywall(), offering.getPaywallComponents(), offering.getWebCheckoutURL());
    }
}
