package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
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
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.ChoosePlaygroupDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.NewGameFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentNewGameBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: NewGameFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002BCB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010'H\u0016J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u001bH\u0002J\u001a\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010'H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewGameFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "<init>", "()V", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "prices", "", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themesProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "currentSku", "instanceStateSaved", "", "favortiesExpanded", "callback", "Lcom/studiolaganne/lengendarylens/NewGameFragment$NewGameCallback;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentNewGameBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentNewGameBinding;", "onDefaultTapped", "", "onThemeAlreadyPurchased", "theme", "wasFree", "onBuyTapped", "onThemeTapped", "updateTournamentUI", "onAttach", "context", "Landroid/content/Context;", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onResume", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "showThemeSelection", "hideThemeSelection", "updateThemeAdapter", "setupFavoriteButton", FirebaseAnalytics.Param.INDEX, "", "setup", "Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "updateFavoriteSetups", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "updateSelectedThemeName", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "NewGameCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewGameFragment extends Fragment implements SelectThemeListClickListener {
    private FragmentNewGameBinding _binding;
    private BillingClient billingClient;
    private NewGameCallback callback;
    private boolean favortiesExpanded;
    private boolean instanceStateSaved;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<MTTheme> themes = new ArrayList();
    private Map<String, String> prices = new LinkedHashMap();
    private Map<String, ProductDetails> themesProductDetails = new LinkedHashMap();
    private String currentSku = "";
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda23
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            NewGameFragment.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
        }
    };

    /* JADX INFO: compiled from: NewGameFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewGameFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/NewGameFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NewGameFragment newInstance() {
            NewGameFragment newGameFragment = new NewGameFragment();
            newGameFragment.setArguments(new Bundle());
            return newGameFragment;
        }
    }

    /* JADX INFO: compiled from: NewGameFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewGameFragment$NewGameCallback;", "", "newGameFromScratch", "", "newGameFromPlaygroup", "id", "", "newGameFromFavorite", "setup", "Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "newQuickGame", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface NewGameCallback {
        void newGameFromFavorite(MTFavoriteSetup setup);

        void newGameFromPlaygroup(int id);

        void newGameFromScratch();

        void newQuickGame();
    }

    /* JADX INFO: compiled from: NewGameFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.CONSTRUCTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.DRAFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.SEALED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.NewGameFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NewGameFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/NewGameFragment$onViewCreated$1", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12231 implements BillingClientStateListener {
        C12231() {
        }

        static final void onBillingSetupFinished$lambda$1(final NewGameFragment newGameFragment, BillingResult billingResult, QueryProductDetailsResult productDetailsResult) {
            String formattedPrice;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
            if (billingResult.getResponseCode() != 0 || newGameFragment.getContext() == null) {
                return;
            }
            newGameFragment.prices.clear();
            for (ProductDetails productDetails : productDetailsResult.getProductDetailsList()) {
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                if (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) {
                    formattedPrice = "";
                }
                newGameFragment.prices.put(productId, formattedPrice);
                newGameFragment.themesProductDetails.put(productId, productDetails);
            }
            Log.d("MTApi", "Prices received: " + newGameFragment.prices);
            int i = 0;
            for (MTTheme mTTheme : newGameFragment.themes) {
                int i2 = i + 1;
                for (Map.Entry entry : newGameFragment.prices.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (Intrinsics.areEqual(mTTheme.getGoogleproductid(), str)) {
                        ((MTTheme) newGameFragment.themes.get(i)).setPrice(str2);
                    }
                }
                i = i2;
            }
            Log.d("MTApi", "Prices received, themes are : " + newGameFragment.themes);
            RecyclerView themesRecyclerView = newGameFragment.getBinding().themesRecyclerView;
            Intrinsics.checkNotNullExpressionValue(themesRecyclerView, "themesRecyclerView");
            themesRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$onViewCreated$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewGameFragment.C12231.onBillingSetupFinished$lambda$1$0(newGameFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBillingSetupFinished$lambda$1$0(NewGameFragment newGameFragment) {
            if (newGameFragment.getContext() == null) {
                return;
            }
            newGameFragment.updateThemeAdapter();
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
                BillingClient billingClient = NewGameFragment.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                final NewGameFragment newGameFragment = NewGameFragment.this;
                billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$onViewCreated$1$$ExternalSyntheticLambda1
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult2, QueryProductDetailsResult queryProductDetailsResult) {
                        NewGameFragment.C12231.onBillingSetupFinished$lambda$1(newGameFragment, billingResult2, queryProductDetailsResult);
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
                billingClient.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda16
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
    public static final NewGameFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$0(NewGameFragment newGameFragment) {
        if (newGameFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        newGameFragment.startActivity(new Intent(newGameFragment.requireContext(), (Class<?>) EventsActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(final NewGameFragment newGameFragment) {
        TextView newGameHeader = newGameFragment.getBinding().newGameHeader;
        Intrinsics.checkNotNullExpressionValue(newGameHeader, "newGameHeader");
        ConstraintLayout newGameLayout = newGameFragment.getBinding().newGameLayout;
        Intrinsics.checkNotNullExpressionValue(newGameLayout, "newGameLayout");
        TextView eventsText = newGameFragment.getBinding().eventsText;
        Intrinsics.checkNotNullExpressionValue(eventsText, "eventsText");
        ConstraintLayout eventLayout = newGameFragment.getBinding().eventLayout;
        Intrinsics.checkNotNullExpressionValue(eventLayout, "eventLayout");
        NewGameFragmentKt.fadeOutTogether(CollectionsKt.listOf((Object[]) new View[]{newGameHeader, newGameLayout, eventsText, eventLayout}), 200L, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$1$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$0(NewGameFragment newGameFragment) {
        LinearLayout backLinearLayout = newGameFragment.getBinding().backLinearLayout;
        Intrinsics.checkNotNullExpressionValue(backLinearLayout, "backLinearLayout");
        NewGameFragmentKt.fadeInAndSlideDown$default(backLinearLayout, 0L, 0L, 3, null);
        TextView questionText = newGameFragment.getBinding().questionText;
        Intrinsics.checkNotNullExpressionValue(questionText, "questionText");
        NewGameFragmentKt.fadeInAndSlideDown$default(questionText, 0L, 25L, 1, null);
        ConstraintLayout fromPlaygroupLayout = newGameFragment.getBinding().fromPlaygroupLayout;
        Intrinsics.checkNotNullExpressionValue(fromPlaygroupLayout, "fromPlaygroupLayout");
        NewGameFragmentKt.fadeInAndSlideDown$default(fromPlaygroupLayout, 0L, 50L, 1, null);
        ConstraintLayout withGuestsLayout = newGameFragment.getBinding().withGuestsLayout;
        Intrinsics.checkNotNullExpressionValue(withGuestsLayout, "withGuestsLayout");
        NewGameFragmentKt.fadeInAndSlideDown$default(withGuestsLayout, 0L, 75L, 1, null);
        newGameFragment.getBinding().favSetupLayout.setVisibility(8);
        newGameFragment.getBinding().favSetupLayout.setAlpha(1.0f);
        newGameFragment.updateFavoriteSetups();
        ConstraintLayout favSetupLayout = newGameFragment.getBinding().favSetupLayout;
        Intrinsics.checkNotNullExpressionValue(favSetupLayout, "favSetupLayout");
        if (favSetupLayout.getVisibility() == 0) {
            ConstraintLayout favSetupLayout2 = newGameFragment.getBinding().favSetupLayout;
            Intrinsics.checkNotNullExpressionValue(favSetupLayout2, "favSetupLayout");
            NewGameFragmentKt.fadeInAndSlideDown$default(favSetupLayout2, 0L, 200L, 1, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(final NewGameFragment newGameFragment) {
        LinearLayout backLinearLayout = newGameFragment.getBinding().backLinearLayout;
        Intrinsics.checkNotNullExpressionValue(backLinearLayout, "backLinearLayout");
        TextView questionText = newGameFragment.getBinding().questionText;
        Intrinsics.checkNotNullExpressionValue(questionText, "questionText");
        ConstraintLayout fromPlaygroupLayout = newGameFragment.getBinding().fromPlaygroupLayout;
        Intrinsics.checkNotNullExpressionValue(fromPlaygroupLayout, "fromPlaygroupLayout");
        ConstraintLayout withGuestsLayout = newGameFragment.getBinding().withGuestsLayout;
        Intrinsics.checkNotNullExpressionValue(withGuestsLayout, "withGuestsLayout");
        List listMutableListOf = CollectionsKt.mutableListOf(backLinearLayout, questionText, fromPlaygroupLayout, withGuestsLayout);
        ConstraintLayout favSetupLayout = newGameFragment.getBinding().favSetupLayout;
        Intrinsics.checkNotNullExpressionValue(favSetupLayout, "favSetupLayout");
        if (favSetupLayout.getVisibility() == 0) {
            ConstraintLayout favSetupLayout2 = newGameFragment.getBinding().favSetupLayout;
            Intrinsics.checkNotNullExpressionValue(favSetupLayout2, "favSetupLayout");
            listMutableListOf.add(favSetupLayout2);
        }
        newGameFragment.getBinding().favSetupLayout1.setVisibility(8);
        newGameFragment.getBinding().favSetupLayout2.setVisibility(8);
        newGameFragment.getBinding().favSetupLayout3.setVisibility(8);
        NewGameFragmentKt.fadeOutTogether(listMutableListOf, 200L, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$2$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(NewGameFragment newGameFragment) {
        TextView newGameHeader = newGameFragment.getBinding().newGameHeader;
        Intrinsics.checkNotNullExpressionValue(newGameHeader, "newGameHeader");
        NewGameFragmentKt.fadeInAndSlideDown$default(newGameHeader, 0L, 0L, 3, null);
        ConstraintLayout newGameLayout = newGameFragment.getBinding().newGameLayout;
        Intrinsics.checkNotNullExpressionValue(newGameLayout, "newGameLayout");
        NewGameFragmentKt.fadeInAndSlideDown$default(newGameLayout, 0L, 25L, 1, null);
        TextView eventsText = newGameFragment.getBinding().eventsText;
        Intrinsics.checkNotNullExpressionValue(eventsText, "eventsText");
        NewGameFragmentKt.fadeInAndSlideDown$default(eventsText, 0L, 50L, 1, null);
        ConstraintLayout eventLayout = newGameFragment.getBinding().eventLayout;
        Intrinsics.checkNotNullExpressionValue(eventLayout, "eventLayout");
        NewGameFragmentKt.fadeInAndSlideDown$default(eventLayout, 0L, 75L, 1, null);
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$3(NewGameFragment newGameFragment, View view) {
        newGameFragment.favortiesExpanded = !newGameFragment.favortiesExpanded;
        newGameFragment.updateFavoriteSetups();
    }

    static final Unit onCreateView$lambda$4(NewGameFragment newGameFragment) {
        NewGameCallback newGameCallback = newGameFragment.callback;
        if (newGameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newGameCallback = null;
        }
        newGameCallback.newGameFromScratch();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(NewGameFragment newGameFragment) {
        newGameFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(NewGameFragment newGameFragment) {
        newGameFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(NewGameFragment newGameFragment) {
        newGameFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$9(final NewGameFragment newGameFragment) {
        if (newGameFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = newGameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (!new PreferencesManager(contextRequireContext).getCurrentUserPlaygroups().isEmpty()) {
            new ChoosePlaygroupDialogFragment.Builder().setPlaygroupCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NewGameFragment.onCreateView$lambda$9$1(this.f$0, ((Integer) obj).intValue(), (ChoosePlaygroupDialogFragment) obj2);
                }
            }).build().show(newGameFragment.requireActivity().getSupportFragmentManager(), "ChoosePlaygroupDialogFragment");
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = newGameFragment.getString(R.string.no_playgroup_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = newGameFragment.getString(R.string.no_playgroup_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = newGameFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NewGameFragment.onCreateView$lambda$9$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = newGameFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0(boolean z, CustomDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$1(NewGameFragment newGameFragment, int i, ChoosePlaygroupDialogFragment dialogFragment) {
        Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
        NewGameCallback newGameCallback = newGameFragment.callback;
        if (newGameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newGameCallback = null;
        }
        newGameCallback.newGameFromPlaygroup(i);
        dialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$0(NewGameFragment newGameFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(newGameFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        newGameFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$2(NewGameFragment newGameFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(newGameFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        newGameFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$0(NewGameFragment newGameFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (newGameFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(newGameFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        newGameFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void purchasesUpdatedListener$lambda$0(final NewGameFragment newGameFragment, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (newGameFragment.getContext() == null || newGameFragment.getActivity() == null || newGameFragment.isDetached() || newGameFragment.instanceStateSaved) {
            return;
        }
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                Intrinsics.checkNotNull(purchase);
                newGameFragment.handlePurchase(purchase);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = newGameFragment.getString(R.string.purchase_cancelled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = newGameFragment.getString(R.string.purchase_cancelled_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = newGameFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NewGameFragment.purchasesUpdatedListener$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = newGameFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "purchase_cancelled");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = newGameFragment.getString(R.string.purchase_impossible);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = newGameFragment.getString(R.string.purchase_impossible_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = newGameFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NewGameFragment.purchasesUpdatedListener$lambda$0$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager2 = newGameFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        positiveButton2.show(childFragmentManager2, "purchase_cancelled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$0(NewGameFragment newGameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (newGameFragment.getContext() == null || newGameFragment.getActivity() == null || newGameFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$1(NewGameFragment newGameFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (newGameFragment.getContext() == null || newGameFragment.getActivity() == null || newGameFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupFavoriteButton(int index, MTFavoriteSetup setup) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ConstraintLayout constraintLayout;
        CachedImageView cachedImageView;
        ImageView imageView;
        NonInteractiveRecyclerView nonInteractiveRecyclerView;
        String name;
        String str;
        int i;
        Unit unit;
        int iIntValue;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (index == 0) {
            textView = getBinding().setupName1;
            textView2 = getBinding().playgroupName1;
            textView3 = getBinding().setupSummary1;
            constraintLayout = getBinding().profileLayout1;
            cachedImageView = getBinding().profileImage1;
            imageView = getBinding().defaultProfileImage1;
            nonInteractiveRecyclerView = getBinding().usersRecyclerView1;
        } else if (index == 1) {
            textView = getBinding().setupName2;
            textView2 = getBinding().playgroupName2;
            textView3 = getBinding().setupSummary2;
            constraintLayout = getBinding().profileLayout2;
            cachedImageView = getBinding().profileImage2;
            imageView = getBinding().defaultProfileImage2;
            nonInteractiveRecyclerView = getBinding().usersRecyclerView2;
        } else if (index != 2) {
            textView = null;
            textView2 = null;
            textView3 = null;
            constraintLayout = null;
            cachedImageView = null;
            imageView = null;
            nonInteractiveRecyclerView = null;
        } else {
            textView = getBinding().setupName3;
            textView2 = getBinding().playgroupName3;
            textView3 = getBinding().setupSummary3;
            constraintLayout = getBinding().profileLayout3;
            cachedImageView = getBinding().profileImage3;
            imageView = getBinding().defaultProfileImage3;
            nonInteractiveRecyclerView = getBinding().usersRecyclerView3;
        }
        MTGameSubformat subformat = setup.getSubformat();
        if (subformat != null) {
            name = subformat.getName();
        } else {
            MTGameFormat format = setup.getFormat();
            name = format != null ? format.getName() : "";
        }
        Integer bestOf = setup.getBestOf();
        if (bestOf != null && (iIntValue = bestOf.intValue()) > 1) {
            name = ((Object) name) + " - Bo" + iIntValue;
        }
        if (textView != null) {
            textView.setText(name);
        }
        MTGamePlaygroup playgroup = setup.getPlaygroup();
        if (playgroup == null) {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setText("@ " + playgroup.getName());
            }
            if (cachedImageView != null) {
                cachedImageView.setOutlineProvider(new CircularOutlineProvider());
            }
            if (cachedImageView != null) {
                cachedImageView.setClipToOutline(true);
            }
            String picture = playgroup.getPicture();
            String str2 = picture;
            if (str2 == null || str2.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                if (cachedImageView != null) {
                    cachedImageView.setVisibility(4);
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                }
            } else {
                if (cachedImageView != null) {
                    cachedImageView.setVisibility(0);
                }
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                if (cachedImageView != null) {
                    cachedImageView.reset();
                }
                if (cachedImageView != null) {
                    cachedImageView.setAutoLoad(false);
                }
                if (cachedImageView != null) {
                    cachedImageView.loadImage(picture);
                    unit = Unit.INSTANCE;
                }
                if (unit != null) {
                }
            }
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        List<MTFavoritePlayer> players = setup.getPlayers();
        List<MTFavoritePlayer> list = players;
        boolean z = list instanceof Collection;
        if (z && list.isEmpty()) {
            str = "";
        } else {
            for (MTFavoritePlayer mTFavoritePlayer : list) {
                if (Intrinsics.areEqual(mTFavoritePlayer != null ? Integer.valueOf(mTFavoritePlayer.getId()) : null, currentUser != null ? Integer.valueOf(currentUser.getId()) : null)) {
                    str = "" + getString(R.string.you_capitalized);
                    break;
                }
            }
            str = "";
        }
        for (MTFavoritePlayer mTFavoritePlayer2 : players) {
            if (mTFavoritePlayer2 != null) {
                if (currentUser == null || mTFavoritePlayer2.getId() != currentUser.getId()) {
                    if (str.length() > 0) {
                        str = ((Object) str) + ", ";
                    }
                    str = ((Object) str) + mTFavoritePlayer2.getFirstname();
                }
            }
        }
        if (z && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((MTFavoritePlayer) it.next()) == null && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i > 0) {
            if (str.length() > 0) {
                str = ((Object) str) + ", ";
            }
            str = i == 1 ? ((Object) str) + "& " + i + " " + getString(R.string.and_guest) : ((Object) str) + "& " + i + " " + getString(R.string.and_guests);
        }
        if (textView3 != null) {
            textView3.setText(str);
        }
        if (nonInteractiveRecyclerView != null) {
            ArrayList arrayList = new ArrayList();
            for (MTFavoritePlayer mTFavoritePlayer3 : players) {
                if (mTFavoritePlayer3 != null) {
                    int id = mTFavoritePlayer3.getId();
                    String firstname = mTFavoritePlayer3.getFirstname();
                    String username = mTFavoritePlayer3.getUsername();
                    String picture2 = mTFavoritePlayer3.getPicture();
                    arrayList.add(new MTGamePlayer(id, firstname, username, picture2 == null ? "" : picture2, null, 0, null, null, null, null, PointerIconCompat.TYPE_TEXT, null));
                }
            }
            nonInteractiveRecyclerView.setAdapter(new SmallGamePlayerAdapter(arrayList, false, 0));
            nonInteractiveRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(18, contextRequireContext2));
            int itemDecorationCount = nonInteractiveRecyclerView.getItemDecorationCount();
            for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                nonInteractiveRecyclerView.removeItemDecorationAt(0);
            }
            nonInteractiveRecyclerView.addItemDecoration(overlapDecoration);
            nonInteractiveRecyclerView.setVisibility(!arrayList.isEmpty() ? 0 : 8);
        }
    }

    private final void showThemeSelection() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        getBinding().themeOverlay.setVisibility(0);
        getBinding().themePickerLayout.setVisibility(0);
    }

    private final void updateFavoriteSetups() {
        List<MTFavoriteSetup> setups;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTFavorites currentUserFavorites = new PreferencesManager(contextRequireContext).getCurrentUserFavorites();
        if (currentUserFavorites != null && (setups = currentUserFavorites.getSetups()) != null) {
            List<MTFavoriteSetup> list = setups;
            if (!list.isEmpty()) {
                getBinding().favSetupLayout.setVisibility(0);
                getBinding().favoriteSetupsText.setVisibility(0);
                getBinding().favoriteSetupsTextSubtitle.setVisibility(0);
                if (!this.favortiesExpanded) {
                    getBinding().expandSetupIcon.setImageResource(R.drawable.chevron_down);
                    getBinding().favSetupLayout1.setVisibility(8);
                    getBinding().favSetupLayout2.setVisibility(8);
                    getBinding().favSetupLayout3.setVisibility(8);
                    return;
                }
                getBinding().expandSetupIcon.setImageResource(R.drawable.chevron_up);
                final MTFavoriteSetup mTFavoriteSetup = setups.get(0);
                getBinding().favSetupLayout1.setVisibility(0);
                setupFavoriteButton(0, mTFavoriteSetup);
                ConstraintLayout favSetupLayout1 = getBinding().favSetupLayout1;
                Intrinsics.checkNotNullExpressionValue(favSetupLayout1, "favSetupLayout1");
                ViewExtensionsKt.setOnClickWithFade(favSetupLayout1, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NewGameFragment.updateFavoriteSetups$lambda$0$0$0(this.f$0, mTFavoriteSetup);
                    }
                });
                if (list.size() >= 2) {
                    final MTFavoriteSetup mTFavoriteSetup2 = setups.get(1);
                    getBinding().favSetupLayout2.setVisibility(0);
                    setupFavoriteButton(1, mTFavoriteSetup2);
                    ConstraintLayout favSetupLayout2 = getBinding().favSetupLayout2;
                    Intrinsics.checkNotNullExpressionValue(favSetupLayout2, "favSetupLayout2");
                    ViewExtensionsKt.setOnClickWithFade(favSetupLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NewGameFragment.updateFavoriteSetups$lambda$0$0$1(this.f$0, mTFavoriteSetup2);
                        }
                    });
                }
                if (list.size() >= 3) {
                    final MTFavoriteSetup mTFavoriteSetup3 = setups.get(2);
                    getBinding().favSetupLayout3.setVisibility(0);
                    setupFavoriteButton(2, mTFavoriteSetup3);
                    ConstraintLayout favSetupLayout3 = getBinding().favSetupLayout3;
                    Intrinsics.checkNotNullExpressionValue(favSetupLayout3, "favSetupLayout3");
                    ViewExtensionsKt.setOnClickWithFade(favSetupLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NewGameFragment.updateFavoriteSetups$lambda$0$0$2(this.f$0, mTFavoriteSetup3);
                        }
                    });
                    return;
                }
                return;
            }
        }
        getBinding().favSetupLayout.setVisibility(8);
        getBinding().favoriteSetupsText.setVisibility(8);
        getBinding().favoriteSetupsTextSubtitle.setVisibility(8);
        getBinding().favSetupLayout1.setVisibility(8);
        getBinding().favSetupLayout2.setVisibility(8);
        getBinding().favSetupLayout3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFavoriteSetups$lambda$0$0$0(NewGameFragment newGameFragment, MTFavoriteSetup mTFavoriteSetup) {
        NewGameCallback newGameCallback = newGameFragment.callback;
        if (newGameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newGameCallback = null;
        }
        newGameCallback.newGameFromFavorite(mTFavoriteSetup);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFavoriteSetups$lambda$0$0$1(NewGameFragment newGameFragment, MTFavoriteSetup mTFavoriteSetup) {
        NewGameCallback newGameCallback = newGameFragment.callback;
        if (newGameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newGameCallback = null;
        }
        newGameCallback.newGameFromFavorite(mTFavoriteSetup);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFavoriteSetups$lambda$0$0$2(NewGameFragment newGameFragment, MTFavoriteSetup mTFavoriteSetup) {
        NewGameCallback newGameCallback = newGameFragment.callback;
        if (newGameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newGameCallback = null;
        }
        newGameCallback.newGameFromFavorite(mTFavoriteSetup);
        return Unit.INSTANCE;
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
        if (companion.getCurrentSkinDefinition(contextRequireContext2) == null) {
            getBinding().themeSelection.setText(getString(R.string.default_theme));
            return;
        }
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
        } else {
            getBinding().themeSelection.setText(getString(R.string.default_theme));
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

    private final void updateTournamentUI() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament == null || currentTournament.getPlayers().isEmpty()) {
            getBinding().eventsText.setText(getResources().getString(R.string.event_header));
            getBinding().eventText.setText(getResources().getString(R.string.create_event_text));
            getBinding().eventSubtitleText.setText(getResources().getString(R.string.create_event_subtitle));
            getBinding().eventLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_event_button_background));
            return;
        }
        getBinding().eventsText.setText(getResources().getString(R.string.event_in_progress));
        int i = WhenMappings.$EnumSwitchMapping$0[currentTournament.getEventType().ordinal()];
        if (i == 1) {
            getBinding().eventText.setText(getResources().getString(R.string.constructed_progress));
        } else if (i == 2) {
            getBinding().eventText.setText(getResources().getString(R.string.draft_progress));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            getBinding().eventText.setText(getResources().getString(R.string.sealed_progress));
        }
        TextView textView = getBinding().eventSubtitleText;
        String string = getResources().getString(R.string.events_players_count);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(currentTournament.getPlayers().size()), false, 4, (Object) null));
        getBinding().eventLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_event_button_background_active));
    }

    public final FragmentNewGameBinding getBinding() {
        FragmentNewGameBinding fragmentNewGameBinding = this._binding;
        Intrinsics.checkNotNull(fragmentNewGameBinding);
        return fragmentNewGameBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.NewGameFragment.NewGameCallback");
            this.callback = (NewGameCallback) parentFragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentNewGameBinding.inflate(inflater, container, false);
        ConstraintLayout eventLayout = getBinding().eventLayout;
        Intrinsics.checkNotNullExpressionValue(eventLayout, "eventLayout");
        ViewExtensionsKt.setOnClickWithFade(eventLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        ConstraintLayout newGameLayout = getBinding().newGameLayout;
        Intrinsics.checkNotNullExpressionValue(newGameLayout, "newGameLayout");
        ViewExtensionsKt.setOnClickWithFade(newGameLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        LinearLayout backLinearLayout = getBinding().backLinearLayout;
        Intrinsics.checkNotNullExpressionValue(backLinearLayout, "backLinearLayout");
        ViewExtensionsKt.setOnClickWithFade(backLinearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        getBinding().favSetupLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewGameFragment.onCreateView$lambda$3(this.f$0, view);
            }
        });
        ConstraintLayout withGuestsLayout = getBinding().withGuestsLayout;
        Intrinsics.checkNotNullExpressionValue(withGuestsLayout, "withGuestsLayout");
        ViewExtensionsKt.setOnClickWithFade(withGuestsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$4(this.f$0);
            }
        });
        ImageView themeButton = getBinding().themeButton;
        Intrinsics.checkNotNullExpressionValue(themeButton, "themeButton");
        ViewExtensionsKt.setOnClickWithFade(themeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$5(this.f$0);
            }
        });
        TextView themeTitle = getBinding().themeTitle;
        Intrinsics.checkNotNullExpressionValue(themeTitle, "themeTitle");
        ViewExtensionsKt.setOnClickWithFade(themeTitle, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        TextView themeSelection = getBinding().themeSelection;
        Intrinsics.checkNotNullExpressionValue(themeSelection, "themeSelection");
        ViewExtensionsKt.setOnClickWithFade(themeSelection, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        getBinding().themeOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hideThemeSelection();
            }
        });
        ConstraintLayout fromPlaygroupLayout = getBinding().fromPlaygroupLayout;
        Intrinsics.checkNotNullExpressionValue(fromPlaygroupLayout, "fromPlaygroupLayout");
        ViewExtensionsKt.setOnClickWithFade(fromPlaygroupLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewGameFragment.onCreateView$lambda$9(this.f$0);
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
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hideThemeSelection();
                }
            }, 300L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.instanceStateSaved = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.instanceStateSaved = false;
        if (getContext() == null) {
            return;
        }
        updateTournamentUI();
        updateSelectedThemeName();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = preferencesManager.getBoolean(PreferencesManager.REFRESH_THEMES, false);
        if (this.themes.isEmpty() || z) {
            preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, false);
            MTApiKt.getMtApi().getThemes(preferencesManager.getDeviceLanguage()).enqueue(new Callback<MTThemesResponse>() { // from class: com.studiolaganne.lengendarylens.NewGameFragment.onResume.1
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
                    if (!response.isSuccessful() || NewGameFragment.this.getContext() == null) {
                        return;
                    }
                    MTThemesResponse mTThemesResponseBody = response.body();
                    List<MTTheme> themes = mTThemesResponseBody != null ? mTThemesResponseBody.getThemes() : null;
                    if (themes != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        NewGameFragment newGameFragment = NewGameFragment.this;
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
                        newGameFragment.themes = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$onResume$1$onResponse$lambda$0$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t).getGoogleproductid(), "free_", false, 2, (Object) null)), Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t2).getGoogleproductid(), "free_", false, 2, (Object) null)));
                            }
                        }));
                        for (Map.Entry entry : newGameFragment.prices.entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            Iterator it2 = newGameFragment.themes.iterator();
                            int i = 0;
                            while (it2.hasNext()) {
                                int i2 = i + 1;
                                if (Intrinsics.areEqual(((MTTheme) it2.next()).getGoogleproductid(), str)) {
                                    ((MTTheme) newGameFragment.themes.get(i)).setPrice(str2);
                                }
                                i = i2;
                            }
                        }
                        Log.d("MTApi", "Themes received, themes are : " + newGameFragment.themes);
                        newGameFragment.updateThemeAdapter();
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.instanceStateSaved = true;
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
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NewGameFragment.onThemeAlreadyPurchased$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NewGameFragment.onThemeAlreadyPurchased$lambda$1((CustomDialogFragment) obj);
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
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NewGameFragment.onThemeAlreadyPurchased$lambda$2(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NewGameFragment.onThemeAlreadyPurchased$lambda$3((CustomDialogFragment) obj);
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
            Log.d("MTApi", "Theme not owned, trying to buy");
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
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hideThemeSelection();
                    }
                }, 300L);
                return;
            }
            return;
        }
        Log.d("MTApi", "Theme not installed, trying to download");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.theme_already_obtained_not_insalled);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.theme_download_again);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NewGameFragment.onThemeTapped$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.NewGameFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NewGameFragment.onThemeTapped$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_re_download");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BillingClient billingClientBuild = BillingClient.newBuilder(requireContext()).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClientBuild = null;
        }
        billingClientBuild.startConnection(new C12231());
    }
}
