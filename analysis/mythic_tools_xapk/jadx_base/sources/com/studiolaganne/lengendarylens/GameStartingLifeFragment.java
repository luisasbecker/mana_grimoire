package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.CustomLifeDialogFragment;
import com.studiolaganne.lengendarylens.GameStartingLifeFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGameStartingLifeBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: GameStartingLifeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000267B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "<init>", "()V", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "prices", "", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themesProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "currentSku", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGameStartingLifeBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGameStartingLifeBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment$LifeSetupCallback;", "onDefaultTapped", "", "onThemeAlreadyPurchased", "theme", "wasFree", "", "onBuyTapped", "onThemeTapped", "onAttach", "context", "Landroid/content/Context;", "onResume", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "showThemeSelection", "hideThemeSelection", "updateThemeAdapter", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "updateSelectedThemeName", "LifeSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameStartingLifeFragment extends Fragment implements SelectThemeListClickListener {
    private FragmentGameStartingLifeBinding _binding;
    private BillingClient billingClient;
    private LifeSetupCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<MTTheme> themes = new ArrayList();
    private Map<String, String> prices = new LinkedHashMap();
    private Map<String, ProductDetails> themesProductDetails = new LinkedHashMap();
    private String currentSku = "";
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda1
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            GameStartingLifeFragment.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
        }
    };

    /* JADX INFO: compiled from: GameStartingLifeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameStartingLifeFragment newInstance() {
            return new GameStartingLifeFragment();
        }
    }

    /* JADX INFO: compiled from: GameStartingLifeFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameStartingLifeFragment$LifeSetupCallback;", "", "startingLifeSelected", "", "value", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface LifeSetupCallback {
        void startingLifeSelected(int value);
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameStartingLifeFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: GameStartingLifeFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/GameStartingLifeFragment$onCreateView$1", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements BillingClientStateListener {
        AnonymousClass1() {
        }

        static final void onBillingSetupFinished$lambda$1(final GameStartingLifeFragment gameStartingLifeFragment, BillingResult billingResult, QueryProductDetailsResult productDetailsResult) {
            String formattedPrice;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
            if (billingResult.getResponseCode() != 0 || gameStartingLifeFragment.getContext() == null) {
                return;
            }
            gameStartingLifeFragment.prices.clear();
            for (ProductDetails productDetails : productDetailsResult.getProductDetailsList()) {
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                if (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) {
                    formattedPrice = "";
                }
                gameStartingLifeFragment.prices.put(productId, formattedPrice);
                gameStartingLifeFragment.themesProductDetails.put(productId, productDetails);
            }
            Log.d("MTApi", "Prices received: " + gameStartingLifeFragment.prices);
            int i = 0;
            for (MTTheme mTTheme : gameStartingLifeFragment.themes) {
                int i2 = i + 1;
                for (Map.Entry entry : gameStartingLifeFragment.prices.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (Intrinsics.areEqual(mTTheme.getGoogleproductid(), str)) {
                        ((MTTheme) gameStartingLifeFragment.themes.get(i)).setPrice(str2);
                    }
                }
                i = i2;
            }
            Log.d("MTApi", "Prices received, themes are : " + gameStartingLifeFragment.themes);
            RecyclerView themesRecyclerView = gameStartingLifeFragment.getBinding().themesRecyclerView;
            Intrinsics.checkNotNullExpressionValue(themesRecyclerView, "themesRecyclerView");
            themesRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$onCreateView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GameStartingLifeFragment.AnonymousClass1.onBillingSetupFinished$lambda$1$0(gameStartingLifeFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBillingSetupFinished$lambda$1$0(GameStartingLifeFragment gameStartingLifeFragment) {
            if (gameStartingLifeFragment.getContext() == null) {
                return;
            }
            gameStartingLifeFragment.updateThemeAdapter();
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
                BillingClient billingClient = GameStartingLifeFragment.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                final GameStartingLifeFragment gameStartingLifeFragment = GameStartingLifeFragment.this;
                billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$onCreateView$1$$ExternalSyntheticLambda1
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult2, QueryProductDetailsResult queryProductDetailsResult) {
                        GameStartingLifeFragment.AnonymousClass1.onBillingSetupFinished$lambda$1(gameStartingLifeFragment, billingResult2, queryProductDetailsResult);
                    }
                });
            }
        }
    }

    private final void handlePurchase(Purchase purchase) {
        if (getContext() != null && purchase.getPurchaseState() == 1) {
            Object obj = null;
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
                Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "build(...)");
                BillingClient billingClient = this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                billingClient.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda28
                    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                        Intrinsics.checkNotNullParameter(billingResult, "it");
                    }
                });
            }
            if (this.currentSku.length() > 0) {
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                preferencesManager.addThemePurchased(this.currentSku);
                Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                mutableMap.put(this.currentSku, purchase.getPurchaseToken());
                preferencesManager.saveAllThemeTokens(mutableMap);
                preferencesManager.syncThemePurchase(this.currentSku);
                Iterator<T> it = this.themes.iterator();
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
                    Intent intent = new Intent(requireContext(), (Class<?>) DownloadThemeActivity.class);
                    intent.putExtra("theme", new Gson().toJson(mTTheme));
                    startActivity(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideThemeSelection() {
        getBinding().themeOverlay.setVisibility(8);
        getBinding().themePickerLayout.setVisibility(8);
    }

    @JvmStatic
    public static final GameStartingLifeFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$2(GameStartingLifeFragment gameStartingLifeFragment) {
        gameStartingLifeFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(GameStartingLifeFragment gameStartingLifeFragment) {
        gameStartingLifeFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameStartingLifeFragment gameStartingLifeFragment) {
        gameStartingLifeFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(final View view, final GameStartingLifeFragment gameStartingLifeFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GameStartingLifeFragment.onCreateView$lambda$6$0$0(view, gameStartingLifeFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0$0(View view, final GameStartingLifeFragment gameStartingLifeFragment) {
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                GameStartingLifeFragment.onCreateView$lambda$6$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0$0$0(GameStartingLifeFragment gameStartingLifeFragment) {
        LifeSetupCallback lifeSetupCallback = gameStartingLifeFragment.callback;
        if (lifeSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            lifeSetupCallback = null;
        }
        lifeSetupCallback.startingLifeSelected(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$0(View view, final GameStartingLifeFragment gameStartingLifeFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                GameStartingLifeFragment.onCreateView$lambda$7$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$0$0(GameStartingLifeFragment gameStartingLifeFragment) {
        LifeSetupCallback lifeSetupCallback = gameStartingLifeFragment.callback;
        if (lifeSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            lifeSetupCallback = null;
        }
        lifeSetupCallback.startingLifeSelected(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8$0(View view, final GameStartingLifeFragment gameStartingLifeFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                GameStartingLifeFragment.onCreateView$lambda$8$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8$0$0(GameStartingLifeFragment gameStartingLifeFragment) {
        LifeSetupCallback lifeSetupCallback = gameStartingLifeFragment.callback;
        if (lifeSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            lifeSetupCallback = null;
        }
        lifeSetupCallback.startingLifeSelected(40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$0(View view, final GameStartingLifeFragment gameStartingLifeFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                GameStartingLifeFragment.onCreateView$lambda$9$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$0$0(final GameStartingLifeFragment gameStartingLifeFragment) {
        CustomLifeDialogFragment.Builder builder = new CustomLifeDialogFragment.Builder();
        String string = gameStartingLifeFragment.getString(R.string.custom_life_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final CustomLifeDialogFragment customLifeDialogFragmentBuild = builder.setTitle(string).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameStartingLifeFragment.onCreateView$lambda$9$0$0$0(this.f$0, (Integer) obj, (CustomLifeDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameStartingLifeFragment.onCreateView$lambda$9$0$0$1((CustomLifeDialogFragment) obj);
            }
        }).setOutsideTouchCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameStartingLifeFragment.onCreateView$lambda$9$0$0$2((CustomLifeDialogFragment) obj);
            }
        }).build();
        View view = customLifeDialogFragmentBuild.getView();
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.custom_life_edit_text) : null;
        customLifeDialogFragmentBuild.show(gameStartingLifeFragment.getParentFragmentManager(), "customLifeDialog");
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda26
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return GameStartingLifeFragment.onCreateView$lambda$9$0$0$3(editText, gameStartingLifeFragment, customLifeDialogFragmentBuild, textView, i, keyEvent);
                }
            });
        }
        if (editText != null) {
            editText.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0$0$0(GameStartingLifeFragment gameStartingLifeFragment, Integer num, CustomLifeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (num != null) {
            LifeSetupCallback lifeSetupCallback = gameStartingLifeFragment.callback;
            if (lifeSetupCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                lifeSetupCallback = null;
            }
            lifeSetupCallback.startingLifeSelected(num.intValue());
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0$0$1(CustomLifeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0$0$2(CustomLifeDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$9$0$0$3(EditText editText, GameStartingLifeFragment gameStartingLifeFragment, CustomLifeDialogFragment customLifeDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Integer intOrNull = StringsKt.toIntOrNull(editText.getText().toString());
        if (intOrNull == null) {
            return true;
        }
        LifeSetupCallback lifeSetupCallback = gameStartingLifeFragment.callback;
        if (lifeSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            lifeSetupCallback = null;
        }
        lifeSetupCallback.startingLifeSelected(intOrNull.intValue());
        customLifeDialogFragment.dismiss();
        return true;
    }

    static final Unit onThemeAlreadyPurchased$lambda$0(GameStartingLifeFragment gameStartingLifeFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(gameStartingLifeFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gameStartingLifeFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$2(GameStartingLifeFragment gameStartingLifeFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(gameStartingLifeFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gameStartingLifeFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$0(GameStartingLifeFragment gameStartingLifeFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (gameStartingLifeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(gameStartingLifeFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gameStartingLifeFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void purchasesUpdatedListener$lambda$0(final GameStartingLifeFragment gameStartingLifeFragment, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (gameStartingLifeFragment.getContext() == null) {
            return;
        }
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                Intrinsics.checkNotNull(purchase);
                gameStartingLifeFragment.handlePurchase(purchase);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            if (gameStartingLifeFragment.getContext() == null) {
                return;
            }
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = gameStartingLifeFragment.getString(R.string.purchase_cancelled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = gameStartingLifeFragment.getString(R.string.purchase_cancelled_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = gameStartingLifeFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameStartingLifeFragment.purchasesUpdatedListener$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = gameStartingLifeFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "purchase_cancelled");
            return;
        }
        if (gameStartingLifeFragment.getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = gameStartingLifeFragment.getString(R.string.purchase_impossible);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = gameStartingLifeFragment.getString(R.string.purchase_impossible_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = gameStartingLifeFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameStartingLifeFragment.purchasesUpdatedListener$lambda$0$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager2 = gameStartingLifeFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        positiveButton2.show(childFragmentManager2, "purchase_cancelled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$0(GameStartingLifeFragment gameStartingLifeFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameStartingLifeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$1(GameStartingLifeFragment gameStartingLifeFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gameStartingLifeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showThemeSelection() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        getBinding().themeOverlay.setVisibility(0);
        getBinding().themePickerLayout.setVisibility(0);
    }

    private final void updateSelectedThemeName() {
        Object next;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String string = new PreferencesManager(contextRequireContext).getString(PreferencesManager.CREATOR_CODE, "");
        if (string.length() <= 0 || Intrinsics.areEqual(string, "default")) {
            getBinding().themeSelection.setText(getString(R.string.default_theme));
            return;
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        if (companion.getCurrentSkinDefinition(contextRequireContext2) != null) {
            Iterator<T> it = this.themes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((MTTheme) next).getGoogleproductid(), string)) {
                        break;
                    }
                }
            }
            MTTheme mTTheme = (MTTheme) next;
            if (mTTheme != null) {
                getBinding().themeSelection.setText(mTTheme.getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateThemeAdapter() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SelectThemeAdapter selectThemeAdapter = new SelectThemeAdapter(this.themes, new PreferencesManager(contextRequireContext).getString(PreferencesManager.CREATOR_CODE, ""), this);
        RecyclerView themesRecyclerView = getBinding().themesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(themesRecyclerView, "themesRecyclerView");
        themesRecyclerView.setAdapter(selectThemeAdapter);
        themesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        SelectThemeAdapter.INSTANCE.constrainRecyclerViewHeight(themesRecyclerView, selectThemeAdapter);
        updateSelectedThemeName();
    }

    public final FragmentGameStartingLifeBinding getBinding() {
        FragmentGameStartingLifeBinding fragmentGameStartingLifeBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGameStartingLifeBinding);
        return fragmentGameStartingLifeBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameStartingLifeFragment.LifeSetupCallback");
            this.callback = (LifeSetupCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.studiolaganne.lengendarylens.SelectThemeListClickListener
    public void onBuyTapped(MTTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (getContext() == null || getActivity() == null) {
            return;
        }
        ProductDetails productDetails = this.themesProductDetails.get(theme.getGoogleproductid());
        BillingClient billingClient = null;
        if (productDetails == null) {
            Log.e("MTApi", "No details found for theme " + theme.getGoogleproductid());
            if (!StringsKt.startsWith$default(theme.getGoogleproductid(), "free_", false, 2, (Object) null)) {
                Toast.makeText(requireContext(), getString(R.string.purchase_not_ready), 1).show();
                return;
            }
            Intent intent = new Intent(requireContext(), (Class<?>) DownloadThemeActivity.class);
            intent.putExtra("theme", new Gson().toJson(theme));
            startActivity(intent);
            return;
        }
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
        Intrinsics.checkNotNull(billingClient.launchBillingFlow(requireActivity(), billingFlowParamsBuild));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGameStartingLifeBinding.inflate(inflater, container, false);
        BillingClient billingClientBuild = BillingClient.newBuilder(requireContext()).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClientBuild = null;
        }
        billingClientBuild.startConnection(new AnonymousClass1());
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getCurrentUser() != null) {
            getBinding().themeButton.setVisibility(8);
            getBinding().themeOverlay.setVisibility(8);
            getBinding().themeTitle.setVisibility(8);
            getBinding().themeSelection.setVisibility(8);
        }
        ImageView themeButton = getBinding().themeButton;
        Intrinsics.checkNotNullExpressionValue(themeButton, "themeButton");
        ViewExtensionsKt.setOnClickWithFade(themeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameStartingLifeFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        TextView themeTitle = getBinding().themeTitle;
        Intrinsics.checkNotNullExpressionValue(themeTitle, "themeTitle");
        ViewExtensionsKt.setOnClickWithFade(themeTitle, new Function0() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameStartingLifeFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        TextView themeSelection = getBinding().themeSelection;
        Intrinsics.checkNotNullExpressionValue(themeSelection, "themeSelection");
        ViewExtensionsKt.setOnClickWithFade(themeSelection, new Function0() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameStartingLifeFragment.onCreateView$lambda$4(this.f$0);
            }
        });
        getBinding().themeOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hideThemeSelection();
            }
        });
        getBinding().cardView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameStartingLifeFragment.onCreateView$lambda$6$0(view, gameStartingLifeFragment);
                    }
                });
            }
        });
        getBinding().cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameStartingLifeFragment.onCreateView$lambda$7$0(view, gameStartingLifeFragment);
                    }
                });
            }
        });
        getBinding().cardView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda23
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameStartingLifeFragment.onCreateView$lambda$8$0(view, gameStartingLifeFragment);
                    }
                });
            }
        });
        getBinding().cardView4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameStartingLifeFragment.onCreateView$lambda$9$0(view, gameStartingLifeFragment);
                    }
                });
            }
        });
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.SelectThemeListClickListener
    public void onDefaultTapped() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setString(PreferencesManager.CREATOR_CODE, "default");
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        updateSelectedThemeName();
        updateThemeAdapter();
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hideThemeSelection();
                }
            }, 300L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getContext() == null) {
            return;
        }
        updateSelectedThemeName();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = preferencesManager.getBoolean(PreferencesManager.REFRESH_THEMES, false);
        if (this.themes.isEmpty() || z) {
            preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, false);
            MTApiKt.getMtApi().getThemes(preferencesManager.getDeviceLanguage()).enqueue(new Callback<MTThemesResponse>() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment.onResume.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTThemesResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTThemesResponse> call, Response<MTThemesResponse> response) throws IOException {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    if (responseBodyErrorBody != null) {
                        responseBodyErrorBody.string();
                    }
                    if (!response.isSuccessful() || GameStartingLifeFragment.this.getContext() == null) {
                        return;
                    }
                    MTThemesResponse mTThemesResponseBody = response.body();
                    List<MTTheme> themes = mTThemesResponseBody != null ? mTThemesResponseBody.getThemes() : null;
                    if (themes != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        GameStartingLifeFragment gameStartingLifeFragment = GameStartingLifeFragment.this;
                        ArrayList arrayList = new ArrayList();
                        for (MTTheme mTTheme : themes) {
                            Boolean instore = mTTheme.getInstore();
                            if (instore == null) {
                                arrayList.add(mTTheme);
                            } else if (instore.booleanValue()) {
                                arrayList.add(mTTheme);
                            } else if (preferencesManager2.getThemesPurchased().contains(mTTheme.getGoogleproductid())) {
                                arrayList.add(mTTheme);
                            }
                        }
                        for (MTTheme mTTheme2 : preferencesManager2.getLocalThemesCache()) {
                            ArrayList arrayList2 = arrayList;
                            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((MTTheme) it.next()).getGoogleproductid(), mTTheme2.getGoogleproductid())) {
                                        break;
                                    }
                                }
                            }
                            arrayList.add(mTTheme2);
                        }
                        gameStartingLifeFragment.themes = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$onResume$1$onResponse$lambda$0$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t).getGoogleproductid(), "free_", false, 2, (Object) null)), Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t2).getGoogleproductid(), "free_", false, 2, (Object) null)));
                            }
                        }));
                        for (Map.Entry entry : gameStartingLifeFragment.prices.entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            Iterator it2 = gameStartingLifeFragment.themes.iterator();
                            int i = 0;
                            while (it2.hasNext()) {
                                int i2 = i + 1;
                                if (Intrinsics.areEqual(((MTTheme) it2.next()).getGoogleproductid(), str)) {
                                    ((MTTheme) gameStartingLifeFragment.themes.get(i)).setPrice(str2);
                                }
                                i = i2;
                            }
                        }
                        Log.d("MTApi", "Themes received, themes are : " + gameStartingLifeFragment.themes);
                        gameStartingLifeFragment.updateThemeAdapter();
                    }
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.SelectThemeListClickListener
    public void onThemeAlreadyPurchased(final MTTheme theme, boolean wasFree) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (getContext() == null) {
            return;
        }
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
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameStartingLifeFragment.onThemeAlreadyPurchased$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameStartingLifeFragment.onThemeAlreadyPurchased$lambda$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "theme_re_download");
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
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameStartingLifeFragment.onThemeAlreadyPurchased$lambda$2(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameStartingLifeFragment.onThemeAlreadyPurchased$lambda$3((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        negativeButton2.show(childFragmentManager2, "theme_re_download");
    }

    @Override // com.studiolaganne.lengendarylens.SelectThemeListClickListener
    public void onThemeTapped(final MTTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!preferencesManager.getThemesPurchased().contains(theme.getGoogleproductid())) {
            onBuyTapped(theme);
            return;
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        if (companion.getSkinDefinition(contextRequireContext2, theme.getGoogleproductid()) != null) {
            preferencesManager.setString(PreferencesManager.CREATOR_CODE, theme.getGoogleproductid());
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
            updateSelectedThemeName();
            updateThemeAdapter();
            hideThemeSelection();
            preferencesManager.setString(PreferencesManager.CREATOR_CODE, theme.getGoogleproductid());
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
            updateSelectedThemeName();
            updateThemeAdapter();
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda32
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hideThemeSelection();
                    }
                }, 300L);
                return;
            }
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.theme_already_obtained_not_insalled);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.theme_download_again);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameStartingLifeFragment.onThemeTapped$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameStartingLifeFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameStartingLifeFragment.onThemeTapped$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_re_download");
    }
}
