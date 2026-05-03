package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.ThemeBottomSheetFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ThemeBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/ThemeBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "Lcom/studiolaganne/lengendarylens/ScreenshotClickListener;", "callback", "Lcom/studiolaganne/lengendarylens/ThemeCallback;", "theme", "Lcom/studiolaganne/lengendarylens/MTTheme;", "byCode", "", "<init>", "(Lcom/studiolaganne/lengendarylens/ThemeCallback;Lcom/studiolaganne/lengendarylens/MTTheme;Z)V", "buyEnabled", "isThemePurchased", "isThemeFree", "updateAvailable", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themeProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "onScreenshotClick", "", "url", "", "onStart", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updatePriceButton", "alreadyPurchased", "promptUpdate", "buyTheme", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThemeBottomSheetFragment extends TransparentBottomSheet implements ScreenshotClickListener {
    public static final String TAG = "ThemeBottomSheetFragment";
    private BillingClient billingClient;
    private boolean buyEnabled;
    private boolean byCode;
    private final ThemeCallback callback;
    private boolean isThemeFree;
    private boolean isThemePurchased;
    private final PurchasesUpdatedListener purchasesUpdatedListener;
    private MTTheme theme;
    private ProductDetails themeProductDetails;
    private boolean updateAvailable;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$onStart$2, reason: invalid class name */
    /* JADX INFO: compiled from: ThemeBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/ThemeBottomSheetFragment$onStart$2", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass2 implements BillingClientStateListener {
        AnonymousClass2() {
        }

        static final void onBillingSetupFinished$lambda$1(ThemeBottomSheetFragment themeBottomSheetFragment, BillingResult billingResult, QueryProductDetailsResult productDetailsResult) {
            String formattedPrice;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
            if (billingResult.getResponseCode() == 0) {
                for (ProductDetails productDetails : productDetailsResult.getProductDetailsList()) {
                    String productId = productDetails.getProductId();
                    Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) {
                        formattedPrice = "";
                    }
                    if (Intrinsics.areEqual(productId, themeBottomSheetFragment.theme.getGoogleproductid())) {
                        themeBottomSheetFragment.theme.setPrice(formattedPrice);
                        themeBottomSheetFragment.themeProductDetails = productDetails;
                        themeBottomSheetFragment.updatePriceButton();
                    }
                }
            }
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
                BillingClient billingClient = ThemeBottomSheetFragment.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                final ThemeBottomSheetFragment themeBottomSheetFragment = ThemeBottomSheetFragment.this;
                billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$onStart$2$$ExternalSyntheticLambda0
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult2, QueryProductDetailsResult queryProductDetailsResult) {
                        ThemeBottomSheetFragment.AnonymousClass2.onBillingSetupFinished$lambda$1(themeBottomSheetFragment, billingResult2, queryProductDetailsResult);
                    }
                });
            }
        }
    }

    public ThemeBottomSheetFragment(ThemeCallback callback, MTTheme theme, boolean z) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.callback = callback;
        this.theme = theme;
        this.byCode = z;
        this.purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda9
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                ThemeBottomSheetFragment.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
            }
        };
    }

    public /* synthetic */ ThemeBottomSheetFragment(ThemeCallback themeCallback, MTTheme mTTheme, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeCallback, mTTheme, (i & 4) != 0 ? false : z);
    }

    private final void alreadyPurchased() {
        if (getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.theme_already_bought);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.theme_download_again);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ThemeBottomSheetFragment.alreadyPurchased$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ThemeBottomSheetFragment.alreadyPurchased$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_re_download");
    }

    static final Unit alreadyPurchased$lambda$0(ThemeBottomSheetFragment themeBottomSheetFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(themeBottomSheetFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(themeBottomSheetFragment.theme));
        intent.putExtra("byCode", themeBottomSheetFragment.byCode);
        themeBottomSheetFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit alreadyPurchased$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void buyTheme() {
        if (getContext() == null || getActivity() == null) {
            return;
        }
        ProductDetails productDetails = this.themeProductDetails;
        if (productDetails != null) {
            BillingFlowParams.ProductDetailsParams productDetailsParamsBuild = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build();
            Intrinsics.checkNotNullExpressionValue(productDetailsParamsBuild, "build(...)");
            BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(productDetailsParamsBuild)).build();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "build(...)");
            BillingClient billingClient = this.billingClient;
            if (billingClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                billingClient = null;
            }
            if (billingClient.launchBillingFlow(requireActivity(), billingFlowParamsBuild) != null) {
                return;
            }
        }
        if (StringsKt.startsWith$default(this.theme.getGoogleproductid(), "free_", false, 2, (Object) null)) {
            Intent intent = new Intent(requireActivity(), (Class<?>) DownloadThemeActivity.class);
            intent.putExtra("theme", new Gson().toJson(this.theme));
            intent.putExtra("byCode", this.byCode);
            startActivity(intent);
        } else {
            Log.e("MTApi", "No details found for theme " + this.theme.getGoogleproductid());
            Toast.makeText(requireContext(), getString(R.string.purchase_not_ready), 1).show();
        }
        Unit unit = Unit.INSTANCE;
    }

    private final void handlePurchase(Purchase purchase) {
        if (getContext() != null && purchase.getPurchaseState() == 1) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
                Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "build(...)");
                BillingClient billingClient = this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                billingClient.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda10
                    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                        Intrinsics.checkNotNullParameter(billingResult, "it");
                    }
                });
            }
            if (this.theme.getGoogleproductid().length() > 0) {
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                preferencesManager.addThemePurchased(this.theme.getGoogleproductid());
                Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                mutableMap.put(this.theme.getGoogleproductid(), purchase.getPurchaseToken());
                preferencesManager.saveAllThemeTokens(mutableMap);
                preferencesManager.syncThemePurchase(this.theme.getGoogleproductid());
                preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                Intent intent = new Intent(requireContext(), (Class<?>) DownloadThemeActivity.class);
                intent.putExtra("theme", new Gson().toJson(this.theme));
                intent.putExtra("byCode", this.byCode);
                startActivity(intent);
            }
        }
    }

    static final Unit onViewCreated$lambda$0(ThemeBottomSheetFragment themeBottomSheetFragment) {
        ThemeCallback themeCallback = themeBottomSheetFragment.callback;
        if (themeCallback != null) {
            themeCallback.onThemeClose();
        }
        themeBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void promptUpdate() {
        if (getContext() == null || getActivity() == null) {
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
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ThemeBottomSheetFragment.promptUpdate$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ThemeBottomSheetFragment.promptUpdate$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_update");
    }

    static final Unit promptUpdate$lambda$0(ThemeBottomSheetFragment themeBottomSheetFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(themeBottomSheetFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(themeBottomSheetFragment.theme));
        intent.putExtra("byCode", themeBottomSheetFragment.byCode);
        themeBottomSheetFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit promptUpdate$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void purchasesUpdatedListener$lambda$0(ThemeBottomSheetFragment themeBottomSheetFragment, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (themeBottomSheetFragment.getContext() == null) {
            return;
        }
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                Intrinsics.checkNotNull(purchase);
                themeBottomSheetFragment.handlePurchase(purchase);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = themeBottomSheetFragment.getString(R.string.purchase_cancelled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = themeBottomSheetFragment.getString(R.string.purchase_cancelled_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = themeBottomSheetFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeBottomSheetFragment.purchasesUpdatedListener$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = themeBottomSheetFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "purchase_cancelled");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = themeBottomSheetFragment.getString(R.string.purchase_impossible);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = themeBottomSheetFragment.getString(R.string.purchase_impossible_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = themeBottomSheetFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ThemeBottomSheetFragment.purchasesUpdatedListener$lambda$0$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager2 = themeBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        positiveButton2.show(childFragmentManager2, "purchase_cancelled");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePriceButton() {
        int iIntValue;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.isThemePurchased = preferencesManager.getThemesPurchased().contains(this.theme.getGoogleproductid());
        this.isThemeFree = StringsKt.startsWith$default(this.theme.getGoogleproductid(), "free_", false, 2, (Object) null);
        this.updateAvailable = false;
        if (this.isThemePurchased) {
            Map<String, Integer> allThemeVersions = preferencesManager.getAllThemeVersions();
            if (allThemeVersions.containsKey(this.theme.getGoogleproductid())) {
                Integer num = allThemeVersions.get(this.theme.getGoogleproductid());
                Intrinsics.checkNotNull(num);
                iIntValue = num.intValue();
            } else {
                iIntValue = 1000;
            }
            if (iIntValue < this.theme.getVersion()) {
                this.updateAvailable = true;
            }
        }
        View view = getView();
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.buyButtonLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.buyButtonLayoutBottom);
            TextView textView = (TextView) view.findViewById(R.id.buyButtonTextBottom);
            TextView textView2 = (TextView) view.findViewById(R.id.priceText);
            Intrinsics.checkNotNull(constraintLayout2);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ThemeBottomSheetFragment.updatePriceButton$lambda$0$0(this.f$0);
                }
            });
            Intrinsics.checkNotNull(constraintLayout);
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ThemeBottomSheetFragment.updatePriceButton$lambda$0$1(this.f$0);
                }
            });
            if (this.updateAvailable) {
                constraintLayout.setBackgroundResource(R.drawable.custom_button_background_blue);
                constraintLayout2.setBackgroundResource(R.drawable.custom_button_background_blue);
                textView2.setText(requireContext().getString(R.string.update));
                textView.setText(requireContext().getString(R.string.update));
                return;
            }
            boolean z = this.isThemeFree;
            boolean z2 = this.isThemePurchased;
            if (z) {
                if (z2) {
                    constraintLayout.setBackgroundResource(R.drawable.custom_button_background_grey);
                    constraintLayout2.setBackgroundResource(R.drawable.custom_button_background_grey);
                    textView2.setText(requireContext().getString(R.string.obtained));
                    textView.setText(requireContext().getString(R.string.obtained));
                    return;
                }
                constraintLayout.setBackgroundResource(R.drawable.custom_button_background);
                constraintLayout2.setBackgroundResource(R.drawable.custom_button_background);
                textView2.setText(requireContext().getString(R.string.obtain));
                textView.setText(requireContext().getString(R.string.obtain));
                return;
            }
            if (z2) {
                constraintLayout.setBackgroundResource(R.drawable.custom_button_background_grey);
                constraintLayout2.setBackgroundResource(R.drawable.custom_button_background_grey);
                textView2.setText(requireContext().getString(R.string.purchased));
                textView.setText(requireContext().getString(R.string.purchased));
                return;
            }
            String price = this.theme.getPrice();
            if (price == null) {
                this.buyEnabled = false;
                textView2.setText("--,-");
                constraintLayout2.setBackgroundResource(R.drawable.custom_button_background_grey);
                textView2.setText("--,-");
                textView.setText(requireContext().getResources().getString(R.string.not_available));
                return;
            }
            String str = price;
            if (str.length() <= 0) {
                this.buyEnabled = false;
                constraintLayout2.setBackgroundResource(R.drawable.custom_button_background_grey);
                textView2.setText("--,-");
                textView.setText(requireContext().getResources().getString(R.string.not_available));
                return;
            }
            this.buyEnabled = true;
            constraintLayout2.setBackgroundResource(R.drawable.custom_button_background);
            textView2.setText(str);
            String string = requireContext().getResources().getString(R.string.buy_now_for);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", price, false, 4, (Object) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updatePriceButton$lambda$0$0(ThemeBottomSheetFragment themeBottomSheetFragment) {
        if (themeBottomSheetFragment.updateAvailable) {
            themeBottomSheetFragment.promptUpdate();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.isThemeFree) {
            if (themeBottomSheetFragment.isThemePurchased) {
                themeBottomSheetFragment.alreadyPurchased();
                return Unit.INSTANCE;
            }
            themeBottomSheetFragment.buyTheme();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.isThemePurchased) {
            themeBottomSheetFragment.alreadyPurchased();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.buyEnabled) {
            themeBottomSheetFragment.buyTheme();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Toast.makeText(themeBottomSheetFragment.requireContext(), themeBottomSheetFragment.getString(R.string.purchase_not_ready), 1).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updatePriceButton$lambda$0$1(ThemeBottomSheetFragment themeBottomSheetFragment) {
        if (themeBottomSheetFragment.updateAvailable) {
            themeBottomSheetFragment.promptUpdate();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.isThemeFree) {
            if (themeBottomSheetFragment.isThemePurchased) {
                themeBottomSheetFragment.alreadyPurchased();
                return Unit.INSTANCE;
            }
            themeBottomSheetFragment.buyTheme();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.isThemePurchased) {
            themeBottomSheetFragment.alreadyPurchased();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.buyEnabled) {
            themeBottomSheetFragment.buyTheme();
            return Unit.INSTANCE;
        }
        if (themeBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Toast.makeText(themeBottomSheetFragment.requireContext(), themeBottomSheetFragment.getString(R.string.purchase_not_ready), 1).show();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_theme, container, false);
    }

    @Override // com.studiolaganne.lengendarylens.TransparentBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updatePriceButton();
    }

    @Override // com.studiolaganne.lengendarylens.ScreenshotClickListener
    public void onScreenshotClick(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Log.d("MTApi", "Clicked on screenshot " + url);
        Intent intent = new Intent(requireContext(), (Class<?>) ScreenshotActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        BillingClient billingClient = null;
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null) {
            return;
        }
        View viewFindViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setPeekHeight(-1);
        }
        BillingClient billingClientBuild = BillingClient.newBuilder(requireContext()).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        } else {
            billingClient = billingClientBuild;
        }
        billingClient.startConnection(new AnonymousClass2());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.ThemeBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ThemeBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        ((TextView) view.findViewById(R.id.catchphraseTextView)).setText(this.theme.getCatchphrase());
        ((TextView) view.findViewById(R.id.themeDescription)).setText(this.theme.getDescription());
        ((TextView) view.findViewById(R.id.themeContents)).setText(this.theme.getContents());
        ((TextView) view.findViewById(R.id.priceText)).setText("--,-");
        CachedImageView cachedImageView = (CachedImageView) view.findViewById(R.id.themeImage);
        cachedImageView.clearBackground();
        String bannerurl = this.theme.getBannerurl();
        if (bannerurl != null) {
            cachedImageView.reset();
            cachedImageView.loadImage(bannerurl);
        }
        List<String> screenshots = this.theme.getScreenshots();
        if (screenshots != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.themeScreenshotsRecyclerView);
            recyclerView.setAdapter(new ScreenshotAdapter(screenshots, this));
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        }
        updatePriceButton();
    }
}
