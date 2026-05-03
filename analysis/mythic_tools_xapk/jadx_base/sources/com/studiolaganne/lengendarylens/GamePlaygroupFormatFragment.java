package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
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
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment;
import com.studiolaganne.lengendarylens.RichTextDialogFragment;
import com.studiolaganne.lengendarylens.TimerTimeDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGamePlaygroupFormatBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: GamePlaygroupFormatFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020&H\u0016J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0018\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0016J\b\u0010?\u001a\u00020&H\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020&H\u0002J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020\u0018H\u0002J\b\u0010J\u001a\u00020&H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "<init>", "()V", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "prices", "", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themesProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "currentSku", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "formats", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "format", "top6Formats", "", "filteredFormatsPopupMenu", "Landroid/widget/PopupMenu;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlaygroupFormatBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlaygroupFormatBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment$PlaygroupFormatSetupCallback;", "onDefaultTapped", "", "onThemeAlreadyPurchased", "theme", "wasFree", "", "onBuyTapped", "onThemeTapped", "onAttach", "context", "Landroid/content/Context;", "onResume", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupFormatButton", FirebaseAnalytics.Param.INDEX, "formatId", "updateFilteredMenu", "onDestroyView", "showThemeSelection", "hideThemeSelection", "updateThemeAdapter", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "updateSelectedThemeName", "selectFormat", "f", "updateSubmitButtonState", "PlaygroupFormatSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GamePlaygroupFormatFragment extends Fragment implements SelectThemeListClickListener {
    private FragmentGamePlaygroupFormatBinding _binding;
    private BillingClient billingClient;
    private PlaygroupFormatSetupCallback callback;
    private PopupMenu filteredFormatsPopupMenu;
    private MTFormat format;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<MTTheme> themes = new ArrayList();
    private Map<String, String> prices = new LinkedHashMap();
    private Map<String, ProductDetails> themesProductDetails = new LinkedHashMap();
    private String currentSku = "";
    private List<MTFormat> formats = CollectionsKt.emptyList();
    private List<Integer> top6Formats = new ArrayList();
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda39
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            GamePlaygroupFormatFragment.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
        }
    };

    /* JADX INFO: compiled from: GamePlaygroupFormatFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GamePlaygroupFormatFragment newInstance() {
            return new GamePlaygroupFormatFragment();
        }
    }

    /* JADX INFO: compiled from: GamePlaygroupFormatFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupFormatFragment$PlaygroupFormatSetupCallback;", "", "formatSelected", "", "formatId", "", "subformatId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface PlaygroupFormatSetupCallback {
        void formatSelected(int formatId, int subformatId);
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: GamePlaygroupFormatFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/studiolaganne/lengendarylens/GamePlaygroupFormatFragment$onCreateView$1", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements BillingClientStateListener {
        AnonymousClass1() {
        }

        static final void onBillingSetupFinished$lambda$1(final GamePlaygroupFormatFragment gamePlaygroupFormatFragment, BillingResult billingResult, QueryProductDetailsResult productDetailsResult) {
            String formattedPrice;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
            if (billingResult.getResponseCode() != 0 || gamePlaygroupFormatFragment.getContext() == null) {
                return;
            }
            gamePlaygroupFormatFragment.prices.clear();
            for (ProductDetails productDetails : productDetailsResult.getProductDetailsList()) {
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                if (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) {
                    formattedPrice = "";
                }
                gamePlaygroupFormatFragment.prices.put(productId, formattedPrice);
                gamePlaygroupFormatFragment.themesProductDetails.put(productId, productDetails);
            }
            Log.d("MTApi", "Prices received: " + gamePlaygroupFormatFragment.prices);
            int i = 0;
            for (MTTheme mTTheme : gamePlaygroupFormatFragment.themes) {
                int i2 = i + 1;
                for (Map.Entry entry : gamePlaygroupFormatFragment.prices.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (Intrinsics.areEqual(mTTheme.getGoogleproductid(), str)) {
                        ((MTTheme) gamePlaygroupFormatFragment.themes.get(i)).setPrice(str2);
                    }
                }
                i = i2;
            }
            Log.d("MTApi", "Prices received, themes are : " + gamePlaygroupFormatFragment.themes);
            RecyclerView themesRecyclerView = gamePlaygroupFormatFragment.getBinding().themesRecyclerView;
            Intrinsics.checkNotNullExpressionValue(themesRecyclerView, "themesRecyclerView");
            themesRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$onCreateView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GamePlaygroupFormatFragment.AnonymousClass1.onBillingSetupFinished$lambda$1$0(gamePlaygroupFormatFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBillingSetupFinished$lambda$1$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
            if (gamePlaygroupFormatFragment.getContext() == null) {
                return;
            }
            gamePlaygroupFormatFragment.updateThemeAdapter();
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
                BillingClient billingClient = GamePlaygroupFormatFragment.this.billingClient;
                if (billingClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    billingClient = null;
                }
                final GamePlaygroupFormatFragment gamePlaygroupFormatFragment = GamePlaygroupFormatFragment.this;
                billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$onCreateView$1$$ExternalSyntheticLambda1
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult2, QueryProductDetailsResult queryProductDetailsResult) {
                        GamePlaygroupFormatFragment.AnonymousClass1.onBillingSetupFinished$lambda$1(gamePlaygroupFormatFragment, billingResult2, queryProductDetailsResult);
                    }
                });
            }
        }
    }

    public GamePlaygroupFormatFragment() {
        final GamePlaygroupFormatFragment gamePlaygroupFormatFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gamePlaygroupFormatFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gamePlaygroupFormatFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gamePlaygroupFormatFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gamePlaygroupFormatFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
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
                billingClient.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda40
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
    public static final GamePlaygroupFormatFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        gamePlaygroupFormatFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        gamePlaygroupFormatFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$10(final GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() != null && gamePlaygroupFormatFragment.getBinding().timerSwitch.isChecked()) {
            new TimerTimeDialogFragment.Builder().setMinutes(gamePlaygroupFormatFragment.getSharedViewModel().getGameState().getTimerTotalTime()).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$10$0(this.f$0, ((Integer) obj).intValue(), (TimerTimeDialogFragment) obj2);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$10$1((TimerTimeDialogFragment) obj);
                }
            }).build().show(gamePlaygroupFormatFragment.getParentFragmentManager(), "timer_time_dialog");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$10$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, int i, TimerTimeDialogFragment dialog) {
        String str;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTimerTotalTime(i);
        Context contextRequireContext = gamePlaygroupFormatFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
        TextView textView = gamePlaygroupFormatFragment.getBinding().timerTimeTextView;
        int i2 = i / 60;
        if (i2 > 0) {
            int i3 = i % 60;
            str = i3 == 0 ? i2 + "h" : i2 + "h " + i3 + "min";
        } else {
            str = (i % 60) + "min";
        }
        textView.setText(str);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$10$1(TimerTimeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$11(final GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        CustomLifeDialogFragment.Builder builder = new CustomLifeDialogFragment.Builder();
        String string = gamePlaygroupFormatFragment.getString(R.string.custom_life_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final CustomLifeDialogFragment customLifeDialogFragmentBuild = builder.setTitle(string).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GamePlaygroupFormatFragment.onCreateView$lambda$11$0(this.f$0, (Integer) obj, (CustomLifeDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GamePlaygroupFormatFragment.onCreateView$lambda$11$1((CustomLifeDialogFragment) obj);
            }
        }).setOutsideTouchCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GamePlaygroupFormatFragment.onCreateView$lambda$11$2((CustomLifeDialogFragment) obj);
            }
        }).build();
        View view = customLifeDialogFragmentBuild.getView();
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.custom_life_edit_text) : null;
        customLifeDialogFragmentBuild.show(gamePlaygroupFormatFragment.getParentFragmentManager(), "customLifeDialog");
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda6
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$11$3(editText, gamePlaygroupFormatFragment, customLifeDialogFragmentBuild, textView, i, keyEvent);
                }
            });
        }
        if (editText != null) {
            editText.requestFocus();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$11$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, Integer num, CustomLifeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (num != null) {
            gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(num);
            TextView textView = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
            String string = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{0}", String.valueOf(num.intValue()), false, 4, (Object) null));
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$11$1(CustomLifeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$11$2(CustomLifeDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$11$3(EditText editText, GamePlaygroupFormatFragment gamePlaygroupFormatFragment, CustomLifeDialogFragment customLifeDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Integer intOrNull = StringsKt.toIntOrNull(editText.getText().toString());
        if (intOrNull == null) {
            return true;
        }
        gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(intOrNull);
        TextView textView2 = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
        String string = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView2.setText(StringsKt.replace$default(string, "{0}", String.valueOf(intOrNull.intValue()), false, 4, (Object) null));
        customLifeDialogFragment.dismiss();
        return true;
    }

    static final Unit onCreateView$lambda$12(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        PopupMenu popupMenu = gamePlaygroupFormatFragment.filteredFormatsPopupMenu;
        if (popupMenu != null) {
            popupMenu.show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$13(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        MTFormat mTFormat = gamePlaygroupFormatFragment.format;
        if (mTFormat != null) {
            gamePlaygroupFormatFragment.getSharedViewModel().getFormatId().setValue(Integer.valueOf(mTFormat.getId()));
            Integer value = gamePlaygroupFormatFragment.getSharedViewModel().getSubFormatId().getValue();
            int iIntValue = value != null ? value.intValue() : -1;
            if (mTFormat.getPlayersmin() == 2 && mTFormat.getPlayersmax() == 2) {
                if (Intrinsics.areEqual(gamePlaygroupFormatFragment.getBinding().bestOfTextView.getText(), gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo1))) {
                    Context contextRequireContext = gamePlaygroupFormatFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    new PreferencesManager(contextRequireContext).clearCurrentSet();
                } else if (Intrinsics.areEqual(gamePlaygroupFormatFragment.getBinding().bestOfTextView.getText(), gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo3))) {
                    GameSet gameSet = new GameSet(null, 0, null, 7, null);
                    gameSet.setBestOf(3);
                    Context contextRequireContext2 = gamePlaygroupFormatFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    new PreferencesManager(contextRequireContext2).saveCurrentSet(gameSet);
                } else if (Intrinsics.areEqual(gamePlaygroupFormatFragment.getBinding().bestOfTextView.getText(), gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo5))) {
                    GameSet gameSet2 = new GameSet(null, 0, null, 7, null);
                    gameSet2.setBestOf(5);
                    Context contextRequireContext3 = gamePlaygroupFormatFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                    new PreferencesManager(contextRequireContext3).saveCurrentSet(gameSet2);
                }
            }
            PlaygroupFormatSetupCallback playgroupFormatSetupCallback = gamePlaygroupFormatFragment.callback;
            if (playgroupFormatSetupCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                playgroupFormatSetupCallback = null;
            }
            playgroupFormatSetupCallback.formatSelected(mTFormat.getId(), iIntValue);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$14(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 0) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(0).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$15(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 1) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(1).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$16(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 2) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(2).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$17(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 3) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(3).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$18(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 4) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(4).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$19(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        Object next;
        if (gamePlaygroupFormatFragment.top6Formats.size() > 5) {
            int iIntValue = gamePlaygroupFormatFragment.top6Formats.get(5).intValue();
            Iterator<T> it = gamePlaygroupFormatFragment.formats.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MTFormat) next).getId() == iIntValue) {
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                gamePlaygroupFormatFragment.selectFormat(mTFormat);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        gamePlaygroupFormatFragment.showThemeSelection();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$20(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = gamePlaygroupFormatFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        gamePlaygroupFormatFragment.getBinding().selectedFormatLayout.setVisibility(8);
        gamePlaygroupFormatFragment.getBinding().rootFormatsLayout.setVisibility(0);
        gamePlaygroupFormatFragment.getBinding().formatLayout.setVisibility(0);
        gamePlaygroupFormatFragment.getBinding().selectFormatText.setVisibility(0);
        gamePlaygroupFormatFragment.format = null;
        preferencesManager.clearCurrentSet();
        gamePlaygroupFormatFragment.getBinding().lifeTotalLayout.setVisibility(8);
        gamePlaygroupFormatFragment.getBinding().subformatLayout.setVisibility(8);
        gamePlaygroupFormatFragment.getBinding().duelOptionsLayout.setVisibility(8);
        gamePlaygroupFormatFragment.getBinding().turnTimerLayout.setVisibility(8);
        gamePlaygroupFormatFragment.getBinding().streamingLayout.setVisibility(8);
        gamePlaygroupFormatFragment.updateSubmitButtonState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4$1$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, Integer num) {
        gamePlaygroupFormatFragment.getBinding().usersCount.setText(String.valueOf(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4$1$2(MTPlaygroup mTPlaygroup, GamePlaygroupFormatFragment gamePlaygroupFormatFragment, List list) {
        Object next;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Iterator<T> it2 = mTPlaygroup.getUsers().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (((MTUser) next).getId() == iIntValue) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                MTUser mTUser = (MTUser) next;
                if (mTUser != null) {
                    arrayList.add(mTUser);
                }
            }
            gamePlaygroupFormatFragment.getBinding().playgroupUsersRecyclerView.setAdapter(new SmallUsersAdapter(arrayList, false, 0));
            gamePlaygroupFormatFragment.getBinding().playgroupUsersRecyclerView.setLayoutManager(new LinearLayoutManager(gamePlaygroupFormatFragment.requireContext(), 0, false));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = gamePlaygroupFormatFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(12, contextRequireContext));
            int itemDecorationCount = gamePlaygroupFormatFragment.getBinding().playgroupUsersRecyclerView.getItemDecorationCount();
            for (int i = 0; i < itemDecorationCount; i++) {
                gamePlaygroupFormatFragment.getBinding().playgroupUsersRecyclerView.removeItemDecorationAt(0);
            }
            gamePlaygroupFormatFragment.getBinding().playgroupUsersRecyclerView.addItemDecoration(overlapDecoration);
        }
    }

    static final Unit onCreateView$lambda$7(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        if (gamePlaygroupFormatFragment.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gamePlaygroupFormatFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("turn_timer_off", null);
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTurnTimerEnabled(false);
            gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setText(gamePlaygroupFormatFragment.getString(R.string.disabled));
            gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.action_blue));
        } else {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(gamePlaygroupFormatFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("turn_timer_on", null);
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTurnTimerEnabled(true);
            gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setText(gamePlaygroupFormatFragment.getString(R.string.enabled));
            gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.winner_green));
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        String string = gamePlaygroupFormatFragment.getString(R.string.streaming_help_body);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, "https://mythic.tools/", 0, false, 6, (Object) null);
        int length = "https://mythic.tools/".length() + iIndexOf$default;
        RichTextDialogFragment.Builder builder = new RichTextDialogFragment.Builder();
        String string2 = gamePlaygroupFormatFragment.getString(R.string.streaming_help_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        RichTextDialogFragment.Builder builderAddLink = builder.setTitle(string2).setBody(string).addLink("https://mythic.tools/", iIndexOf$default, length);
        String string3 = gamePlaygroupFormatFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        RichTextDialogFragment.Builder positiveButton = builderAddLink.setPositiveButton(string3, new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GamePlaygroupFormatFragment.onCreateView$lambda$8$0((RichTextDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = gamePlaygroupFormatFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "streaming_help");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$8$0(RichTextDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$9(GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = gamePlaygroupFormatFragment.getString(R.string.turn_timer_help_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = gamePlaygroupFormatFragment.getString(R.string.turn_timer_help_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = gamePlaygroupFormatFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GamePlaygroupFormatFragment.onCreateView$lambda$9$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = gamePlaygroupFormatFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "turn_timer_help");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(gamePlaygroupFormatFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gamePlaygroupFormatFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$2(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(gamePlaygroupFormatFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gamePlaygroupFormatFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeAlreadyPurchased$lambda$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(gamePlaygroupFormatFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        gamePlaygroupFormatFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onThemeTapped$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void purchasesUpdatedListener$lambda$0(final GamePlaygroupFormatFragment gamePlaygroupFormatFragment, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return;
        }
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                Intrinsics.checkNotNull(purchase);
                gamePlaygroupFormatFragment.handlePurchase(purchase);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            if (gamePlaygroupFormatFragment.getContext() == null) {
                return;
            }
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = gamePlaygroupFormatFragment.getString(R.string.purchase_cancelled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = gamePlaygroupFormatFragment.getString(R.string.purchase_cancelled_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = gamePlaygroupFormatFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GamePlaygroupFormatFragment.purchasesUpdatedListener$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = gamePlaygroupFormatFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "purchase_cancelled");
            return;
        }
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = gamePlaygroupFormatFragment.getString(R.string.purchase_impossible);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = gamePlaygroupFormatFragment.getString(R.string.purchase_impossible_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = gamePlaygroupFormatFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GamePlaygroupFormatFragment.purchasesUpdatedListener$lambda$0$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager2 = gamePlaygroupFormatFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        positiveButton2.show(childFragmentManager2, "purchase_cancelled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchasesUpdatedListener$lambda$0$1(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (gamePlaygroupFormatFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void selectFormat(final MTFormat f) {
        int iIntValue;
        String str;
        if (getContext() == null) {
            return;
        }
        getBinding().nextButtonLayout.setVisibility(0);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        getBinding().rootFormatsLayout.setVisibility(8);
        getBinding().formatLayout.setVisibility(8);
        getBinding().selectedFormatLayout.setVisibility(0);
        String color = f.getColor();
        if (color != null && color.length() > 0 && !Intrinsics.areEqual(color, AbstractJsonLexerKt.NULL)) {
            int color2 = Color.parseColor(color);
            Drawable background = getBinding().selectedFormatButton.getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(color2);
            }
        }
        getBinding().selectFormatText.setVisibility(8);
        TextView textView = getBinding().selectedFormatName;
        String upperCase = f.getName().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        getBinding().selectedFormatImage.reset();
        getBinding().selectedFormatImage.setAutoLoad(false);
        CachedImageView cachedImageView = getBinding().selectedFormatImage;
        String icon = f.getIcon();
        if (icon == null) {
            icon = "";
        }
        cachedImageView.loadImage(icon);
        this.format = f;
        getSharedViewModel().getFormatId().setValue(Integer.valueOf(f.getId()));
        getBinding().lifeTotalLayout.setVisibility(0);
        TextView textView2 = getBinding().lifeTotalTextView;
        String string = getResources().getString(R.string.starting_life_total_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView2.setText(StringsKt.replace$default(string, "{0}", String.valueOf(f.getLifetotal()), false, 4, (Object) null));
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        final List<MTSubformat> mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext2).getSubformats(f.getId()));
        Integer value = getSharedViewModel().getPlaygroupId().getValue();
        if (value == null || value.intValue() != -1) {
            List<Integer> value2 = getSharedViewModel().getPlaygroupUsers().getValue();
            int size = value2 != null ? value2.size() : 0;
            if (size > 0) {
                ArrayList arrayList = new ArrayList();
                for (MTSubformat mTSubformat : mutableList) {
                    Integer playersmin = mTSubformat.getPlayersmin();
                    boolean z = playersmin != null && (iIntValue = playersmin.intValue()) > 0 && size < iIntValue;
                    Integer playersmax = mTSubformat.getPlayersmax();
                    if (playersmax != null) {
                        int iIntValue2 = playersmax.intValue();
                        if (1 <= iIntValue2 && iIntValue2 < size) {
                            z = true;
                        }
                    }
                    if (!z) {
                        arrayList.add(mTSubformat);
                    }
                }
                mutableList.clear();
                mutableList.addAll(arrayList);
            }
        }
        if (mutableList.isEmpty()) {
            getSharedViewModel().getSubFormatId().setValue(-1);
            getBinding().subformatLayout.setVisibility(8);
            getBinding().subformatTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
            getBinding().subformatTextView.setText(getString(R.string.select_a_subformat));
        } else {
            getBinding().subformatLayout.setVisibility(0);
            final PopupMenu popupMenu = new PopupMenu(requireContext(), getBinding().subformatLayout);
            Menu menu = popupMenu.getMenu();
            menu.add(0, -1, 0, getString(R.string.filter_no_variant));
            for (MTSubformat mTSubformat2 : mutableList) {
                String name = mTSubformat2.getName();
                if (mTSubformat2.getId() == 5) {
                    name = getResources().getString(R.string.two_headed_giant);
                    Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                }
                if (mTSubformat2.getId() == 6) {
                    name = getResources().getString(R.string.three_headed_giant);
                    Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                }
                menu.add(0, mTSubformat2.getId(), 0, name);
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda41
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return GamePlaygroupFormatFragment.selectFormat$lambda$4(this.f$0, f, mutableList, menuItem);
                }
            });
            LinearLayout subformatLayout = getBinding().subformatLayout;
            Intrinsics.checkNotNullExpressionValue(subformatLayout, "subformatLayout");
            ViewExtensionsKt.setOnClickWithFade(subformatLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamePlaygroupFormatFragment.selectFormat$lambda$5(popupMenu);
                }
            });
        }
        final int i = Integer.parseInt(preferencesManager.getString(PreferencesManager.DEFAULT_TIMER_TIME, "90"));
        getSharedViewModel().getGameState().setTimerTotalTime(f.getTimelimit() > 0 ? f.getTimelimit() : i);
        if (Intrinsics.areEqual(f.getScryfallid(), "commander")) {
            getSharedViewModel().getGameState().setTimerTotalTime(i);
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        int timerTotalTime = getSharedViewModel().getGameState().getTimerTotalTime();
        TextView textView3 = getBinding().timerTimeTextView;
        int i2 = timerTotalTime / 60;
        if (i2 > 0) {
            int i3 = timerTotalTime % 60;
            str = i3 == 0 ? i2 + "h" : i2 + "h " + i3 + "min";
        } else {
            str = (timerTotalTime % 60) + "min";
        }
        textView3.setText(str);
        if (preferencesManager.getBoolean(PreferencesManager.ENABLE_STREAMING, false)) {
            getBinding().streamingLayout.setVisibility(0);
            getBinding().streamingActiveToggleText.setText(getString(R.string.enabled));
            getBinding().streamingActiveToggleText.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_green));
            getSharedViewModel().getGameState().setStreamingEnabled(true);
            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        } else {
            getBinding().streamingLayout.setVisibility(8);
        }
        TextView streamingActiveToggleText = getBinding().streamingActiveToggleText;
        Intrinsics.checkNotNullExpressionValue(streamingActiveToggleText, "streamingActiveToggleText");
        ViewExtensionsKt.setOnClickWithFade(streamingActiveToggleText, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.selectFormat$lambda$6(this.f$0, preferencesManager);
            }
        });
        getBinding().timerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda44
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                GamePlaygroupFormatFragment.selectFormat$lambda$7(this.f$0, f, i, preferencesManager, compoundButton, z2);
            }
        });
        getBinding().duelOptionsLayout.setVisibility(0);
        getBinding().bestOfLayout.setVisibility(4);
        boolean z2 = preferencesManager.getBoolean(PreferencesManager.ENABLE_TIMER_BY_DEFAULT, true);
        getSharedViewModel().getGameState().setTimerEnabled(z2);
        getBinding().timerSwitch.setChecked(z2);
        getBinding().timerTimeTextView.setVisibility(z2 ? 0 : 4);
        getBinding().turnTimerLayout.setVisibility(0);
        if (preferencesManager.getBoolean(PreferencesManager.AUTO_ENABLE_TURN_TIMER, false)) {
            getSharedViewModel().getGameState().setTurnTimerEnabled(true);
            getBinding().turnTimerActiveToggleText.setText(getString(R.string.enabled));
            getBinding().turnTimerActiveToggleText.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_green));
        } else {
            getSharedViewModel().getGameState().setTurnTimerEnabled(false);
            getBinding().turnTimerActiveToggleText.setText(getString(R.string.disabled));
            getBinding().turnTimerActiveToggleText.setTextColor(ContextCompat.getColor(requireContext(), R.color.action_blue));
        }
        if (f.getPlayersmin() == 2 && f.getPlayersmax() == 2) {
            getBinding().bestOfLayout.setVisibility(0);
            getBinding().timerSwitch.setEnabled(true);
            getBinding().timerTimeTextView.setVisibility(0);
            getBinding().bestOfTextView.setText(getResources().getString(R.string.match_type_bo1));
            Context context = getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
                new PreferencesManager(context).clearCurrentSet();
            }
            if (Intrinsics.areEqual(f.getScryfallid(), "duel")) {
                getBinding().bestOfTextView.setText(getResources().getString(R.string.match_type_bo3));
                Context context2 = getContext();
                if (context2 != null) {
                    new PreferencesManager(context2).saveCurrentGame(getSharedViewModel().getGameState());
                    GameSet gameSet = new GameSet(null, 0, null, 7, null);
                    gameSet.setBestOf(3);
                    new PreferencesManager(context2).saveCurrentSet(gameSet);
                }
            }
            LinearLayout bestOfLayout = getBinding().bestOfLayout;
            Intrinsics.checkNotNullExpressionValue(bestOfLayout, "bestOfLayout");
            ViewExtensionsKt.setOnClickWithFade(bestOfLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamePlaygroupFormatFragment.selectFormat$lambda$10(this.f$0);
                }
            });
        }
        updateSubmitButtonState();
    }

    static final Unit selectFormat$lambda$10(final GamePlaygroupFormatFragment gamePlaygroupFormatFragment) {
        PopupMenu popupMenu = new PopupMenu(gamePlaygroupFormatFragment.requireContext(), gamePlaygroupFormatFragment.getBinding().bestOfLayout);
        Menu menu = popupMenu.getMenu();
        menu.add(0, 1, 0, gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo1));
        menu.add(0, 3, 0, gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo3));
        menu.add(0, 5, 0, gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo5));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda46
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return GamePlaygroupFormatFragment.selectFormat$lambda$10$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean selectFormat$lambda$10$0(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            gamePlaygroupFormatFragment.getBinding().bestOfTextView.setText(gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo1));
            Context context = gamePlaygroupFormatFragment.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
                new PreferencesManager(context).clearCurrentSet();
            }
        } else if (itemId == 3) {
            gamePlaygroupFormatFragment.getBinding().bestOfTextView.setText(gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo3));
            Context context2 = gamePlaygroupFormatFragment.getContext();
            if (context2 != null) {
                new PreferencesManager(context2).saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
                GameSet gameSet = new GameSet(null, 0, null, 7, null);
                gameSet.setBestOf(3);
                new PreferencesManager(context2).saveCurrentSet(gameSet);
            }
        } else if (itemId == 5) {
            gamePlaygroupFormatFragment.getBinding().bestOfTextView.setText(gamePlaygroupFormatFragment.getResources().getString(R.string.match_type_bo5));
            Context context3 = gamePlaygroupFormatFragment.getContext();
            if (context3 != null) {
                new PreferencesManager(context3).saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
                GameSet gameSet2 = new GameSet(null, 0, null, 7, null);
                gameSet2.setBestOf(5);
                new PreferencesManager(context3).saveCurrentSet(gameSet2);
            }
        }
        return true;
    }

    static final boolean selectFormat$lambda$4(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MTFormat mTFormat, List list, MenuItem menuItem) {
        Object next;
        if (menuItem.getItemId() == -1) {
            gamePlaygroupFormatFragment.getSharedViewModel().getSubFormatId().setValue(-1);
            gamePlaygroupFormatFragment.getBinding().subformatTextView.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.text_color));
            gamePlaygroupFormatFragment.getBinding().subformatTextView.setText(gamePlaygroupFormatFragment.getString(R.string.select_a_subformat));
            gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(mTFormat.getLifetotal()));
            TextView textView = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
            String string = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{0}", String.valueOf(mTFormat.getLifetotal()), false, 4, (Object) null));
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasPlanechase(false);
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasArchenemy(false);
            return true;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTSubformat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTSubformat mTSubformat = (MTSubformat) next;
        if (mTSubformat != null) {
            gamePlaygroupFormatFragment.getSharedViewModel().getSubFormatId().setValue(Integer.valueOf(mTSubformat.getId()));
            gamePlaygroupFormatFragment.getBinding().subformatTextView.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.almost_white));
            String name = mTSubformat.getName();
            if (mTSubformat.getId() == 5) {
                name = gamePlaygroupFormatFragment.getResources().getString(R.string.two_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            if (mTSubformat.getId() == 6) {
                name = gamePlaygroupFormatFragment.getResources().getString(R.string.three_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            gamePlaygroupFormatFragment.getBinding().subformatTextView.setText(name);
            Integer lifetotal = mTSubformat.getLifetotal();
            if (lifetotal != null) {
                int iIntValue = lifetotal.intValue();
                if (iIntValue > 0) {
                    gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(iIntValue));
                    TextView textView2 = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
                    String string2 = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    textView2.setText(StringsKt.replace$default(string2, "{0}", String.valueOf(iIntValue), false, 4, (Object) null));
                } else {
                    gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(mTFormat.getLifetotal()));
                    TextView textView3 = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
                    String string3 = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    textView3.setText(StringsKt.replace$default(string3, "{0}", String.valueOf(mTFormat.getLifetotal()), false, 4, (Object) null));
                }
            } else {
                gamePlaygroupFormatFragment.getSharedViewModel().getLifeTotal().setValue(Integer.valueOf(mTFormat.getLifetotal()));
                TextView textView4 = gamePlaygroupFormatFragment.getBinding().lifeTotalTextView;
                String string4 = gamePlaygroupFormatFragment.getResources().getString(R.string.starting_life_total_label);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                textView4.setText(StringsKt.replace$default(string4, "{0}", String.valueOf(mTFormat.getLifetotal()), false, 4, (Object) null));
            }
            if (mTSubformat.getId() == 1) {
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasPlanechase(true);
                GameUtils.INSTANCE.getInstance().setPlanarDeck(CollectionsKt.emptyList());
            } else {
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasPlanechase(false);
            }
            if (mTSubformat.getId() == 7) {
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasArchenemy(true);
                GameUtils.INSTANCE.getInstance().setSchemeDeck(CollectionsKt.emptyList());
            } else {
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setHasArchenemy(false);
            }
            if (mTSubformat.getId() == 10) {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gamePlaygroupFormatFragment.requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("turn_timer_on", null);
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTurnTimerEnabled(true);
                gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setText(gamePlaygroupFormatFragment.getString(R.string.enabled));
                gamePlaygroupFormatFragment.getBinding().turnTimerActiveToggleText.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.winner_green));
            }
        }
        return true;
    }

    static final Unit selectFormat$lambda$5(PopupMenu popupMenu) {
        popupMenu.show();
        return Unit.INSTANCE;
    }

    static final Unit selectFormat$lambda$6(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, PreferencesManager preferencesManager) {
        if (gamePlaygroupFormatFragment.getSharedViewModel().getGameState().getStreamingEnabled()) {
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setStreamingEnabled(false);
            preferencesManager.saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
            gamePlaygroupFormatFragment.getBinding().streamingActiveToggleText.setText(gamePlaygroupFormatFragment.getString(R.string.disabled));
            gamePlaygroupFormatFragment.getBinding().streamingActiveToggleText.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.link_color));
        } else {
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setStreamingEnabled(true);
            preferencesManager.saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
            gamePlaygroupFormatFragment.getBinding().streamingActiveToggleText.setText(gamePlaygroupFormatFragment.getString(R.string.enabled));
            gamePlaygroupFormatFragment.getBinding().streamingActiveToggleText.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.winner_green));
        }
        return Unit.INSTANCE;
    }

    static final void selectFormat$lambda$7(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, MTFormat mTFormat, int i, PreferencesManager preferencesManager, CompoundButton compoundButton, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTimerEnabled(z);
        if (z) {
            gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTimerTotalTime(mTFormat.getTimelimit() > 0 ? mTFormat.getTimelimit() : i);
            if (Intrinsics.areEqual(mTFormat.getScryfallid(), "commander")) {
                gamePlaygroupFormatFragment.getSharedViewModel().getGameState().setTimerTotalTime(i);
            }
            int timerTotalTime = gamePlaygroupFormatFragment.getSharedViewModel().getGameState().getTimerTotalTime();
            TextView textView = gamePlaygroupFormatFragment.getBinding().timerTimeTextView;
            int i2 = timerTotalTime / 60;
            if (i2 > 0) {
                int i3 = timerTotalTime % 60;
                str = i3 == 0 ? i2 + "h" : i2 + "h " + i3 + "min";
            } else {
                str = (timerTotalTime % 60) + "min";
            }
            textView.setText(str);
            gamePlaygroupFormatFragment.getBinding().timerTimeTextView.setVisibility(0);
        } else {
            gamePlaygroupFormatFragment.getBinding().timerTimeTextView.setVisibility(4);
        }
        preferencesManager.saveCurrentGame(gamePlaygroupFormatFragment.getSharedViewModel().getGameState());
    }

    private final void setupFormatButton(int index, int formatId) {
        Object next;
        ConstraintLayout constraintLayout;
        TextView textView;
        CachedImageView cachedImageView;
        if (getContext() == null) {
            return;
        }
        Iterator<T> it = this.formats.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((MTFormat) next).getId() == formatId) {
                    break;
                }
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat != null) {
            String upperCase = mTFormat.getName().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String icon = mTFormat.getIcon();
            String color = mTFormat.getColor();
            int color2 = -16777216;
            if (color != null && color.length() > 0 && !Intrinsics.areEqual(color, AbstractJsonLexerKt.NULL)) {
                color2 = Color.parseColor(color);
            }
            if (index == 0) {
                constraintLayout = getBinding().formatButton1;
                textView = getBinding().formatName1;
                cachedImageView = getBinding().formatImage1;
            } else if (index == 1) {
                constraintLayout = getBinding().formatButton2;
                textView = getBinding().formatName2;
                cachedImageView = getBinding().formatImage2;
            } else if (index == 2) {
                constraintLayout = getBinding().formatButton3;
                textView = getBinding().formatName3;
                cachedImageView = getBinding().formatImage3;
            } else if (index == 3) {
                constraintLayout = getBinding().formatButton4;
                textView = getBinding().formatName4;
                cachedImageView = getBinding().formatImage4;
            } else if (index == 4) {
                constraintLayout = getBinding().formatButton5;
                textView = getBinding().formatName5;
                cachedImageView = getBinding().formatImage5;
            } else if (index != 5) {
                cachedImageView = null;
                constraintLayout = null;
                textView = null;
            } else {
                constraintLayout = getBinding().formatButton6;
                textView = getBinding().formatName6;
                cachedImageView = getBinding().formatImage6;
            }
            if (constraintLayout != null) {
                Drawable background = constraintLayout.getBackground();
                GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(color2);
                }
                if (textView != null) {
                    textView.setText(upperCase);
                }
                if (cachedImageView != null) {
                    cachedImageView.reset();
                }
                if (cachedImageView != null) {
                    cachedImageView.setAutoLoad(false);
                }
                if (cachedImageView != null) {
                    if (icon == null) {
                        icon = "";
                    }
                    cachedImageView.loadImage(icon);
                }
            }
        }
    }

    private final void showThemeSelection() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        getBinding().themeOverlay.setVisibility(0);
        getBinding().themePickerLayout.setVisibility(0);
    }

    private final void updateFilteredMenu() {
        PopupMenu popupMenu = new PopupMenu(requireContext(), getBinding().formatLayout);
        this.filteredFormatsPopupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final List<MTFormat> mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext).getFormats());
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$updateFilteredMenu$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MTFormat) t).getName(), ((MTFormat) t2).getName());
                }
            });
        }
        for (MTFormat mTFormat : mutableList) {
            if (!this.top6Formats.contains(Integer.valueOf(mTFormat.getId())) && menu != null) {
                menu.add(0, mTFormat.getId(), 0, mTFormat.getName());
            }
        }
        PopupMenu popupMenu2 = this.filteredFormatsPopupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda38
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return GamePlaygroupFormatFragment.updateFilteredMenu$lambda$1(this.f$0, mutableList, menuItem);
                }
            });
        }
    }

    static final boolean updateFilteredMenu$lambda$1(GamePlaygroupFormatFragment gamePlaygroupFormatFragment, List list, MenuItem menuItem) {
        Object next;
        gamePlaygroupFormatFragment.getBinding().formatTextView.setText(menuItem.getTitle());
        gamePlaygroupFormatFragment.getBinding().formatTextView.setTextColor(ContextCompat.getColor(gamePlaygroupFormatFragment.requireContext(), R.color.almost_white));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat == null) {
            return true;
        }
        gamePlaygroupFormatFragment.selectFormat(mTFormat);
        return true;
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

    private final void updateSubmitButtonState() {
        if (getContext() == null) {
            return;
        }
        if (this.format != null) {
            getBinding().nextButtonLayout.setEnabled(true);
            getBinding().nextButtonLayout.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.custom_button_background));
            getBinding().nextButtonLayout.setAlpha(1.0f);
        } else {
            getBinding().nextButtonLayout.setEnabled(false);
            getBinding().nextButtonLayout.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.custom_button_background_grey));
            getBinding().nextButtonLayout.setAlpha(0.75f);
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

    public final FragmentGamePlaygroupFormatBinding getBinding() {
        FragmentGamePlaygroupFormatBinding fragmentGamePlaygroupFormatBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGamePlaygroupFormatBinding);
        return fragmentGamePlaygroupFormatBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment.PlaygroupFormatSetupCallback");
            this.callback = (PlaygroupFormatSetupCallback) parentFragment;
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
        Object next;
        Object next2;
        MTPlaygroup value;
        MTFavorites favorites;
        List<MTFavoriteFormat> formats;
        MTFavorites currentUserFavorites;
        List<MTFavoriteFormat> formats2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i = 0;
        this._binding = FragmentGamePlaygroupFormatBinding.inflate(inflater, container, false);
        getBinding().formatImage1.clearBackground();
        getBinding().formatImage2.clearBackground();
        getBinding().formatImage3.clearBackground();
        getBinding().formatImage4.clearBackground();
        getBinding().formatImage5.clearBackground();
        getBinding().formatImage6.clearBackground();
        getBinding().selectedFormatImage.clearBackground();
        getBinding().nextButtonLayout.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Integer value2 = getSharedViewModel().getPlaygroupId().getValue();
        if (value2 != null && value2.intValue() == -1) {
            BillingClient billingClientBuild = BillingClient.newBuilder(requireContext()).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
            Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
            this.billingClient = billingClientBuild;
            if (billingClientBuild == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                billingClientBuild = null;
            }
            billingClientBuild.startConnection(new AnonymousClass1());
            ImageView themeButton = getBinding().themeButton;
            Intrinsics.checkNotNullExpressionValue(themeButton, "themeButton");
            ViewExtensionsKt.setOnClickWithFade(themeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$0(this.f$0);
                }
            });
            TextView themeTitle = getBinding().themeTitle;
            Intrinsics.checkNotNullExpressionValue(themeTitle, "themeTitle");
            ViewExtensionsKt.setOnClickWithFade(themeTitle, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$1(this.f$0);
                }
            });
            TextView themeSelection = getBinding().themeSelection;
            Intrinsics.checkNotNullExpressionValue(themeSelection, "themeSelection");
            ViewExtensionsKt.setOnClickWithFade(themeSelection, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamePlaygroupFormatFragment.onCreateView$lambda$2(this.f$0);
                }
            });
            getBinding().themeOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.hideThemeSelection();
                }
            });
        } else {
            getBinding().themeButton.setVisibility(8);
            getBinding().themeOverlay.setVisibility(8);
            getBinding().themeTitle.setVisibility(8);
            getBinding().themeSelection.setVisibility(8);
        }
        if (value2 != null && value2.intValue() == -1) {
            getBinding().playgroupGameLayout.setVisibility(8);
        } else if (preferencesManager.hasValidUser() && preferencesManager.getCurrentUser() != null) {
            Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                int id = ((MTPlaygroup) next).getId();
                if (value2 != null && id == value2.intValue()) {
                    break;
                }
            }
            final MTPlaygroup mTPlaygroup = (MTPlaygroup) next;
            if (mTPlaygroup != null) {
                getBinding().playgroupName.setText(mTPlaygroup.getName());
                getBinding().usersCount.setText(String.valueOf(getSharedViewModel().getNumberOfPlayers().getValue()));
                getBinding().formatName.setVisibility(8);
                getSharedViewModel().getNumberOfPlayers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda27
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GamePlaygroupFormatFragment.onCreateView$lambda$4$1$0(this.f$0, (Integer) obj);
                    }
                });
                getBinding().profileImage.setOutlineProvider(new CircularOutlineProvider());
                getBinding().profileImage.setClipToOutline(true);
                String picture = mTPlaygroup.getPicture();
                String str = picture;
                if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                    getBinding().defaultProfileImage.setVisibility(0);
                    getBinding().profileImage.setVisibility(8);
                } else {
                    getBinding().defaultProfileImage.setVisibility(8);
                    getBinding().profileImage.setVisibility(0);
                    getBinding().profileImage.setAutoLoad(false);
                    getBinding().profileImage.reset();
                    getBinding().profileImage.loadImage(picture);
                }
                List<Integer> value3 = getSharedViewModel().getPlaygroupUsers().getValue();
                if (value3 != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Integer> it2 = value3.iterator();
                    while (it2.hasNext()) {
                        int iIntValue = it2.next().intValue();
                        Iterator<T> it3 = mTPlaygroup.getUsers().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it3.next();
                            if (((MTUser) next2).getId() == iIntValue) {
                                break;
                            }
                        }
                        MTUser mTUser = (MTUser) next2;
                        if (mTUser != null) {
                            arrayList.add(mTUser);
                        }
                    }
                    getBinding().playgroupUsersRecyclerView.setAdapter(new SmallUsersAdapter(arrayList, false, 0));
                    getBinding().playgroupUsersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(12, contextRequireContext2));
                    int itemDecorationCount = getBinding().playgroupUsersRecyclerView.getItemDecorationCount();
                    for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                        getBinding().playgroupUsersRecyclerView.removeItemDecorationAt(0);
                    }
                    getBinding().playgroupUsersRecyclerView.addItemDecoration(overlapDecoration);
                }
                getSharedViewModel().getPlaygroupUsers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda28
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GamePlaygroupFormatFragment.onCreateView$lambda$4$1$2(mTPlaygroup, this, (List) obj);
                    }
                });
            }
        }
        DecksDBHelper.Companion companion2 = DecksDBHelper.INSTANCE;
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        this.formats = companion2.getInstance(contextRequireContext3).getFormats();
        this.top6Formats = CollectionsKt.toMutableList((Collection) GameUtils.INSTANCE.getInstance().getTop6FormatIds());
        if (value2 != null && value2.intValue() == -1) {
            Context contextRequireContext4 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
            if (new PreferencesManager(contextRequireContext4).getCurrentUser() != null && (currentUserFavorites = preferencesManager.getCurrentUserFavorites()) != null && (formats2 = currentUserFavorites.getFormats()) != null && formats2.size() >= 6) {
                this.top6Formats.clear();
                Iterator<MTFavoriteFormat> it4 = formats2.iterator();
                while (it4.hasNext()) {
                    this.top6Formats.add(Integer.valueOf(it4.next().getId()));
                }
            }
        } else if (preferencesManager.hasValidUser() && preferencesManager.getCurrentUser() != null && (value = getSharedViewModel().getPlaygroup().getValue()) != null && (favorites = value.getFavorites()) != null && (formats = favorites.getFormats()) != null && formats.size() >= 6) {
            this.top6Formats.clear();
            Iterator<MTFavoriteFormat> it5 = formats.iterator();
            while (it5.hasNext()) {
                this.top6Formats.add(Integer.valueOf(it5.next().getId()));
            }
        }
        Iterator<T> it6 = this.top6Formats.iterator();
        while (it6.hasNext()) {
            setupFormatButton(i, ((Number) it6.next()).intValue());
            i++;
        }
        updateFilteredMenu();
        TextView turnTimerActiveToggleText = getBinding().turnTimerActiveToggleText;
        Intrinsics.checkNotNullExpressionValue(turnTimerActiveToggleText, "turnTimerActiveToggleText");
        ViewExtensionsKt.setOnClickWithFade(turnTimerActiveToggleText, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        LinearLayout streamingLayout = getBinding().streamingLayout;
        Intrinsics.checkNotNullExpressionValue(streamingLayout, "streamingLayout");
        ViewExtensionsKt.setOnClickWithFade(streamingLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$8(this.f$0);
            }
        });
        LinearLayout turnTimerLayout = getBinding().turnTimerLayout;
        Intrinsics.checkNotNullExpressionValue(turnTimerLayout, "turnTimerLayout");
        ViewExtensionsKt.setOnClickWithFade(turnTimerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$9(this.f$0);
            }
        });
        TextView timerTimeTextView = getBinding().timerTimeTextView;
        Intrinsics.checkNotNullExpressionValue(timerTimeTextView, "timerTimeTextView");
        ViewExtensionsKt.setOnClickWithFade(timerTimeTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$10(this.f$0);
            }
        });
        TextView overrideLifeTotalTextView = getBinding().overrideLifeTotalTextView;
        Intrinsics.checkNotNullExpressionValue(overrideLifeTotalTextView, "overrideLifeTotalTextView");
        ViewExtensionsKt.setOnClickWithFade(overrideLifeTotalTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$11(this.f$0);
            }
        });
        LinearLayout formatLayout = getBinding().formatLayout;
        Intrinsics.checkNotNullExpressionValue(formatLayout, "formatLayout");
        ViewExtensionsKt.setOnClickWithFade(formatLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$12(this.f$0);
            }
        });
        ConstraintLayout nextButtonLayout = getBinding().nextButtonLayout;
        Intrinsics.checkNotNullExpressionValue(nextButtonLayout, "nextButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(nextButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$13(this.f$0);
            }
        });
        ConstraintLayout formatButton1 = getBinding().formatButton1;
        Intrinsics.checkNotNullExpressionValue(formatButton1, "formatButton1");
        ViewExtensionsKt.setOnClickWithFade(formatButton1, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$14(this.f$0);
            }
        });
        ConstraintLayout formatButton2 = getBinding().formatButton2;
        Intrinsics.checkNotNullExpressionValue(formatButton2, "formatButton2");
        ViewExtensionsKt.setOnClickWithFade(formatButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$15(this.f$0);
            }
        });
        ConstraintLayout formatButton3 = getBinding().formatButton3;
        Intrinsics.checkNotNullExpressionValue(formatButton3, "formatButton3");
        ViewExtensionsKt.setOnClickWithFade(formatButton3, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$16(this.f$0);
            }
        });
        ConstraintLayout formatButton4 = getBinding().formatButton4;
        Intrinsics.checkNotNullExpressionValue(formatButton4, "formatButton4");
        ViewExtensionsKt.setOnClickWithFade(formatButton4, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$17(this.f$0);
            }
        });
        ConstraintLayout formatButton5 = getBinding().formatButton5;
        Intrinsics.checkNotNullExpressionValue(formatButton5, "formatButton5");
        ViewExtensionsKt.setOnClickWithFade(formatButton5, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$18(this.f$0);
            }
        });
        ConstraintLayout formatButton6 = getBinding().formatButton6;
        Intrinsics.checkNotNullExpressionValue(formatButton6, "formatButton6");
        ViewExtensionsKt.setOnClickWithFade(formatButton6, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$19(this.f$0);
            }
        });
        ConstraintLayout closeFormatLayout = getBinding().closeFormatLayout;
        Intrinsics.checkNotNullExpressionValue(closeFormatLayout, "closeFormatLayout");
        ViewExtensionsKt.setOnClickWithFade(closeFormatLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamePlaygroupFormatFragment.onCreateView$lambda$20(this.f$0);
            }
        });
        updateSubmitButtonState();
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
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda33
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
        Integer value;
        super.onResume();
        if (getContext() == null || (value = getSharedViewModel().getPlaygroupId().getValue()) == null || value.intValue() != -1) {
            return;
        }
        updateSelectedThemeName();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = preferencesManager.getBoolean(PreferencesManager.REFRESH_THEMES, false);
        if (this.themes.isEmpty() || z) {
            preferencesManager.setBoolean(PreferencesManager.REFRESH_THEMES, false);
            MTApiKt.getMtApi().getThemes(preferencesManager.getDeviceLanguage()).enqueue(new Callback<MTThemesResponse>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment.onResume.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTThemesResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTThemesResponse> call, Response<MTThemesResponse> response) throws IOException {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (GamePlaygroupFormatFragment.this.getContext() == null || GamePlaygroupFormatFragment.this._binding == null) {
                        return;
                    }
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    if (responseBodyErrorBody != null) {
                        responseBodyErrorBody.string();
                    }
                    if (!response.isSuccessful() || GamePlaygroupFormatFragment.this.getContext() == null) {
                        return;
                    }
                    MTThemesResponse mTThemesResponseBody = response.body();
                    List<MTTheme> themes = mTThemesResponseBody != null ? mTThemesResponseBody.getThemes() : null;
                    if (themes != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        GamePlaygroupFormatFragment gamePlaygroupFormatFragment = GamePlaygroupFormatFragment.this;
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
                        gamePlaygroupFormatFragment.themes = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$onResume$1$onResponse$lambda$0$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t).getGoogleproductid(), "free_", false, 2, (Object) null)), Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t2).getGoogleproductid(), "free_", false, 2, (Object) null)));
                            }
                        }));
                        for (Map.Entry entry : gamePlaygroupFormatFragment.prices.entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            Iterator it2 = gamePlaygroupFormatFragment.themes.iterator();
                            int i = 0;
                            while (it2.hasNext()) {
                                int i2 = i + 1;
                                if (Intrinsics.areEqual(((MTTheme) it2.next()).getGoogleproductid(), str)) {
                                    ((MTTheme) gamePlaygroupFormatFragment.themes.get(i)).setPrice(str2);
                                }
                                i = i2;
                            }
                        }
                        Log.d("MTApi", "Themes received, themes are : " + gamePlaygroupFormatFragment.themes);
                        gamePlaygroupFormatFragment.updateThemeAdapter();
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
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GamePlaygroupFormatFragment.onThemeAlreadyPurchased$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GamePlaygroupFormatFragment.onThemeAlreadyPurchased$lambda$1((CustomDialogFragment) obj);
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
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GamePlaygroupFormatFragment.onThemeAlreadyPurchased$lambda$2(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GamePlaygroupFormatFragment.onThemeAlreadyPurchased$lambda$3((CustomDialogFragment) obj);
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
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda10
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
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GamePlaygroupFormatFragment.onThemeTapped$lambda$0(this.f$0, theme, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupFormatFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GamePlaygroupFormatFragment.onThemeTapped$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_re_download");
    }
}
