package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.BrowseListCardItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MythicPlusRecommendationsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u0000 v2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0003uvwB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010&\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J&\u0010F\u001a\u0004\u0018\u00010+2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010K\u001a\u00020?2\u0006\u0010L\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010M\u001a\u00020?H\u0002J\u0010\u0010N\u001a\u00020?2\u0006\u0010O\u001a\u00020+H\u0002J\b\u0010P\u001a\u00020?H\u0002J\b\u0010Q\u001a\u00020?H\u0002J\u0010\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020?H\u0002J\b\u0010V\u001a\u00020?H\u0002J\b\u0010W\u001a\u00020?H\u0002J\b\u0010X\u001a\u00020?H\u0002J\u0006\u0010Y\u001a\u00020?J\u0006\u0010Z\u001a\u00020?J\b\u0010[\u001a\u00020?H\u0002J\b\u0010\\\u001a\u00020?H\u0002J\u0010\u0010]\u001a\u00020?2\u0006\u0010^\u001a\u00020\u001cH\u0002J\b\u0010_\u001a\u00020?H\u0002J\u000e\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u000fJ\b\u0010b\u001a\u00020?H\u0002J\b\u0010c\u001a\u00020?H\u0002J\b\u0010d\u001a\u00020?H\u0002J\u0010\u0010e\u001a\u00020?2\u0006\u0010f\u001a\u00020\u000fH\u0002J\u0010\u0010g\u001a\u00020?2\u0006\u0010h\u001a\u00020\u0012H\u0002J\u0018\u0010i\u001a\u00020?2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010k\u001a\u00020\tH\u0016J\u0018\u0010l\u001a\u00020?2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\tH\u0016J\u0018\u0010n\u001a\u00020?2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\tH\u0016J \u0010o\u001a\u00020?2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\t2\u0006\u0010p\u001a\u00020\tH\u0016J\u0018\u0010q\u001a\u00020?2\u0006\u0010j\u001a\u00020\u001a2\u0006\u0010r\u001a\u00020\u000fH\u0016J\u0010\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006x"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;", "<init>", "()V", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "addedCardIds", "", "", "pagerActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "selectedCategoryKey", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "recommendResponse", "Lcom/studiolaganne/lengendarylens/MTRecommendResponse;", "displayedCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "isLoading", "", "headerCollapsed", "refreshEnabled", "fromCollection", "selectedLocale", "defaultLocale", "getDefaultLocale", "()Ljava/lang/String;", "defaultLocale$delegate", "Lkotlin/Lazy;", "localeParam", "categoryPageStates", "", "Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryPageState;", "categoryViews", "Landroid/view/View;", "broadCategoryRow", "Landroid/widget/LinearLayout;", "typeCategoryScroll", "Landroid/widget/HorizontalScrollView;", "typeCategoryRow", "scrollHintButton", "Landroid/widget/TextView;", "gridToggle", "Landroid/widget/ImageView;", "cardsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadingIndicator", "Landroid/widget/ProgressBar;", "loadingFooter", "refreshButtonLayout", "fromCollectionCheckBox", "Landroid/widget/CheckBox;", "languageIcon", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parentMythicPlus", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "getParentMythicPlus", "()Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupLanguageIcon", "showLanguagePopupMenu", "anchor", "setupFromCollection", "setupCategories", "makeCategoryView", "cat", "Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryDef;", "updateCategorySelection", "setupGridToggle", "updateGridIcon", "setupScrollHint", "collapseHeader", "expandHeader", "setupRecyclerView", "setupScrollListeners", "setRefreshButtonEnabled", "enabled", "refreshRecommendations", "markCardAsAdded", "oracleId", "loadRecommendations", "seedCategoryCache", "updateDisplayedCards", "loadNextPage", "categoryKey", "syncPagerStateBack", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "onMTFullCardClick", "card", FirebaseAnalytics.Param.INDEX, "onCardLongPress", "position", "onCardSelectionToggle", "onQuantityChange", "newQuantity", "onAddToDeck", "listType", "dpToPx", "dp", "CategoryDef", "Companion", "CategoryPageState", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusRecommendationsFragment extends Fragment implements OnMTFullCardClickListener, OnCardLongPressListener, OnCardSelectionListener, OnCardAddToDeckListener {
    private static final String TAG = "MythicPlusRecsFragment";
    private LinearLayout broadCategoryRow;
    private RecyclerView cardsRecyclerView;
    private boolean fromCollection;
    private CheckBox fromCollectionCheckBox;
    private ImageView gridToggle;
    private boolean headerCollapsed;
    private boolean isLoading;
    private TextView languageIcon;
    private ProgressBar loadingFooter;
    private ProgressBar loadingIndicator;
    private ActivityResultLauncher<Intent> pagerActivityLauncher;
    private MTRecommendResponse recommendResponse;
    private View refreshButtonLayout;
    private boolean refreshEnabled;
    private TextView scrollHintButton;
    private LinearLayout typeCategoryRow;
    private HorizontalScrollView typeCategoryScroll;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final List<CategoryDef> BROAD_CATEGORIES = CollectionsKt.listOf((Object[]) new CategoryDef[]{new CategoryDef("top_picks", R.string.mythic_cat_top_picks, "\uf005", null), new CategoryDef(PreferencesManager.RECENT_CARDS_LIST_NAME, R.string.mythic_cat_recent, "\uf06d", null), new CategoryDef("staples", R.string.mythic_cat_staples, "\uf08d", null), new CategoryDef("gamechangers", R.string.mythic_cat_gamechangers, "\uf140", null)});
    private static final List<CategoryDef> TYPE_CATEGORIES = CollectionsKt.listOf((Object[]) new CategoryDef[]{new CategoryDef("creatures", R.string.mythic_cat_creatures, null, Integer.valueOf(R.drawable.type_creature)), new CategoryDef("artifacts", R.string.mythic_cat_artifacts, null, Integer.valueOf(R.drawable.type_artifact)), new CategoryDef("enchantments", R.string.mythic_cat_enchantments, null, Integer.valueOf(R.drawable.type_enchantment)), new CategoryDef("instants", R.string.mythic_cat_instants, null, Integer.valueOf(R.drawable.type_instant)), new CategoryDef("sorceries", R.string.mythic_cat_sorceries, null, Integer.valueOf(R.drawable.type_sorcery)), new CategoryDef("planeswalkers", R.string.mythic_cat_planeswalkers, null, Integer.valueOf(R.drawable.type_planeswalker)), new CategoryDef("battles", R.string.mythic_cat_battles, null, Integer.valueOf(R.drawable.type_battle)), new CategoryDef("utility_lands", R.string.mythic_cat_utility_lands, null, Integer.valueOf(R.drawable.type_utility_land)), new CategoryDef("lands", R.string.mythic_cat_lands, null, Integer.valueOf(R.drawable.type_land))});
    private int deckId = -1;
    private int mainListId = -1;
    private int sideboardListId = -1;
    private int maybeboardListId = -1;
    private final Set<String> addedCardIds = new LinkedHashSet();
    private String selectedCategoryKey = "top_picks";
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;
    private List<MTFullCard> displayedCards = CollectionsKt.emptyList();
    private String selectedLocale = "";

    /* JADX INFO: renamed from: defaultLocale$delegate, reason: from kotlin metadata */
    private final Lazy defaultLocale = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MythicPlusRecommendationsFragment.defaultLocale_delegate$lambda$0(this.f$0);
        }
    });
    private final Map<String, CategoryPageState> categoryPageStates = new LinkedHashMap();
    private final Map<String, View> categoryViews = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MythicPlusRecommendationsFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryDef;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "labelResId", "", "faIcon", "drawableRes", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getKey", "()Ljava/lang/String;", "getLabelResId", "()I", "getFaIcon", "getDrawableRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryDef;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class CategoryDef {
        private final Integer drawableRes;
        private final String faIcon;
        private final String key;
        private final int labelResId;

        public CategoryDef(String key, int i, String str, Integer num) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.labelResId = i;
            this.faIcon = str;
            this.drawableRes = num;
        }

        public static /* synthetic */ CategoryDef copy$default(CategoryDef categoryDef, String str, int i, String str2, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = categoryDef.key;
            }
            if ((i2 & 2) != 0) {
                i = categoryDef.labelResId;
            }
            if ((i2 & 4) != 0) {
                str2 = categoryDef.faIcon;
            }
            if ((i2 & 8) != 0) {
                num = categoryDef.drawableRes;
            }
            return categoryDef.copy(str, i, str2, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLabelResId() {
            return this.labelResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFaIcon() {
            return this.faIcon;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final CategoryDef copy(String key, int labelResId, String faIcon, Integer drawableRes) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new CategoryDef(key, labelResId, faIcon, drawableRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryDef)) {
                return false;
            }
            CategoryDef categoryDef = (CategoryDef) other;
            return Intrinsics.areEqual(this.key, categoryDef.key) && this.labelResId == categoryDef.labelResId && Intrinsics.areEqual(this.faIcon, categoryDef.faIcon) && Intrinsics.areEqual(this.drawableRes, categoryDef.drawableRes);
        }

        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final String getFaIcon() {
            return this.faIcon;
        }

        public final String getKey() {
            return this.key;
        }

        public final int getLabelResId() {
            return this.labelResId;
        }

        public int hashCode() {
            int iHashCode = ((this.key.hashCode() * 31) + Integer.hashCode(this.labelResId)) * 31;
            String str = this.faIcon;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.drawableRes;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "CategoryDef(key=" + this.key + ", labelResId=" + this.labelResId + ", faIcon=" + this.faIcon + ", drawableRes=" + this.drawableRes + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MythicPlusRecommendationsFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010!\u001a\u00020\bHÆ\u0003JH\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryPageState;", "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentPage", "", "hasMorePages", "", "total", "isLoadingMore", "<init>", "(Ljava/util/List;IZLjava/lang/Integer;Z)V", "getCards", "()Ljava/util/List;", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "getHasMorePages", "()Z", "setHasMorePages", "(Z)V", "getTotal", "()Ljava/lang/Integer;", "setTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setLoadingMore", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;IZLjava/lang/Integer;Z)Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryPageState;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class CategoryPageState {
        private final List<MTFullCard> cards;
        private int currentPage;
        private boolean hasMorePages;
        private boolean isLoadingMore;
        private Integer total;

        public CategoryPageState() {
            this(null, 0, false, null, false, 31, null);
        }

        public CategoryPageState(List<MTFullCard> cards, int i, boolean z, Integer num, boolean z2) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.cards = cards;
            this.currentPage = i;
            this.hasMorePages = z;
            this.total = num;
            this.isLoadingMore = z2;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ CategoryPageState(java.util.List r2, int r3, boolean r4, java.lang.Integer r5, boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
            /*
                r1 = this;
                r8 = r7 & 1
                if (r8 == 0) goto Lb
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.List r2 = (java.util.List) r2
            Lb:
                r8 = r7 & 2
                if (r8 == 0) goto L10
                r3 = 1
            L10:
                r8 = r7 & 4
                r0 = 0
                if (r8 == 0) goto L16
                r4 = r0
            L16:
                r8 = r7 & 8
                if (r8 == 0) goto L1b
                r5 = 0
            L1b:
                r7 = r7 & 16
                if (r7 == 0) goto L26
                r8 = r0
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
                goto L2c
            L26:
                r8 = r6
                r7 = r5
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
            L2c:
                r3.<init>(r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment.CategoryPageState.<init>(java.util.List, int, boolean, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CategoryPageState copy$default(CategoryPageState categoryPageState, List list, int i, boolean z, Integer num, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = categoryPageState.cards;
            }
            if ((i2 & 2) != 0) {
                i = categoryPageState.currentPage;
            }
            if ((i2 & 4) != 0) {
                z = categoryPageState.hasMorePages;
            }
            if ((i2 & 8) != 0) {
                num = categoryPageState.total;
            }
            if ((i2 & 16) != 0) {
                z2 = categoryPageState.isLoadingMore;
            }
            boolean z3 = z2;
            boolean z4 = z;
            return categoryPageState.copy(list, i, z4, num, z3);
        }

        public final List<MTFullCard> component1() {
            return this.cards;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCurrentPage() {
            return this.currentPage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasMorePages() {
            return this.hasMorePages;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsLoadingMore() {
            return this.isLoadingMore;
        }

        public final CategoryPageState copy(List<MTFullCard> cards, int currentPage, boolean hasMorePages, Integer total, boolean isLoadingMore) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            return new CategoryPageState(cards, currentPage, hasMorePages, total, isLoadingMore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryPageState)) {
                return false;
            }
            CategoryPageState categoryPageState = (CategoryPageState) other;
            return Intrinsics.areEqual(this.cards, categoryPageState.cards) && this.currentPage == categoryPageState.currentPage && this.hasMorePages == categoryPageState.hasMorePages && Intrinsics.areEqual(this.total, categoryPageState.total) && this.isLoadingMore == categoryPageState.isLoadingMore;
        }

        public final List<MTFullCard> getCards() {
            return this.cards;
        }

        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final boolean getHasMorePages() {
            return this.hasMorePages;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public int hashCode() {
            int iHashCode = ((((this.cards.hashCode() * 31) + Integer.hashCode(this.currentPage)) * 31) + Boolean.hashCode(this.hasMorePages)) * 31;
            Integer num = this.total;
            return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isLoadingMore);
        }

        public final boolean isLoadingMore() {
            return this.isLoadingMore;
        }

        public final void setCurrentPage(int i) {
            this.currentPage = i;
        }

        public final void setHasMorePages(boolean z) {
            this.hasMorePages = z;
        }

        public final void setLoadingMore(boolean z) {
            this.isLoadingMore = z;
        }

        public final void setTotal(Integer num) {
            this.total = num;
        }

        public String toString() {
            return "CategoryPageState(cards=" + this.cards + ", currentPage=" + this.currentPage + ", hasMorePages=" + this.hasMorePages + ", total=" + this.total + ", isLoadingMore=" + this.isLoadingMore + ")";
        }
    }

    /* JADX INFO: compiled from: MythicPlusRecommendationsFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$Companion;", "", "<init>", "()V", "TAG", "", "BROAD_CATEGORIES", "", "Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment$CategoryDef;", "TYPE_CATEGORIES", "newInstance", "Lcom/studiolaganne/lengendarylens/MythicPlusRecommendationsFragment;", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MythicPlusRecommendationsFragment newInstance(int deckId, int mainListId, int sideboardListId, int maybeboardListId) {
            MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment = new MythicPlusRecommendationsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("deckId", deckId);
            bundle.putInt("mainListId", mainListId);
            bundle.putInt("sideboardListId", sideboardListId);
            bundle.putInt("maybeboardListId", maybeboardListId);
            mythicPlusRecommendationsFragment.setArguments(bundle);
            return mythicPlusRecommendationsFragment;
        }
    }

    /* JADX INFO: compiled from: MythicPlusRecommendationsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardsLayout.values().length];
            try {
                iArr[CardsLayout.GRID_BY_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardsLayout.GRID_BY_3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardsLayout.LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final String defaultLocale_delegate$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment) {
        Context contextRequireContext = mythicPlusRecommendationsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return new PreferencesManager(contextRequireContext).getDeviceLanguage();
    }

    private final int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    private final String getDefaultLocale() {
        return (String) this.defaultLocale.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MythicPlusBottomSheetFragment getParentMythicPlus() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MythicPlusBottomSheetFragment) {
            return (MythicPlusBottomSheetFragment) parentFragment;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage(final String categoryKey) {
        final CategoryPageState categoryPageState = this.categoryPageStates.get(categoryKey);
        if (categoryPageState != null && !categoryPageState.isLoadingMore() && categoryPageState.getHasMorePages() && this.deckId > 0) {
            categoryPageState.setLoadingMore(true);
            ProgressBar progressBar = this.loadingFooter;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingFooter");
                progressBar = null;
            }
            progressBar.setVisibility(0);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
            final int currentPage = categoryPageState.getCurrentPage() + 1;
            MTApi mtApi = MTApiKt.getMtApi();
            int i = this.deckId;
            Boolean boolValueOf = Boolean.valueOf(this.fromCollection);
            mtApi.getCardRecommendationsByCategory(i, categoryKey, currentPage, boolValueOf.booleanValue() ? boolValueOf : null, localeParam(), numValueOf).enqueue(new Callback<MTRecommendCategoryResponse>() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment.loadNextPage.2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTRecommendCategoryResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (MythicPlusRecommendationsFragment.this.isAdded()) {
                        categoryPageState.setLoadingMore(false);
                        ProgressBar progressBar2 = MythicPlusRecommendationsFragment.this.loadingFooter;
                        if (progressBar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingFooter");
                            progressBar2 = null;
                        }
                        progressBar2.setVisibility(8);
                        Log.e(MythicPlusRecommendationsFragment.TAG, "Load next page failure", t);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
                @Override // retrofit2.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(Call<MTRecommendCategoryResponse> call, Response<MTRecommendCategoryResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (MythicPlusRecommendationsFragment.this.isAdded()) {
                        boolean z = false;
                        categoryPageState.setLoadingMore(false);
                        ProgressBar progressBar2 = MythicPlusRecommendationsFragment.this.loadingFooter;
                        RecyclerView recyclerView = null;
                        if (progressBar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingFooter");
                            progressBar2 = null;
                        }
                        progressBar2.setVisibility(8);
                        if (!response.isSuccessful()) {
                            Log.e(MythicPlusRecommendationsFragment.TAG, "Load next page error: " + response.code());
                            return;
                        }
                        MTRecommendCategoryResponse mTRecommendCategoryResponseBody = response.body();
                        if (mTRecommendCategoryResponseBody == null) {
                            return;
                        }
                        List<MTFullCard> cards = mTRecommendCategoryResponseBody.getCards();
                        if (cards == null) {
                            cards = CollectionsKt.emptyList();
                        }
                        List<MTFullCard> list = cards;
                        categoryPageState.getCards().addAll(list);
                        CategoryPageState categoryPageState2 = categoryPageState;
                        Integer page = mTRecommendCategoryResponseBody.getPage();
                        categoryPageState2.setCurrentPage(page != null ? page.intValue() : currentPage);
                        categoryPageState.setTotal(mTRecommendCategoryResponseBody.getTotal());
                        Integer limit = mTRecommendCategoryResponseBody.getLimit();
                        int iIntValue = limit != null ? limit.intValue() : cards.size();
                        CategoryPageState categoryPageState3 = categoryPageState;
                        if (iIntValue > 0 && categoryPageState3.getTotal() != null) {
                            int currentPage2 = categoryPageState.getCurrentPage() * iIntValue;
                            Integer total = categoryPageState.getTotal();
                            Intrinsics.checkNotNull(total);
                            if (currentPage2 < total.intValue()) {
                            }
                        } else if (!list.isEmpty()) {
                            z = true;
                        }
                        categoryPageState3.setHasMorePages(z);
                        if (Intrinsics.areEqual(MythicPlusRecommendationsFragment.this.selectedCategoryKey, categoryKey)) {
                            MythicPlusRecommendationsFragment.this.displayedCards = categoryPageState.getCards();
                            RecyclerView recyclerView2 = MythicPlusRecommendationsFragment.this.cardsRecyclerView;
                            if (recyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                                recyclerView2 = null;
                            }
                            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                            Parcelable parcelableOnSaveInstanceState = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
                            MythicPlusRecommendationsFragment.this.setupRecyclerView();
                            RecyclerView recyclerView3 = MythicPlusRecommendationsFragment.this.cardsRecyclerView;
                            if (recyclerView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                            } else {
                                recyclerView = recyclerView3;
                            }
                            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                            if (layoutManager2 != null) {
                                layoutManager2.onRestoreInstanceState(parcelableOnSaveInstanceState);
                            }
                        }
                    }
                }
            });
        }
    }

    private final void loadRecommendations() {
        if (this.deckId <= 0) {
            return;
        }
        this.isLoading = true;
        ProgressBar progressBar = this.loadingIndicator;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        RecyclerView recyclerView = this.cardsRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
        MTApi mtApi = MTApiKt.getMtApi();
        int i = this.deckId;
        Boolean boolValueOf = Boolean.valueOf(this.fromCollection);
        mtApi.getCardRecommendations(i, boolValueOf.booleanValue() ? boolValueOf : null, localeParam(), numValueOf).enqueue(new Callback<MTRecommendResponse>() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment.loadRecommendations.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTRecommendResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (MythicPlusRecommendationsFragment.this.isAdded()) {
                    MythicPlusRecommendationsFragment.this.isLoading = false;
                    ProgressBar progressBar2 = MythicPlusRecommendationsFragment.this.loadingIndicator;
                    RecyclerView recyclerView2 = null;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
                        progressBar2 = null;
                    }
                    progressBar2.setVisibility(8);
                    RecyclerView recyclerView3 = MythicPlusRecommendationsFragment.this.cardsRecyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                    } else {
                        recyclerView2 = recyclerView3;
                    }
                    recyclerView2.setVisibility(0);
                    Log.e(MythicPlusRecommendationsFragment.TAG, "Recommendations API failure", t);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTRecommendResponse> call, Response<MTRecommendResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (MythicPlusRecommendationsFragment.this.isAdded()) {
                    MythicPlusRecommendationsFragment.this.isLoading = false;
                    ProgressBar progressBar2 = MythicPlusRecommendationsFragment.this.loadingIndicator;
                    RecyclerView recyclerView2 = null;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
                        progressBar2 = null;
                    }
                    progressBar2.setVisibility(8);
                    RecyclerView recyclerView3 = MythicPlusRecommendationsFragment.this.cardsRecyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                    } else {
                        recyclerView2 = recyclerView3;
                    }
                    recyclerView2.setVisibility(0);
                    if (!response.isSuccessful()) {
                        Log.e(MythicPlusRecommendationsFragment.TAG, "Recommendations API error: " + response.code());
                    } else {
                        MythicPlusRecommendationsFragment.this.recommendResponse = response.body();
                        MythicPlusRecommendationsFragment.this.seedCategoryCache();
                        MythicPlusRecommendationsFragment.this.updateDisplayedCards();
                    }
                }
            }
        });
    }

    private final String localeParam() {
        String str = this.selectedLocale;
        if (str.length() <= 0 || Intrinsics.areEqual(str, getDefaultLocale())) {
            return null;
        }
        return str;
    }

    private final View makeCategoryView(final CategoryDef cat) {
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(4, 4, 4, 4);
        linearLayout.setTag(cat.getKey());
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.type_selected_background);
        linearLayout.setBackground(drawable != null ? drawable.mutate() : null);
        if (cat.getFaIcon() != null) {
            TextView textView = new TextView(requireContext());
            textView.setText(cat.getFaIcon());
            textView.setTypeface(ResourcesCompat.getFont(textView.getContext(), R.font.fa6solid));
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            textView.setTextColor(-3683638);
            linearLayout.addView(textView);
        } else if (cat.getDrawableRes() != null) {
            ImageView imageView = new ImageView(requireContext());
            imageView.setImageResource(cat.getDrawableRes().intValue());
            int iDpToPx = dpToPx(20);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iDpToPx, iDpToPx);
            layoutParams.gravity = 1;
            imageView.setLayoutParams(layoutParams);
            imageView.setColorFilter(-3683638);
            linearLayout.addView(imageView);
        }
        TextView textView2 = new TextView(requireContext());
        textView2.setText(getString(cat.getLabelResId()));
        textView2.setTextSize(11.0f);
        textView2.setGravity(17);
        textView2.setMaxLines(2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 4;
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(-3683638);
        linearLayout.addView(textView2);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MythicPlusRecommendationsFragment.makeCategoryView$lambda$4(this.f$0, cat, view);
            }
        });
        return linearLayout;
    }

    static final void makeCategoryView$lambda$4(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, CategoryDef categoryDef, View view) {
        mythicPlusRecommendationsFragment.selectedCategoryKey = categoryDef.getKey();
        mythicPlusRecommendationsFragment.updateCategorySelection();
        mythicPlusRecommendationsFragment.updateDisplayedCards();
    }

    static final void onCreate$lambda$1(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, ActivityResult result) {
        Intent data;
        MythicPlusBottomSheetFragment parentMythicPlus;
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        boolean booleanExtra = data.getBooleanExtra("deckChanged", false);
        String stringExtra = data.getStringExtra("newlyAddedOracleIds");
        if (stringExtra == null) {
            return;
        }
        try {
            List listEmptyList = (List) new Gson().fromJson(stringExtra, new TypeToken<List<? extends String>>() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$onCreate$2$type$1
            }.getType());
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                mythicPlusRecommendationsFragment.markCardAsAdded((String) it.next());
            }
            if (booleanExtra && (parentMythicPlus = mythicPlusRecommendationsFragment.getParentMythicPlus()) != null && (callback = parentMythicPlus.getCallback()) != null) {
                callback.onDeckChanged();
            }
        } catch (Exception unused) {
        }
        mythicPlusRecommendationsFragment.syncPagerStateBack(data);
    }

    static final void onViewCreated$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, View view) {
        if (mythicPlusRecommendationsFragment.refreshEnabled) {
            mythicPlusRecommendationsFragment.refreshRecommendations();
        }
    }

    private final void refreshRecommendations() {
        setRefreshButtonEnabled(false);
        this.recommendResponse = null;
        this.categoryPageStates.clear();
        loadRecommendations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seedCategoryCache() {
        List<MTRecommendCategory> categories;
        ArrayList arrayList;
        this.categoryPageStates.clear();
        MTRecommendResponse mTRecommendResponse = this.recommendResponse;
        if (mTRecommendResponse == null || (categories = mTRecommendResponse.getCategories()) == null) {
            return;
        }
        for (MTRecommendCategory mTRecommendCategory : categories) {
            Map<String, CategoryPageState> map = this.categoryPageStates;
            String key = mTRecommendCategory.getKey();
            List<MTFullCard> cards = mTRecommendCategory.getCards();
            if (cards == null || (arrayList = CollectionsKt.toMutableList((Collection) cards)) == null) {
                arrayList = new ArrayList();
            }
            map.put(key, new CategoryPageState(arrayList, 1, Intrinsics.areEqual((Object) mTRecommendCategory.getHasMore(), (Object) true), null, false));
        }
    }

    private final void setRefreshButtonEnabled(boolean enabled) {
        this.refreshEnabled = enabled;
        View view = this.refreshButtonLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButtonLayout");
            view = null;
        }
        view.setAlpha(enabled ? 1.0f : 0.5f);
    }

    private final void setupCategories() {
        LinearLayout linearLayout = this.broadCategoryRow;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.typeCategoryRow;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeCategoryRow");
            linearLayout2 = null;
        }
        linearLayout2.removeAllViews();
        for (CategoryDef categoryDef : BROAD_CATEGORIES) {
            View viewMakeCategoryView = makeCategoryView(categoryDef);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.setMarginStart(2);
            layoutParams.setMarginEnd(2);
            LinearLayout linearLayout3 = this.broadCategoryRow;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
                linearLayout3 = null;
            }
            linearLayout3.addView(viewMakeCategoryView, layoutParams);
            this.categoryViews.put(categoryDef.getKey(), viewMakeCategoryView);
        }
        for (CategoryDef categoryDef2 : TYPE_CATEGORIES) {
            View viewMakeCategoryView2 = makeCategoryView(categoryDef2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dpToPx(76), -1);
            layoutParams2.setMarginStart(2);
            layoutParams2.setMarginEnd(2);
            LinearLayout linearLayout4 = this.typeCategoryRow;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("typeCategoryRow");
                linearLayout4 = null;
            }
            linearLayout4.addView(viewMakeCategoryView2, layoutParams2);
            this.categoryViews.put(categoryDef2.getKey(), viewMakeCategoryView2);
        }
        updateCategorySelection();
    }

    private final void setupFromCollection() {
        this.fromCollection = false;
        CheckBox checkBox = this.fromCollectionCheckBox;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromCollectionCheckBox");
            checkBox = null;
        }
        checkBox.setOnCheckedChangeListener(null);
        CheckBox checkBox3 = this.fromCollectionCheckBox;
        if (checkBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromCollectionCheckBox");
            checkBox3 = null;
        }
        checkBox3.setChecked(false);
        CheckBox checkBox4 = this.fromCollectionCheckBox;
        if (checkBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromCollectionCheckBox");
        } else {
            checkBox2 = checkBox4;
        }
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MythicPlusRecommendationsFragment.setupFromCollection$lambda$0(this.f$0, compoundButton, z);
            }
        });
    }

    static final void setupFromCollection$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        mythicPlusRecommendationsFragment.fromCollection = z;
        mythicPlusRecommendationsFragment.recommendResponse = null;
        mythicPlusRecommendationsFragment.categoryPageStates.clear();
        mythicPlusRecommendationsFragment.loadRecommendations();
    }

    private final void setupGridToggle() {
        updateGridIcon();
        ImageView imageView = this.gridToggle;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MythicPlusRecommendationsFragment.setupGridToggle$lambda$0(this.f$0, view);
            }
        });
    }

    static final void setupGridToggle$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, View view) {
        CardsLayout cardsLayout;
        int i = WhenMappings.$EnumSwitchMapping$0[mythicPlusRecommendationsFragment.currentLayout.ordinal()];
        if (i == 1) {
            cardsLayout = CardsLayout.GRID_BY_3;
        } else if (i == 2) {
            cardsLayout = CardsLayout.LIST;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            cardsLayout = CardsLayout.GRID_BY_2;
        }
        mythicPlusRecommendationsFragment.currentLayout = cardsLayout;
        mythicPlusRecommendationsFragment.updateGridIcon();
        mythicPlusRecommendationsFragment.setupRecyclerView();
    }

    private final void setupLanguageIcon() {
        TextView textView = this.languageIcon;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageIcon");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MythicPlusRecommendationsFragment.setupLanguageIcon$lambda$0(this.f$0, view);
            }
        });
    }

    static final void setupLanguageIcon$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, View view) {
        Intrinsics.checkNotNull(view);
        mythicPlusRecommendationsFragment.showLanguagePopupMenu(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupRecyclerView() {
        List<MTFullCard> list = this.displayedCards;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new BrowseListCardItem.Card((MTFullCard) obj, i));
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        RecyclerView recyclerView = null;
        if (i3 == 1 || i3 == 2) {
            int i4 = this.currentLayout == CardsLayout.GRID_BY_2 ? 2 : 3;
            boolean z = this.currentLayout == CardsLayout.GRID_BY_3;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), i4);
            MTFullCardsAdapter mTFullCardsAdapter = new MTFullCardsAdapter(arrayList2, -1, CollectionsKt.emptyList(), z, this, this, this, this, this.addedCardIds);
            RecyclerView recyclerView2 = this.cardsRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView3 = this.cardsRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAdapter(mTFullCardsAdapter);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            RecyclerView recyclerView4 = this.cardsRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                recyclerView4 = null;
            }
            recyclerView4.setLayoutManager(new LinearLayoutManager(requireContext()));
            MTFullCardListAdapter mTFullCardListAdapter = new MTFullCardListAdapter(arrayList2, -1, this, this, this, this, this.addedCardIds);
            RecyclerView recyclerView5 = this.cardsRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
            } else {
                recyclerView = recyclerView5;
            }
            recyclerView.setAdapter(mTFullCardListAdapter);
        }
        setupScrollListeners();
    }

    private final void setupScrollHint() {
        TextView textView = this.scrollHintButton;
        HorizontalScrollView horizontalScrollView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollHintButton");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MythicPlusRecommendationsFragment.setupScrollHint$lambda$0(this.f$0, view);
            }
        });
        HorizontalScrollView horizontalScrollView2 = this.typeCategoryScroll;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
        } else {
            horizontalScrollView = horizontalScrollView2;
        }
        horizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                MythicPlusRecommendationsFragment.setupScrollHint$lambda$1(this.f$0);
            }
        });
    }

    static final void setupScrollHint$lambda$0(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, View view) {
        HorizontalScrollView horizontalScrollView = mythicPlusRecommendationsFragment.typeCategoryScroll;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
            horizontalScrollView = null;
        }
        horizontalScrollView.smoothScrollBy(mythicPlusRecommendationsFragment.dpToPx(150), 0);
    }

    static final void setupScrollHint$lambda$1(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment) {
        if (mythicPlusRecommendationsFragment.isAdded()) {
            HorizontalScrollView horizontalScrollView = mythicPlusRecommendationsFragment.typeCategoryScroll;
            TextView textView = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
                horizontalScrollView = null;
            }
            View childAt = horizontalScrollView.getChildAt(0);
            if (childAt == null) {
                return;
            }
            boolean z = horizontalScrollView.getScrollX() + horizontalScrollView.getWidth() >= childAt.getWidth() - mythicPlusRecommendationsFragment.dpToPx(8);
            TextView textView2 = mythicPlusRecommendationsFragment.scrollHintButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollHintButton");
            } else {
                textView = textView2;
            }
            textView.animate().alpha(z ? 0.0f : 1.0f).setDuration(150L).start();
        }
    }

    private final void setupScrollListeners() {
        RecyclerView recyclerView = this.cardsRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
            recyclerView = null;
        }
        recyclerView.clearOnScrollListeners();
        RecyclerView recyclerView3 = this.cardsRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment.setupScrollListeners.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView4, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (newState == 0 && MythicPlusRecommendationsFragment.this.headerCollapsed && !recyclerView4.canScrollVertically(-1)) {
                    MythicPlusRecommendationsFragment.this.expandHeader();
                    MythicPlusBottomSheetFragment parentMythicPlus = MythicPlusRecommendationsFragment.this.getParentMythicPlus();
                    if (parentMythicPlus != null) {
                        parentMythicPlus.expandTabLabels();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                RecyclerView.LayoutManager layoutManager;
                int iFindFirstVisibleItemPosition;
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (dy > 4 && !MythicPlusRecommendationsFragment.this.headerCollapsed) {
                    MythicPlusRecommendationsFragment.this.collapseHeader();
                    MythicPlusBottomSheetFragment parentMythicPlus = MythicPlusRecommendationsFragment.this.getParentMythicPlus();
                    if (parentMythicPlus != null) {
                        parentMythicPlus.collapseTabLabels();
                    }
                }
                if (dy <= 0 || (layoutManager = recyclerView4.getLayoutManager()) == null) {
                    return;
                }
                int itemCount = layoutManager.getItemCount();
                int childCount = layoutManager.getChildCount();
                if (layoutManager instanceof GridLayoutManager) {
                    iFindFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (!(layoutManager instanceof LinearLayoutManager)) {
                    return;
                } else {
                    iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                }
                CategoryPageState categoryPageState = (CategoryPageState) MythicPlusRecommendationsFragment.this.categoryPageStates.get(MythicPlusRecommendationsFragment.this.selectedCategoryKey);
                if (categoryPageState != null && !categoryPageState.isLoadingMore() && categoryPageState.getHasMorePages() && childCount + iFindFirstVisibleItemPosition >= itemCount - 5) {
                    MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment = MythicPlusRecommendationsFragment.this;
                    mythicPlusRecommendationsFragment.loadNextPage(mythicPlusRecommendationsFragment.selectedCategoryKey);
                }
            }
        });
    }

    private final void showLanguagePopupMenu(View anchor) {
        MenuItem menuItemFindItem;
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.mythic_plus_language_menu, popupMenu.getMenu());
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("en", Integer.valueOf(R.id.lang_en)), TuplesKt.to("fr", Integer.valueOf(R.id.lang_fr)), TuplesKt.to("es", Integer.valueOf(R.id.lang_es)), TuplesKt.to("de", Integer.valueOf(R.id.lang_de)), TuplesKt.to("it", Integer.valueOf(R.id.lang_it)), TuplesKt.to("pt", Integer.valueOf(R.id.lang_pt)), TuplesKt.to("ja", Integer.valueOf(R.id.lang_ja)), TuplesKt.to("ko", Integer.valueOf(R.id.lang_ko)), TuplesKt.to("zht", Integer.valueOf(R.id.lang_zht)), TuplesKt.to("zhs", Integer.valueOf(R.id.lang_zhs)), TuplesKt.to("ru", Integer.valueOf(R.id.lang_ru)));
        Set<Map.Entry> setEntrySet = mapMapOf.entrySet();
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Pair pair = TuplesKt.to(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Integer num = (Integer) mapMapOf.get(this.selectedLocale);
        if (num == null) {
            num = (Integer) mapMapOf.get(getDefaultLocale());
        }
        if (num != null && (menuItemFindItem = popupMenu.getMenu().findItem(num.intValue())) != null) {
            menuItemFindItem.setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MythicPlusRecommendationsFragment.showLanguagePopupMenu$lambda$2(this.f$0, linkedHashMap, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showLanguagePopupMenu$lambda$2(MythicPlusRecommendationsFragment mythicPlusRecommendationsFragment, Map map, MenuItem menuItem) {
        String str;
        if (mythicPlusRecommendationsFragment.getContext() == null || (str = (String) map.get(Integer.valueOf(menuItem.getItemId()))) == null) {
            return false;
        }
        if (Intrinsics.areEqual(str, mythicPlusRecommendationsFragment.selectedLocale)) {
            return true;
        }
        mythicPlusRecommendationsFragment.selectedLocale = str;
        mythicPlusRecommendationsFragment.recommendResponse = null;
        mythicPlusRecommendationsFragment.categoryPageStates.clear();
        mythicPlusRecommendationsFragment.loadRecommendations();
        return true;
    }

    private final void syncPagerStateBack(Intent data) {
        CategoryPageState categoryPageState;
        try {
            String stringExtra = data.getStringExtra("categoryKey");
            if (stringExtra == null) {
                return;
            }
            int intExtra = data.getIntExtra("updatedPage", -1);
            boolean booleanExtra = data.getBooleanExtra("updatedHasMorePages", true);
            int intExtra2 = data.getIntExtra("updatedTotal", -1);
            String stringExtra2 = data.getStringExtra("updatedCards");
            if (stringExtra2 == null) {
                return;
            }
            List list = (List) new Gson().fromJson(stringExtra2, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$syncPagerStateBack$type$1
            }.getType());
            if (list == null || (categoryPageState = this.categoryPageStates.get(stringExtra)) == null || list.size() <= categoryPageState.getCards().size()) {
                return;
            }
            categoryPageState.getCards().clear();
            categoryPageState.getCards().addAll(list);
            if (intExtra <= 0) {
                intExtra = categoryPageState.getCurrentPage();
            }
            categoryPageState.setCurrentPage(intExtra);
            categoryPageState.setHasMorePages(booleanExtra);
            if (intExtra2 > 0) {
                categoryPageState.setTotal(Integer.valueOf(intExtra2));
            }
            if (Intrinsics.areEqual(this.selectedCategoryKey, stringExtra)) {
                this.displayedCards = categoryPageState.getCards();
                setupRecyclerView();
            }
        } catch (Exception unused) {
        }
    }

    private final void updateCategorySelection() {
        int color = ContextCompat.getColor(requireContext(), R.color.mythic_plus);
        for (Map.Entry<String, View> entry : this.categoryViews.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            boolean zAreEqual = Intrinsics.areEqual(key, this.selectedCategoryKey);
            value.setAlpha(zAreEqual ? 1.0f : 0.7f);
            if (zAreEqual) {
                value.setBackgroundResource(R.drawable.type_selected_background);
                Drawable background = value.getBackground();
                if (background != null) {
                    background.setTint(ContextCompat.getColor(requireContext(), R.color.mythic_plus_transparent));
                }
            } else {
                value.setBackground(null);
            }
            if (value instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) value;
                int childCount = linearLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = linearLayout.getChildAt(i);
                    if (childAt instanceof TextView) {
                        ((TextView) childAt).setTextColor(zAreEqual ? color : -5592406);
                    }
                    if (childAt instanceof ImageView) {
                        ((ImageView) childAt).setColorFilter(zAreEqual ? color : -5592406);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateDisplayedCards() {
        List<MTFullCard> cards;
        List<MTRecommendCategory> categories;
        MTRecommendCategory mTRecommendCategory;
        List<MTRecommendCategory> categories2;
        Object next;
        List<MTFullCard> cards2;
        CategoryPageState categoryPageState = this.categoryPageStates.get(this.selectedCategoryKey);
        if (categoryPageState != null) {
            cards = categoryPageState.getCards();
        } else {
            MTRecommendResponse mTRecommendResponse = this.recommendResponse;
            if (mTRecommendResponse == null || (categories2 = mTRecommendResponse.getCategories()) == null) {
                cards = (mTRecommendResponse == null || (categories = mTRecommendResponse.getCategories()) == null || (mTRecommendCategory = (MTRecommendCategory) CollectionsKt.firstOrNull((List) categories)) == null) ? null : mTRecommendCategory.getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
            } else {
                Iterator<T> it = categories2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((MTRecommendCategory) next).getKey(), this.selectedCategoryKey)) {
                            break;
                        }
                    }
                }
                MTRecommendCategory mTRecommendCategory2 = (MTRecommendCategory) next;
                if (mTRecommendCategory2 != null && (cards2 = mTRecommendCategory2.getCards()) != null) {
                    cards = cards2;
                }
            }
        }
        this.displayedCards = cards;
        setupRecyclerView();
    }

    private final void updateGridIcon() {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i2 == 1) {
            i = R.drawable.grid_2;
        } else if (i2 == 2) {
            i = R.drawable.grid_3;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.view_list;
        }
        ImageView imageView = this.gridToggle;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
            imageView = null;
        }
        imageView.setImageResource(i);
    }

    public final void collapseHeader() {
        if (this.headerCollapsed) {
            return;
        }
        this.headerCollapsed = true;
        Iterator<Map.Entry<String, View>> it = this.categoryViews.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (value instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) value;
                if (linearLayout.getChildCount() > 1) {
                    linearLayout.getChildAt(linearLayout.getChildCount() - 1).setVisibility(8);
                }
            }
        }
        LinearLayout linearLayout2 = this.broadCategoryRow;
        HorizontalScrollView horizontalScrollView = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
            linearLayout2 = null;
        }
        linearLayout2.getLayoutParams().height = dpToPx(32);
        LinearLayout linearLayout3 = this.broadCategoryRow;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
            linearLayout3 = null;
        }
        linearLayout3.requestLayout();
        HorizontalScrollView horizontalScrollView2 = this.typeCategoryScroll;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
            horizontalScrollView2 = null;
        }
        horizontalScrollView2.getLayoutParams().height = dpToPx(32);
        HorizontalScrollView horizontalScrollView3 = this.typeCategoryScroll;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
        } else {
            horizontalScrollView = horizontalScrollView3;
        }
        horizontalScrollView.requestLayout();
    }

    public final void expandHeader() {
        if (this.headerCollapsed) {
            this.headerCollapsed = false;
            Iterator<Map.Entry<String, View>> it = this.categoryViews.entrySet().iterator();
            while (it.hasNext()) {
                View value = it.next().getValue();
                if (value instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) value;
                    if (linearLayout.getChildCount() > 1) {
                        linearLayout.getChildAt(linearLayout.getChildCount() - 1).setVisibility(0);
                    }
                }
            }
            LinearLayout linearLayout2 = this.broadCategoryRow;
            HorizontalScrollView horizontalScrollView = null;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
                linearLayout2 = null;
            }
            linearLayout2.getLayoutParams().height = dpToPx(56);
            LinearLayout linearLayout3 = this.broadCategoryRow;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("broadCategoryRow");
                linearLayout3 = null;
            }
            linearLayout3.requestLayout();
            HorizontalScrollView horizontalScrollView2 = this.typeCategoryScroll;
            if (horizontalScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
                horizontalScrollView2 = null;
            }
            horizontalScrollView2.getLayoutParams().height = dpToPx(56);
            HorizontalScrollView horizontalScrollView3 = this.typeCategoryScroll;
            if (horizontalScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("typeCategoryScroll");
            } else {
                horizontalScrollView = horizontalScrollView3;
            }
            horizontalScrollView.requestLayout();
        }
    }

    public final void markCardAsAdded(String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        this.addedCardIds.add(oracleId);
        if (isAdded()) {
            RecyclerView recyclerView = this.cardsRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardsRecyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        setRefreshButtonEnabled(true);
    }

    @Override // com.studiolaganne.lengendarylens.OnCardAddToDeckListener
    public void onAddToDeck(MTFullCard card, String listType) {
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(listType, "listType");
        MythicPlusBottomSheetFragment parentMythicPlus = getParentMythicPlus();
        if (parentMythicPlus == null || (callback = parentMythicPlus.getCallback()) == null) {
            return;
        }
        callback.onAddCardToDeck(card, listType);
    }

    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
    public void onCardLongPress(MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(card, "card");
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onCardSelectionToggle(MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(card, "card");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.deckId = arguments.getInt("deckId", -1);
            this.mainListId = arguments.getInt("mainListId", -1);
            this.sideboardListId = arguments.getInt("sideboardListId", -1);
            this.maybeboardListId = arguments.getInt("maybeboardListId", -1);
        }
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MythicPlusRecommendationsFragment.onCreate$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pagerActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mythic_plus_recommendations, container, false);
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(MTFullCard card, int index) {
        Context context;
        ActivityResultLauncher<Intent> activityResultLauncher;
        Object next;
        String string;
        Integer total;
        Intrinsics.checkNotNullParameter(card, "card");
        if (this.displayedCards.isEmpty() || (context = getContext()) == null) {
            return;
        }
        Iterator it = CollectionsKt.plus((Collection) BROAD_CATEGORIES, (Iterable) TYPE_CATEGORIES).iterator();
        while (true) {
            activityResultLauncher = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((CategoryDef) next).getKey(), this.selectedCategoryKey)) {
                    break;
                }
            }
        }
        CategoryDef categoryDef = (CategoryDef) next;
        if (categoryDef == null || (string = getString(categoryDef.getLabelResId())) == null) {
            string = "";
        }
        CategoryPageState categoryPageState = this.categoryPageStates.get(this.selectedCategoryKey);
        Gson gson = new Gson();
        Intent intent = new Intent(context, (Class<?>) CardRecommendationsPagerActivity.class);
        intent.putExtra("cards", gson.toJson(this.displayedCards));
        intent.putExtra("startIndex", index);
        intent.putExtra("deckId", this.deckId);
        intent.putExtra("mainListId", this.mainListId);
        intent.putExtra("sideboardListId", this.sideboardListId);
        intent.putExtra("maybeboardListId", this.maybeboardListId);
        intent.putExtra("addedCardIds", gson.toJson(CollectionsKt.toList(this.addedCardIds)));
        intent.putExtra("categoryLabel", string);
        intent.putExtra("categoryKey", this.selectedCategoryKey);
        intent.putExtra("currentPage", categoryPageState != null ? categoryPageState.getCurrentPage() : 1);
        intent.putExtra("hasMorePages", categoryPageState != null ? categoryPageState.getHasMorePages() : false);
        intent.putExtra("totalCards", (categoryPageState == null || (total = categoryPageState.getTotal()) == null) ? -1 : total.intValue());
        intent.putExtra("fromCollection", this.fromCollection);
        intent.putExtra(AndroidContextPlugin.LOCALE_KEY, this.selectedLocale);
        ActivityResultLauncher<Intent> activityResultLauncher2 = this.pagerActivityLauncher;
        if (activityResultLauncher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerActivityLauncher");
        } else {
            activityResultLauncher = activityResultLauncher2;
        }
        activityResultLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
        Intrinsics.checkNotNullParameter(card, "card");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.isLoading = false;
        View viewFindViewById = view.findViewById(R.id.broadCategoryRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.broadCategoryRow = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.typeCategoryScroll);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.typeCategoryScroll = (HorizontalScrollView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.typeCategoryRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.typeCategoryRow = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.scrollHintButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.scrollHintButton = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.gridToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.gridToggle = (ImageView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.cardsRecyclerView = (RecyclerView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.loadingIndicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.loadingIndicator = (ProgressBar) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.loadingFooter);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.loadingFooter = (ProgressBar) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.refreshButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.refreshButtonLayout = viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.fromCollectionCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.fromCollectionCheckBox = (CheckBox) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.languageIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.languageIcon = (TextView) viewFindViewById11;
        this.selectedLocale = getDefaultLocale();
        setRefreshButtonEnabled(false);
        View view2 = this.refreshButtonLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButtonLayout");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusRecommendationsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MythicPlusRecommendationsFragment.onViewCreated$lambda$0(this.f$0, view3);
            }
        });
        setupCategories();
        setupGridToggle();
        setupScrollHint();
        setupRecyclerView();
        setupFromCollection();
        setupLanguageIcon();
        if (this.recommendResponse != null || this.isLoading) {
            return;
        }
        loadRecommendations();
    }
}
