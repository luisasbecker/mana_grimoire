package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResultHandler;
import com.studiolaganne.lengendarylens.CustomCodeDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.MythicPlusInfoDialogFragment;
import com.studiolaganne.lengendarylens.StoreActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: StoreActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u001aH\u0014J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J(\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0002J\b\u00100\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208H\u0002J\u0012\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/StoreActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/ThemeListClickListener;", "Lcom/studiolaganne/lengendarylens/ThemeCallback;", "<init>", "()V", "allThemes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "spotlightThemes", "categoryNames", "", "", "selectedCategory", "showTabs", "", "prices", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themesProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "currentSku", "paywallActivityLauncher", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLauncher;", "onThemeClose", "", "onThemeUpdate", "theme", "onThemeAlreadyBought", "wasFree", "onThemeTapped", "onBuyTapped", "onResume", "applyPricesToThemes", "applyStoreMode", "setupTabs", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "spotlightContainer", "Landroid/view/View;", "themesContainer", "themesHeaderLayout", "setupCategoryChips", "createCategoryChip", "Lcom/google/android/material/chip/Chip;", Constants.ScionAnalytics.PARAM_LABEL, ViewHierarchyConstants.TAG_KEY, "setupSpotlight", "setupThemesList", "showPaywallInfoDialog", "launchPaywall", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StoreActivity extends BaseActivity implements ThemeListClickListener, ThemeCallback {
    private static final String ALL_CATEGORY_ID = "__all__";
    private static final int TAB_SPOTLIGHT = 0;
    private static final int TAB_THEMES = 1;
    private BillingClient billingClient;
    private String selectedCategory;
    private boolean showTabs;
    public static final int $stable = 8;
    private List<MTTheme> allThemes = new ArrayList();
    private List<MTTheme> spotlightThemes = new ArrayList();
    private List<String> categoryNames = CollectionsKt.emptyList();
    private Map<String, String> prices = new LinkedHashMap();
    private Map<String, ProductDetails> themesProductDetails = new LinkedHashMap();
    private String currentSku = "";
    private final PaywallActivityLauncher paywallActivityLauncher = new PaywallActivityLauncher(this, new PaywallResultHandler() { // from class: com.studiolaganne.lengendarylens.StoreActivity$paywallActivityLauncher$1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(PaywallResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof PaywallResult.Purchased) {
                MythicPlusManager.INSTANCE.refreshStatus(this.this$0);
                this.this$0.applyStoreMode();
                MythicPlusThankYouDialog.INSTANCE.show(this.this$0);
            } else if (result instanceof PaywallResult.Restored) {
                MythicPlusManager.INSTANCE.refreshStatus(this.this$0);
                this.this$0.applyStoreMode();
            }
        }
    });
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda4
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            StoreActivity.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
        }
    };

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.StoreActivity$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/StoreActivity$onCreate$3", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass3 implements BillingClientStateListener {
        AnonymousClass3() {
        }

        static final void onBillingSetupFinished$lambda$1(final StoreActivity storeActivity, BillingResult billingResult, QueryProductDetailsResult productDetailsResult) {
            String formattedPrice;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
            if (billingResult.getResponseCode() == 0) {
                storeActivity.prices.clear();
                for (ProductDetails productDetails : productDetailsResult.getProductDetailsList()) {
                    String productId = productDetails.getProductId();
                    Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) {
                        formattedPrice = "";
                    }
                    storeActivity.prices.put(productId, formattedPrice);
                    storeActivity.themesProductDetails.put(productId, productDetails);
                }
                Log.d("MTApi", "Prices received: " + storeActivity.prices);
                storeActivity.applyPricesToThemes();
                Log.d("MTApi", "Prices received, refreshing spotlight and themes adapters");
                ((RecyclerView) storeActivity.findViewById(R.id.spotlightRecyclerView)).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onCreate$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        StoreActivity.AnonymousClass3.onBillingSetupFinished$lambda$1$0(storeActivity);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBillingSetupFinished$lambda$1$0(StoreActivity storeActivity) {
            storeActivity.setupSpotlight();
            storeActivity.setupThemesList();
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            if (billingResult.getResponseCode() == 0) {
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{PreferencesManager.SOLRING_THEME, PreferencesManager.XMAS_THEME, PreferencesManager.BURN_THEME, PreferencesManager.LOVE_THEME, PreferencesManager.AF_THEME, PreferencesManager.LUPO_THEME});
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId((String) it.next()).setProductType("inapp").build());
                }
                QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
                Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "build(...)");
                BillingClient billingClient = StoreActivity.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                final StoreActivity storeActivity = StoreActivity.this;
                billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onCreate$3$$ExternalSyntheticLambda0
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult2, QueryProductDetailsResult queryProductDetailsResult) {
                        StoreActivity.AnonymousClass3.onBillingSetupFinished$lambda$1(storeActivity, billingResult2, queryProductDetailsResult);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.StoreActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StoreActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/StoreActivity$onResume$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTThemesResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12581 implements Callback<MTThemesResponse> {
        final /* synthetic */ ConstraintLayout $overlay;

        C12581(ConstraintLayout constraintLayout) {
            this.$overlay = constraintLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onResponse$lambda$0$0$0(MTTheme theme) {
            Intrinsics.checkNotNullParameter(theme, "theme");
            if (theme.getInstore() != null) {
                return !r1.booleanValue();
            }
            return true;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTThemesResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            this.$overlay.setVisibility(8);
            ((TextView) StoreActivity.this.findViewById(R.id.nothingToSeeLabel)).setVisibility(0);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTThemesResponse> call, Response<MTThemesResponse> response) {
            String name;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            boolean zIsSuccessful = response.isSuccessful();
            StoreActivity storeActivity = StoreActivity.this;
            if (zIsSuccessful) {
                ((TextView) storeActivity.findViewById(R.id.nothingToSeeLabel)).setVisibility(8);
                MTThemesResponse mTThemesResponseBody = response.body();
                List<MTTheme> themes = mTThemesResponseBody != null ? mTThemesResponseBody.getThemes() : null;
                if (themes != null) {
                    StoreActivity storeActivity2 = StoreActivity.this;
                    List mutableList = CollectionsKt.toMutableList((Collection) themes);
                    CollectionsKt.removeAll(mutableList, new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onResume$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(StoreActivity.C12581.onResponse$lambda$0$0$0((MTTheme) obj));
                        }
                    });
                    List list = mutableList;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (Intrinsics.areEqual((Object) ((MTTheme) obj).getSpotlight(), (Object) true)) {
                            arrayList.add(obj);
                        }
                    }
                    storeActivity2.spotlightThemes = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onResume$1$onResponse$lambda$0$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer spotlight_order = ((MTTheme) t).getSpotlight_order();
                            Integer numValueOf = Integer.valueOf(spotlight_order != null ? spotlight_order.intValue() : Integer.MAX_VALUE);
                            Integer spotlight_order2 = ((MTTheme) t2).getSpotlight_order();
                            return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(spotlight_order2 != null ? spotlight_order2.intValue() : Integer.MAX_VALUE));
                        }
                    }));
                    storeActivity2.allThemes = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onResume$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t2).getGoogleproductid(), "theme_dr", false, 2, (Object) null)), Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t).getGoogleproductid(), "theme_dr", false, 2, (Object) null)));
                        }
                    }));
                    List list2 = storeActivity2.allThemes;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        MTThemeCategory category = ((MTTheme) it.next()).getCategory();
                        if (category == null || (name = category.getName()) == null || StringsKt.isBlank(name)) {
                            name = null;
                        }
                        if (name != null) {
                            arrayList2.add(name);
                        }
                    }
                    storeActivity2.categoryNames = CollectionsKt.sorted(CollectionsKt.distinct(arrayList2));
                    storeActivity2.applyPricesToThemes();
                    Log.d("MTApi", "Themes received, total=" + storeActivity2.allThemes.size() + " spotlight=" + storeActivity2.spotlightThemes.size());
                    storeActivity2.applyStoreMode();
                }
            } else {
                ((TextView) storeActivity.findViewById(R.id.nothingToSeeLabel)).setVisibility(0);
            }
            this.$overlay.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPricesToThemes() {
        for (List list : CollectionsKt.listOf((Object[]) new List[]{this.allThemes, this.spotlightThemes})) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                String str = this.prices.get(((MTTheme) it.next()).getGoogleproductid());
                if (str != null) {
                    ((MTTheme) list.get(i)).setPrice(str);
                }
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStoreMode() {
        StoreActivity storeActivity = this;
        this.showTabs = (new PreferencesManager(storeActivity).getCurrentUser() != null) && !MythicPlusManager.INSTANCE.isActive(storeActivity);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.storeTabLayout);
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.spotlightContainer);
        View viewFindViewById = findViewById(R.id.themesContainer);
        View viewFindViewById2 = findViewById(R.id.themesHeaderLayout);
        Intrinsics.checkNotNull(tabLayout);
        Intrinsics.checkNotNull(nestedScrollView);
        Intrinsics.checkNotNull(viewFindViewById);
        Intrinsics.checkNotNull(viewFindViewById2);
        setupTabs(tabLayout, nestedScrollView, viewFindViewById, viewFindViewById2);
        setupCategoryChips();
        setupSpotlight();
        setupThemesList();
    }

    private final Chip createCategoryChip(String label, String tag) {
        Chip chip = new Chip(this);
        chip.setText(label);
        chip.setTag(tag);
        chip.setCheckable(true);
        chip.setClickable(true);
        return chip;
    }

    private final void handlePurchase(Purchase purchase) {
        if (purchase.getPurchaseState() == 1) {
            Object obj = null;
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
                Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "build(...)");
                BillingClient billingClient = this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                billingClient.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda12
                    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                        Intrinsics.checkNotNullParameter(billingResult, "it");
                    }
                });
            }
            StoreActivity storeActivity = this;
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(storeActivity);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("theme_buy_store_success", null);
            if (this.currentSku.length() > 0) {
                PreferencesManager preferencesManager = new PreferencesManager(storeActivity);
                preferencesManager.addThemePurchased(this.currentSku);
                Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                mutableMap.put(this.currentSku, purchase.getPurchaseToken());
                preferencesManager.saveAllThemeTokens(mutableMap);
                preferencesManager.syncThemePurchase(this.currentSku);
                Iterator<T> it = this.allThemes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((MTTheme) next).getGoogleproductid(), this.currentSku)) {
                        obj = next;
                        break;
                    }
                }
                MTTheme mTTheme = (MTTheme) obj;
                if (mTTheme != null) {
                    preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                    Intent intent = new Intent(storeActivity, (Class<?>) DownloadThemeActivity.class);
                    intent.putExtra("theme", new Gson().toJson(mTTheme));
                    startActivity(intent);
                }
            }
        }
    }

    private final void launchPaywall() {
        FirebaseAnalytics.getInstance(this).logEvent("subscription_paywall_show", null);
        Purchases.INSTANCE.getSharedInstance().getOfferings(new ReceiveOfferingsCallback() { // from class: com.studiolaganne.lengendarylens.StoreActivity.launchPaywall.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (StoreActivity.this.isFinishing() || StoreActivity.this.isDestroyed()) {
                    return;
                }
                Toast.makeText(StoreActivity.this, R.string.error_paywall, 1).show();
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                Offering current = offerings.getCurrent();
                if (current != null) {
                    PaywallActivityLauncher.launch$default(StoreActivity.this.paywallActivityLauncher, current, null, false, false, MapsKt.mapOf(TuplesKt.to("carousel", new CustomVariableValue.String("default"))), 14, null);
                }
            }
        });
    }

    static final Unit onCreate$lambda$0(StoreActivity storeActivity) {
        storeActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(final StoreActivity storeActivity) {
        CustomCodeDialogFragment.Builder builder = new CustomCodeDialogFragment.Builder();
        String string = storeActivity.getString(R.string.enter_theme_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final CustomCodeDialogFragment customCodeDialogFragmentBuild = builder.setTitle(string).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StoreActivity.onCreate$lambda$1$0(this.f$0, (String) obj, (CustomCodeDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StoreActivity.onCreate$lambda$1$1((CustomCodeDialogFragment) obj);
            }
        }).setOutsideTouchCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StoreActivity.onCreate$lambda$1$2((CustomCodeDialogFragment) obj);
            }
        }).build();
        View view = customCodeDialogFragmentBuild.getView();
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.custom_life_edit_text) : null;
        customCodeDialogFragmentBuild.show(storeActivity.getSupportFragmentManager(), "customLifeDialog");
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return StoreActivity.onCreate$lambda$1$3(editText, storeActivity, customCodeDialogFragmentBuild, textView, i, keyEvent);
                }
            });
        }
        if (editText != null) {
            editText.requestFocus();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$0(final StoreActivity storeActivity, String str, CustomCodeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            dialog.dismiss();
            MTApiKt.getMtApi().getThemeByCode(str, new PreferencesManager(storeActivity).getDeviceLanguage()).enqueue(new Callback<MTSingleThemeResponse>() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onCreate$2$dialog$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSingleThemeResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    StoreActivity storeActivity2 = this.this$0;
                    Toast.makeText(storeActivity2, storeActivity2.getString(R.string.theme_not_found), 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSingleThemeResponse> call, Response<MTSingleThemeResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    MTSingleThemeResponse mTSingleThemeResponseBody = response.body();
                    MTTheme theme = mTSingleThemeResponseBody != null ? mTSingleThemeResponseBody.getTheme() : null;
                    StoreActivity storeActivity2 = this.this$0;
                    if (theme == null) {
                        Toast.makeText(storeActivity2, storeActivity2.getString(R.string.theme_not_found), 1).show();
                        return;
                    }
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(storeActivity2);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                    firebaseAnalytics.logEvent("theme_details_open", null);
                    new ThemeBottomSheetFragment(storeActivity2, theme, true).show(storeActivity2.getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$1(CustomCodeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$2(CustomCodeDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1$3(EditText editText, final StoreActivity storeActivity, CustomCodeDialogFragment customCodeDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String string = editText.getText().toString();
        if (string.length() <= 0) {
            return true;
        }
        MTApiKt.getMtApi().getThemeByCode(string, new PreferencesManager(storeActivity).getDeviceLanguage()).enqueue(new Callback<MTSingleThemeResponse>() { // from class: com.studiolaganne.lengendarylens.StoreActivity$onCreate$2$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSingleThemeResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                StoreActivity storeActivity2 = this.this$0;
                Toast.makeText(storeActivity2, storeActivity2.getString(R.string.theme_not_found), 1).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSingleThemeResponse> call, Response<MTSingleThemeResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                MTSingleThemeResponse mTSingleThemeResponseBody = response.body();
                MTTheme theme = mTSingleThemeResponseBody != null ? mTSingleThemeResponseBody.getTheme() : null;
                StoreActivity storeActivity2 = this.this$0;
                if (theme == null) {
                    Toast.makeText(storeActivity2, storeActivity2.getString(R.string.theme_not_found), 1).show();
                    return;
                }
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(storeActivity2);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("theme_details_open", null);
                new ThemeBottomSheetFragment(storeActivity2, theme, true).show(storeActivity2.getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
            }
        });
        customCodeDialogFragment.dismiss();
        return true;
    }

    static final Unit onThemeAlreadyBought$lambda$0(StoreActivity storeActivity, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(storeActivity, (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        storeActivity.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyBought$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyBought$lambda$2(StoreActivity storeActivity, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(storeActivity, (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        storeActivity.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyBought$lambda$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeUpdate$lambda$0(StoreActivity storeActivity, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(storeActivity, (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        storeActivity.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeUpdate$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void purchasesUpdatedListener$lambda$0(StoreActivity storeActivity, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (storeActivity.isDestroyed() || storeActivity.isFinishing()) {
            return;
        }
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                Intrinsics.checkNotNull(purchase);
                storeActivity.handlePurchase(purchase);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = storeActivity.getString(R.string.purchase_cancelled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = storeActivity.getString(R.string.purchase_cancelled_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = storeActivity.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StoreActivity.purchasesUpdatedListener$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = storeActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "purchase_cancelled");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = storeActivity.getString(R.string.purchase_impossible);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = storeActivity.getString(R.string.purchase_impossible_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = storeActivity.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StoreActivity.purchasesUpdatedListener$lambda$0$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager supportFragmentManager2 = storeActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        positiveButton2.show(supportFragmentManager2, "purchase_cancelled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupCategoryChips() {
        Object next;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.themeCategoriesScrollView);
        ChipGroup chipGroup = (ChipGroup) findViewById(R.id.themeCategoriesChipGroup);
        chipGroup.setOnCheckedStateChangeListener(null);
        chipGroup.removeAllViews();
        if (this.categoryNames.isEmpty()) {
            horizontalScrollView.setVisibility(8);
            this.selectedCategory = null;
            return;
        }
        horizontalScrollView.setVisibility(0);
        String string = getString(R.string.store_category_all);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Chip chipCreateCategoryChip = createCategoryChip(string, ALL_CATEGORY_ID);
        chipGroup.addView(chipCreateCategoryChip);
        for (String str : this.categoryNames) {
            chipGroup.addView(createCategoryChip(str, str));
        }
        String str2 = this.selectedCategory;
        IntRange intRangeUntil = RangesKt.until(0, chipGroup.getChildCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            View childAt = chipGroup.getChildAt(((IntIterator) it).nextInt());
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            arrayList.add((Chip) childAt);
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            Object tag = ((Chip) next).getTag();
            if (Intrinsics.areEqual(tag instanceof String ? (String) tag : null, str2)) {
                break;
            }
        }
        Chip chip = (Chip) next;
        if (chip != null) {
            chipCreateCategoryChip = chip;
        }
        chipCreateCategoryChip.setChecked(true);
        Object tag2 = chipCreateCategoryChip.getTag();
        String str3 = tag2 instanceof String ? (String) tag2 : null;
        this.selectedCategory = Intrinsics.areEqual(str3, ALL_CATEGORY_ID) ? null : str3;
        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
            public final void onCheckedChanged(ChipGroup chipGroup2, List list) {
                StoreActivity.setupCategoryChips$lambda$2(this.f$0, chipGroup2, list);
            }
        });
    }

    static final void setupCategoryChips$lambda$2(StoreActivity storeActivity, ChipGroup group, List checkedIds) {
        Chip chip;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(checkedIds, "checkedIds");
        Integer num = (Integer) CollectionsKt.firstOrNull(checkedIds);
        if (num == null || (chip = (Chip) group.findViewById(num.intValue())) == null) {
            return;
        }
        Object tag = chip.getTag();
        String str = tag instanceof String ? (String) tag : null;
        storeActivity.selectedCategory = Intrinsics.areEqual(str, ALL_CATEGORY_ID) ? null : str;
        storeActivity.setupThemesList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupSpotlight() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.spotlightRecyclerView);
        View viewFindViewById = findViewById(R.id.mythicPlusSpotlightLayout);
        View viewFindViewById2 = findViewById(R.id.mythicPlusSpotlightCtaLayout);
        final Function0 function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.setupSpotlight$lambda$0(this.f$0);
            }
        };
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.setupSpotlight$lambda$1(function0);
            }
        });
        Intrinsics.checkNotNull(viewFindViewById2);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.setupSpotlight$lambda$2(function0);
            }
        });
        recyclerView.setAdapter(new ThemeAdapter(CollectionsKt.toList(this.spotlightThemes), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    static final Unit setupSpotlight$lambda$0(StoreActivity storeActivity) {
        storeActivity.showPaywallInfoDialog();
        return Unit.INSTANCE;
    }

    static final Unit setupSpotlight$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit setupSpotlight$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void setupTabs(TabLayout tabLayout, final View spotlightContainer, final View themesContainer, final View themesHeaderLayout) {
        tabLayout.clearOnTabSelectedListeners();
        tabLayout.removeAllTabs();
        if (!this.showTabs) {
            tabLayout.setVisibility(8);
            spotlightContainer.setVisibility(8);
            themesContainer.setVisibility(0);
            themesHeaderLayout.setVisibility(0);
            return;
        }
        tabLayout.setVisibility(0);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.store_tab_spotlight)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.store_tab_themes)));
        spotlightContainer.setVisibility(0);
        themesContainer.setVisibility(8);
        themesHeaderLayout.setVisibility(8);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.studiolaganne.lengendarylens.StoreActivity.setupTabs.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab != null ? tab.getPosition() : 0;
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                FirebaseAnalytics.getInstance(StoreActivity.this).logEvent("store_tab_select", bundle);
                if (position == 0) {
                    spotlightContainer.setVisibility(0);
                    themesContainer.setVisibility(8);
                    themesHeaderLayout.setVisibility(8);
                } else {
                    if (position != 1) {
                        return;
                    }
                    spotlightContainer.setVisibility(8);
                    themesContainer.setVisibility(0);
                    themesHeaderLayout.setVisibility(0);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupThemesList() {
        ArrayList list;
        String str = this.selectedCategory;
        List<MTTheme> list2 = this.allThemes;
        if (str == null) {
            list = CollectionsKt.toList(list2);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                MTThemeCategory category = ((MTTheme) obj).getCategory();
                if (Intrinsics.areEqual(category != null ? category.getName() : null, this.selectedCategory)) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        ((TextView) findViewById(R.id.nothingToSeeLabel)).setVisibility(list.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.storeItemsRecyclerView);
        recyclerView.setAdapter(new ThemeAdapter(list, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private final void showPaywallInfoDialog() {
        MythicPlusInfoDialogFragment.Companion.show$default(MythicPlusInfoDialogFragment.INSTANCE, this, new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.showPaywallInfoDialog$lambda$0(this.f$0);
            }
        }, null, 4, null);
    }

    static final Unit showPaywallInfoDialog$lambda$0(StoreActivity storeActivity) {
        storeActivity.launchPaywall();
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.ThemeListClickListener
    public void onBuyTapped(MTTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        ProductDetails productDetails = this.themesProductDetails.get(theme.getGoogleproductid());
        BillingClient billingClient = null;
        if (productDetails == null) {
            Log.e("MTApi", "No details found for theme " + theme.getGoogleproductid());
            if (!StringsKt.startsWith$default(theme.getGoogleproductid(), "free_", false, 2, (Object) null)) {
                Toast.makeText(this, getString(R.string.purchase_not_ready), 1).show();
                return;
            }
            Intent intent = new Intent(this, (Class<?>) DownloadThemeActivity.class);
            intent.putExtra("theme", new Gson().toJson(theme));
            startActivity(intent);
            return;
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("theme_buy_store_start", null);
        this.currentSku = theme.getGoogleproductid();
        BillingFlowParams.ProductDetailsParams productDetailsParamsBuild = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build();
        Intrinsics.checkNotNullExpressionValue(productDetailsParamsBuild, "build(...)");
        BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(productDetailsParamsBuild)).build();
        Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "build(...)");
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        } else {
            billingClient = billingClient2;
        }
        Intrinsics.checkNotNull(billingClient.launchBillingFlow(this, billingFlowParamsBuild));
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.onCreate$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.codeLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StoreActivity.onCreate$lambda$1(this.f$0);
            }
        });
        BillingClient billingClientBuild = BillingClient.newBuilder(this).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClientBuild = null;
        }
        billingClientBuild.startConnection(new AnonymousClass3());
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PreferencesManager preferencesManager = new PreferencesManager(this);
        boolean z = preferencesManager.getBoolean(PreferencesManager.REFRESH_THEMES, false);
        if (this.allThemes.isEmpty() || z) {
            preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, false);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().getThemes(preferencesManager.getDeviceLanguage()).enqueue(new C12581(constraintLayout));
        }
    }

    @Override // com.studiolaganne.lengendarylens.ThemeListClickListener
    public void onThemeAlreadyBought(final MTTheme theme, boolean wasFree) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (wasFree) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.theme_already_obtained);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.theme_download_again);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StoreActivity.onThemeAlreadyBought$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StoreActivity.onThemeAlreadyBought$lambda$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            negativeButton.show(supportFragmentManager, "theme_re_download");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string5 = getString(R.string.theme_already_bought);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
        String string6 = getString(R.string.theme_download_again);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(string6).setPositiveButtonRed();
        String string7 = getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StoreActivity.onThemeAlreadyBought$lambda$2(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StoreActivity.onThemeAlreadyBought$lambda$3((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        negativeButton2.show(supportFragmentManager2, "theme_re_download");
    }

    @Override // com.studiolaganne.lengendarylens.ThemeCallback
    public void onThemeClose() {
    }

    @Override // com.studiolaganne.lengendarylens.ThemeListClickListener
    public void onThemeTapped(MTTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("theme_details_open", null);
        new ThemeBottomSheetFragment(this, theme, false, 4, null).show(getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
    }

    @Override // com.studiolaganne.lengendarylens.ThemeListClickListener
    public void onThemeUpdate(final MTTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.theme_update_available);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.theme_update_available_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StoreActivity.onThemeUpdate$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.StoreActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StoreActivity.onThemeUpdate$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "theme_update");
    }
}
