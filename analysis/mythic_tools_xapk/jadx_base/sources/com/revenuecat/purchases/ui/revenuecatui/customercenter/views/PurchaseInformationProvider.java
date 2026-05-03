package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PurchaseInformationCardView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/PurchaseInformationProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PurchaseInformationProvider implements PreviewParameterProvider<PurchaseInformation> {
    private final Sequence<PurchaseInformation> values = SequencesKt.sequenceOf((Object[]) new PurchaseInformation[]{CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationYearlyExpiring(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationYearlyExpired(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationFreeTrial(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationPromotional(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationLifetime(), PurchaseInformation.copy$default(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), "Monthly long subscription name that overflows", null, null, null, null, false, null, false, false, false, false, 2046, null)});

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<PurchaseInformation> getValues() {
        return this.values;
    }
}
