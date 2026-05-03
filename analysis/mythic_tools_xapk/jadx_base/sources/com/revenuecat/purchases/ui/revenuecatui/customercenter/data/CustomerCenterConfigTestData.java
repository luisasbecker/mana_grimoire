package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.ExpirationOrRenewal;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: CustomerCenterConfigTestData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterConfigTestData;", "", "()V", "fiveVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getFiveVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "fourVirtualCurrencies", "getFourVirtualCurrencies", "purchaseInformationFreeTrial", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "getPurchaseInformationFreeTrial", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "purchaseInformationLifetime", "getPurchaseInformationLifetime", "purchaseInformationMonthlyRenewing", "getPurchaseInformationMonthlyRenewing", "purchaseInformationPromotional", "getPurchaseInformationPromotional", "purchaseInformationYearlyExpired", "getPurchaseInformationYearlyExpired", "purchaseInformationYearlyExpiring", "getPurchaseInformationYearlyExpiring", "standardAppearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "getStandardAppearance", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "customerCenterData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "shouldWarnCustomerToUpdate", "", "allowSupportTicketCreation", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigTestData {
    private static final PurchaseInformation purchaseInformationFreeTrial;
    private static final PurchaseInformation purchaseInformationYearlyExpired;
    private static final PurchaseInformation purchaseInformationYearlyExpiring;
    public static final CustomerCenterConfigTestData INSTANCE = new CustomerCenterConfigTestData();
    private static final CustomerCenterConfigData.Appearance standardAppearance = new CustomerCenterConfigData.Appearance(new CustomerCenterConfigData.Appearance.ColorInformation(new PaywallColor("#007AFF"), new PaywallColor("#000000"), new PaywallColor("#f5f5f7"), new PaywallColor("#7A0000"), new PaywallColor("#287aff")), new CustomerCenterConfigData.Appearance.ColorInformation(new PaywallColor("#FFFFFF"), new PaywallColor("#FFFFFF"), new PaywallColor("#A96800"), new PaywallColor("#FF2600"), new PaywallColor("#000000")));
    private static final PurchaseInformation purchaseInformationMonthlyRenewing = new PurchaseInformation("Basic", new PriceDetails.Paid("$4.99"), new ExpirationOrRenewal.Renewal("June 1st, 2024"), new TestStoreProduct("monthly_product_id", "Basic", Constants.GP_IAP_TITLE, "description", new Price("$4.99", 4990000, "US"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, 192, null), Store.PLAY_STORE, true, Uri.parse("https://play.google.com/store/account/subscriptions"), false, false, false, false);
    private static final PurchaseInformation purchaseInformationLifetime = new PurchaseInformation("Lifetime", new PriceDetails.Paid("$100.99"), null, null, Store.APP_STORE, false, Uri.parse("https://play.google.com/store/account/subscriptions"), false, false, false, true);
    private static final PurchaseInformation purchaseInformationPromotional = new PurchaseInformation("rc_promo_Test1_lifetime", PriceDetails.Free.INSTANCE, new ExpirationOrRenewal.Expiration("April 24th, 2225"), null, Store.PROMOTIONAL, false, null, false, false, true, false);
    private static final VirtualCurrencies fourVirtualCurrencies = new VirtualCurrencies(MapsKt.mapOf(TuplesKt.to("GLD", new VirtualCurrency(100, "Gold", "GLD", "It's gold")), TuplesKt.to("SLV", new VirtualCurrency(200, "Silver", "SLV", "It's silver")), TuplesKt.to("BRNZ", new VirtualCurrency(300, "Bronze", "BRNZ", "It's bronze")), TuplesKt.to("PLTNM", new VirtualCurrency(400, "Platinum", "PLTNM", "It's platinum"))));
    private static final VirtualCurrencies fiveVirtualCurrencies = new VirtualCurrencies(MapsKt.mapOf(TuplesKt.to("GLD", new VirtualCurrency(100, "Gold", "GLD", "It's gold")), TuplesKt.to("SLV", new VirtualCurrency(200, "Silver", "SLV", "It's silver")), TuplesKt.to("BRNZ", new VirtualCurrency(300, "Bronze", "BRNZ", "It's bronze")), TuplesKt.to("PLTNM", new VirtualCurrency(400, "Platinum", "PLTNM", "It's platinum")), TuplesKt.to("RC_COIN", new VirtualCurrency(1, "RC Coin", "RC_COIN", "RevenueCat Coin"))));
    public static final int $stable = 8;

    static {
        int i = 192;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Period period = null;
        Price price = null;
        purchaseInformationYearlyExpiring = new PurchaseInformation("Basic", new PriceDetails.Paid("$40.99"), new ExpirationOrRenewal.Expiration("June 1st, 2024"), new TestStoreProduct("yearly_product_id", "Basic", Constants.GP_IAP_TITLE, "description", new Price("$40.99", 40990000L, "US"), new Period(1, Period.Unit.YEAR, "P1Y"), period, price, i, defaultConstructorMarker), Store.PLAY_STORE, true, Uri.parse("https://play.google.com/store/account/subscriptions"), false, false, true, false);
        purchaseInformationYearlyExpired = new PurchaseInformation("Basic", new PriceDetails.Paid("$40.99"), new ExpirationOrRenewal.Expiration("June 1st, 2024"), new TestStoreProduct("yearly_product_id", "Basic", Constants.GP_IAP_TITLE, "description", new Price("$40.99", 40990000L, "US"), new Period(1, Period.Unit.YEAR, "P1Y"), period, price, i, defaultConstructorMarker), Store.PLAY_STORE, true, Uri.parse("https://play.google.com/store/account/subscriptions"), true, false, true, false);
        purchaseInformationFreeTrial = new PurchaseInformation("Premium", PriceDetails.Free.INSTANCE, new ExpirationOrRenewal.Expiration("June 15th, 2024"), new TestStoreProduct("premium_yearly_product_id", "Premium", Constants.GP_IAP_TITLE, "description", new Price("$59.99", 59990000L, "US"), new Period(1, Period.Unit.YEAR, "P1Y"), period, price, i, defaultConstructorMarker), Store.PLAY_STORE, true, Uri.parse("https://play.google.com/store/account/subscriptions"), false, true, false, false);
    }

    private CustomerCenterConfigTestData() {
    }

    public static /* synthetic */ CustomerCenterConfigData customerCenterData$default(CustomerCenterConfigTestData customerCenterConfigTestData, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return customerCenterConfigTestData.customerCenterData(z, z2);
    }

    public final CustomerCenterConfigData customerCenterData(boolean shouldWarnCustomerToUpdate, boolean allowSupportTicketCreation) {
        return new CustomerCenterConfigData(MapsKt.mapOf(TuplesKt.to(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT, new CustomerCenterConfigData.Screen(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT, "Manage Subscription", (String) null, CollectionsKt.listOf((Object[]) new CustomerCenterConfigData.HelpPath[]{new CustomerCenterConfigData.HelpPath("1", "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath(ExifInterface.GPS_MEASUREMENT_2D, "Request a refund", CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST, new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer("offer_id", true, "Wait a minute...", "Before you cancel, please consider accepting this one time offer", MapsKt.mapOf(TuplesKt.to("monthly", "offer_id"))), (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 240, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath(ExifInterface.GPS_MEASUREMENT_3D, "Change plans", CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath("4", "Cancel subscription", CustomerCenterConfigData.HelpPath.PathType.CANCEL, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey("Why are you cancelling?", CollectionsKt.listOf((Object[]) new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option[]{new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option("1", "Too expensive", new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer("offer_id", true, "Wait a minute...", "Before you cancel, please consider accepting this offer", MapsKt.mapOf(TuplesKt.to("monthly", "offer_id")))), new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option(ExifInterface.GPS_MEASUREMENT_2D, "Don't use the app", (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, 4, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option(ExifInterface.GPS_MEASUREMENT_3D, "Bought by mistake", (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, 4, (DefaultConstructorMarker) null)})), (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 232, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath("5", "FAQ", CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, "https://www.revenuecat.com/docs/customer-center-faq", (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 216, (DefaultConstructorMarker) null)}), (CustomerCenterConfigData.ScreenOffering) null, 16, (DefaultConstructorMarker) null)), TuplesKt.to(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE, new CustomerCenterConfigData.Screen(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE, "No subscriptions found", "We can try checking your account for any previous purchases", CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("9q9719171o", "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, (DefaultConstructorMarker) null)), (CustomerCenterConfigData.ScreenOffering) null, 16, (DefaultConstructorMarker) null))), standardAppearance, new CustomerCenterConfigData.Localization("en_US", MapsKt.mapOf(TuplesKt.to("cancel", "Cancel"), TuplesKt.to("back", "Back"))), new CustomerCenterConfigData.Support("test-support@revenuecat.com", Boolean.valueOf(shouldWarnCustomerToUpdate), (Boolean) null, new CustomerCenterConfigData.Support.SupportTickets(allowSupportTicketCreation, new CustomerCenterConfigData.Support.SupportTickets.CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false), CustomerCenterConfigData.Support.SupportTickets.CustomerType.NOT_ACTIVE), 4, (DefaultConstructorMarker) null), (String) null, 16, (DefaultConstructorMarker) null);
    }

    public final VirtualCurrencies getFiveVirtualCurrencies() {
        return fiveVirtualCurrencies;
    }

    public final VirtualCurrencies getFourVirtualCurrencies() {
        return fourVirtualCurrencies;
    }

    public final PurchaseInformation getPurchaseInformationFreeTrial() {
        return purchaseInformationFreeTrial;
    }

    public final PurchaseInformation getPurchaseInformationLifetime() {
        return purchaseInformationLifetime;
    }

    public final PurchaseInformation getPurchaseInformationMonthlyRenewing() {
        return purchaseInformationMonthlyRenewing;
    }

    public final PurchaseInformation getPurchaseInformationPromotional() {
        return purchaseInformationPromotional;
    }

    public final PurchaseInformation getPurchaseInformationYearlyExpired() {
        return purchaseInformationYearlyExpired;
    }

    public final PurchaseInformation getPurchaseInformationYearlyExpiring() {
        return purchaseInformationYearlyExpiring;
    }

    public final CustomerCenterConfigData.Appearance getStandardAppearance() {
        return standardAppearance;
    }
}
