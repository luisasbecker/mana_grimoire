package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MythicPlusSearchFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 \u0092\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0092\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u000e\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0010J&\u0010G\u001a\u0004\u0018\u00010+2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010N\u001a\u00020@H\u0002J\b\u0010O\u001a\u00020@H\u0002J\b\u0010P\u001a\u00020@H\u0002J\b\u0010Q\u001a\u00020@H\u0002J\u0010\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020\u0010H\u0002J\u0010\u0010T\u001a\u00020@2\u0006\u0010S\u001a\u00020\u0010H\u0002J\b\u0010U\u001a\u00020@H\u0002J\u0010\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010Y\u001a\u00020@H\u0002J\b\u0010Z\u001a\u00020@H\u0002J\b\u0010[\u001a\u00020@H\u0002J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0010H\u0002J\u0010\u0010_\u001a\u00020@2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010`\u001a\u00020@H\u0002J\u0010\u0010a\u001a\u00020\u001a2\u0006\u0010b\u001a\u00020cH\u0002J\u0010\u0010d\u001a\u00020\u00102\u0006\u0010b\u001a\u00020cH\u0002J \u0010e\u001a\u00020@2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020h0g2\b\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0016\u0010k\u001a\u00020@2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gH\u0002J\u0010\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u00020\u001aH\u0002J\u0010\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020]H\u0002J&\u0010p\u001a\u00020@2\u0006\u0010H\u001a\u00020I2\u0006\u0010q\u001a\u00020\u00102\f\u0010r\u001a\b\u0012\u0004\u0012\u00020@0sH\u0002J\u001c\u0010t\u001a\u00020@2\b\b\u0002\u0010u\u001a\u00020\u001a2\b\b\u0002\u0010v\u001a\u00020\u001aH\u0002J\b\u0010w\u001a\u00020@H\u0002J\u0010\u0010x\u001a\u00020@2\u0006\u0010y\u001a\u00020\u0010H\u0016J\u0018\u0010x\u001a\u00020@2\u0006\u0010y\u001a\u00020\u00102\b\u0010v\u001a\u0004\u0018\u00010\u0010J\b\u0010z\u001a\u00020@H\u0002J\u0010\u0010{\u001a\u00020@2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010|\u001a\u00020@H\u0002J\u0018\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J\t\u0010\u0080\u0001\u001a\u00020@H\u0002J\t\u0010\u0081\u0001\u001a\u00020@H\u0002J\t\u0010\u0082\u0001\u001a\u00020@H\u0002J\u001b\u0010\u0083\u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0016J\u001b\u0010\u0086\u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0016J\u001b\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0016J$\u0010\u0089\u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\nH\u0016J\u001b\u0010\u008b\u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u008c\u0001\u001a\u00020\u0010H\u0016J!\u0010\u008d\u0001\u001a\u00020@2\u0006\u0010F\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u0010J\u000f\u0010\u0090\u0001\u001a\u00020@2\u0006\u0010v\u001a\u00020\u0010J\t\u0010\u0091\u0001\u001a\u00020@H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusSearchFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "<init>", "()V", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "addedCardIds", "", "", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "tabManager", "Lcom/studiolaganne/lengendarylens/SearchTabManager;", "currentCall", "Lretrofit2/Call;", "Lcom/studiolaganne/lengendarylens/MTCardsResponse;", "pendingFillGap", "fromCollection", "", "pagerActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "parentMythicPlus", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "getParentMythicPlus", "()Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "allowRelevanceSort", "getAllowRelevanceSort", "()Z", "tabStripContainer", "Landroid/widget/LinearLayout;", "tabStripLayout", "tabStripScroll", "Landroid/widget/HorizontalScrollView;", "tabStripDivider", "Landroid/view/View;", "addTabButton", "Landroid/widget/TextView;", "searchEditText", "Landroid/widget/EditText;", "searchButton", "filterButton", "filterPillsRow", "pillsContainer", "numResultsText", "sortButton", "gridToggle", "Landroid/widget/ImageView;", "resultsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyStateText", "loadingIndicator", "Landroid/widget/ProgressBar;", "fromCollectionCheckBox", "Landroid/widget/CheckBox;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "syncPagerStateBack", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "markCardAsAdded", "oracleId", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupFromCollection", "setupTabStrip", "refreshTabStrip", "startNewSearch", "switchToTab", "tabId", "closeTab", "saveCurrentTabState", "restoreTabState", "tab", "Lcom/studiolaganne/lengendarylens/SearchTab;", "restoreActiveTab", "setupSearchInput", "performSearch", "buildCurrentParams", "Lcom/studiolaganne/lengendarylens/SearchTabParams;", SearchIntents.EXTRA_QUERY, "executeSearch", "loadNextPage", "isSimpleNameSearch", "searchElement", "Lcom/studiolaganne/lengendarylens/SearchElement;", "extractNameQuery", "updateResults", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "pagination", "Lcom/studiolaganne/lengendarylens/MTPagination;", "setupRecyclerViewForCurrentLayout", "showLoading", "loading", "updateSmartPills", NativeProtocol.WEB_DIALOG_PARAMS, "addPill", "text", "onRemove", "Lkotlin/Function0;", "removeSmartFilter", "similarTo", "fillGap", "setupFilterButton", "onFiltersApplied", "scryfallQuery", "setupSortButton", "sanitizeTabSort", "showSortPopup", "selectSort", "orderBy", "orderDirection", "setupGridToggle", "updateGridIcon", "setupPagination", "onMTFullCardClick", "card", FirebaseAnalytics.Param.INDEX, "onCardLongPress", "position", "onCardSelectionToggle", "onQuantityChange", "newQuantity", "onAddToDeck", "listType", "openSearchWithSimilar", "mode", "cardName", "openSearchWithGap", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusSearchFragment extends Fragment implements OnMTFullCardClickListener, OnCardLongPressListener, OnCardSelectionListener, OnCardAddToDeckListener, UnifiedFiltersListener {
    private static final String TAG = "MythicPlusSearchFrag";
    private TextView addTabButton;
    private Call<MTCardsResponse> currentCall;
    private TextView emptyStateText;
    private TextView filterButton;
    private LinearLayout filterPillsRow;
    private boolean fromCollection;
    private CheckBox fromCollectionCheckBox;
    private ImageView gridToggle;
    private ProgressBar loadingIndicator;
    private TextView numResultsText;
    private ActivityResultLauncher<Intent> pagerActivityLauncher;
    private String pendingFillGap;
    private LinearLayout pillsContainer;
    private RecyclerView resultsRecyclerView;
    private TextView searchButton;
    private EditText searchEditText;
    private TextView sortButton;
    private SearchTabManager tabManager;
    private LinearLayout tabStripContainer;
    private View tabStripDivider;
    private LinearLayout tabStripLayout;
    private HorizontalScrollView tabStripScroll;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int deckId = -1;
    private int mainListId = -1;
    private int sideboardListId = -1;
    private int maybeboardListId = -1;
    private final Set<String> addedCardIds = new LinkedHashSet();
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;

    /* JADX INFO: compiled from: MythicPlusSearchFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusSearchFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/studiolaganne/lengendarylens/MythicPlusSearchFragment;", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MythicPlusSearchFragment newInstance(int deckId, int mainListId, int sideboardListId, int maybeboardListId) {
            MythicPlusSearchFragment mythicPlusSearchFragment = new MythicPlusSearchFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("deckId", deckId);
            bundle.putInt("mainListId", mainListId);
            bundle.putInt("sideboardListId", sideboardListId);
            bundle.putInt("maybeboardListId", maybeboardListId);
            mythicPlusSearchFragment.setArguments(bundle);
            return mythicPlusSearchFragment;
        }
    }

    /* JADX INFO: compiled from: MythicPlusSearchFragment.kt */
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

    private final void addPill(LayoutInflater inflater, String text, final Function0<Unit> onRemove) {
        int i = R.layout.search_smart_pill;
        LinearLayout linearLayout = this.pillsContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pillsContainer");
            linearLayout = null;
        }
        View viewInflate = inflater.inflate(i, (ViewGroup) linearLayout, false);
        ((TextView) viewInflate.findViewById(R.id.pillLabel)).setText(text);
        ((TextView) viewInflate.findViewById(R.id.pillClose)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onRemove.invoke();
            }
        });
        LinearLayout linearLayout3 = this.pillsContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pillsContainer");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(viewInflate);
    }

    private final SearchTabParams buildCurrentParams(String query) {
        String fillGap;
        SearchTabParams params;
        SearchTabParams params2;
        SearchTabParams params3;
        SearchTabParams params4;
        SearchTabManager searchTabManager = this.tabManager;
        String similarMode = null;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        String str = query;
        if (StringsKt.isBlank(str)) {
            str = null;
        }
        String str2 = str;
        String similarTo = (activeTab == null || (params4 = activeTab.getParams()) == null) ? null : params4.getSimilarTo();
        String similarToName = (activeTab == null || (params3 = activeTab.getParams()) == null) ? null : params3.getSimilarToName();
        if (activeTab != null && (params2 = activeTab.getParams()) != null) {
            similarMode = params2.getSimilarMode();
        }
        String str3 = similarMode;
        if (activeTab == null || (params = activeTab.getParams()) == null || (fillGap = params.getFillGap()) == null) {
            fillGap = this.pendingFillGap;
        }
        return new SearchTabParams(str2, null, similarTo, similarToName, str3, fillGap, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeTab(String tabId) {
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null) {
            return;
        }
        searchTabManager.closeTab(tabId);
        SearchTab activeTab = searchTabManager.getActiveTab();
        if (activeTab != null) {
            restoreTabState(activeTab);
            if (activeTab.getNeedsRefresh() || activeTab.getCards().isEmpty()) {
                executeSearch(activeTab);
            }
        } else {
            EditText editText = this.searchEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            editText.setText("");
            updateSmartPills(new SearchTabParams(null, null, null, null, null, null, 63, null));
            updateResults(CollectionsKt.emptyList(), null);
        }
        refreshTabStrip();
    }

    private final void executeSearch(final SearchTab tab) {
        String strExtractNameQuery;
        if (!isAdded() || getContext() == null) {
            return;
        }
        sanitizeTabSort(tab);
        Call<MTCardsResponse> call = this.currentCall;
        if (call != null) {
            call.cancel();
        }
        tab.setLoading(true);
        showLoading(true);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
        SearchTabParams params = tab.getParams();
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        String scryfall = params.getScryfall();
        String string = scryfall != null ? StringsKt.trim((CharSequence) scryfall).toString() : null;
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            string = null;
            strExtractNameQuery = null;
        } else {
            SearchElement searchQuery = companion.parseSearchQuery(string);
            if (isSimpleNameSearch(searchQuery)) {
                string = null;
                strExtractNameQuery = extractNameQuery(searchQuery);
            } else {
                strExtractNameQuery = null;
            }
        }
        MTApi mtApi = MTApiKt.getMtApi();
        String orderBy = tab.getOrderBy();
        String orderDirection = Intrinsics.areEqual(tab.getOrderBy(), "relevance") ? null : tab.getOrderDirection();
        Integer numValueOf2 = Integer.valueOf(this.deckId);
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        String similarTo = params.getSimilarTo();
        String similarMode = params.getSimilarMode();
        String fillGap = params.getFillGap();
        Boolean boolValueOf = Boolean.valueOf(this.fromCollection);
        Call<MTCardsResponse> callSearchCards$default = MTApi.searchCards$default(mtApi, string, strExtractNameQuery, 1, 50, null, orderBy, orderDirection, num, true, similarTo, similarMode, fillGap, boolValueOf.booleanValue() ? boolValueOf : null, numValueOf, 16, null);
        this.currentCall = callSearchCards$default;
        callSearchCards$default.enqueue(new Callback<MTCardsResponse>() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment.executeSearch.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardsResponse> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (!MythicPlusSearchFragment.this.isAdded() || call2.isCanceled()) {
                    return;
                }
                tab.setLoading(false);
                tab.setNeedsRefresh(false);
                SearchTabManager searchTabManager = MythicPlusSearchFragment.this.tabManager;
                if (Intrinsics.areEqual(searchTabManager != null ? searchTabManager.getActiveTabId() : null, tab.getId())) {
                    MythicPlusSearchFragment.this.showLoading(false);
                    MythicPlusSearchFragment.this.updateResults(CollectionsKt.emptyList(), null);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardsResponse> call2, Response<MTCardsResponse> response) {
                List<MTFullCard> listEmptyList;
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (MythicPlusSearchFragment.this.isAdded()) {
                    tab.setLoading(false);
                    tab.setNeedsRefresh(false);
                    MTCardsResponse mTCardsResponseBody = response.body();
                    if (mTCardsResponseBody == null || (listEmptyList = mTCardsResponseBody.getCards()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    MTCardsResponse mTCardsResponseBody2 = response.body();
                    MTPagination pagination = mTCardsResponseBody2 != null ? mTCardsResponseBody2.getPagination() : null;
                    tab.getCards().clear();
                    tab.getCards().addAll(listEmptyList);
                    tab.setPagination(pagination);
                    SearchTabManager searchTabManager = MythicPlusSearchFragment.this.tabManager;
                    if (Intrinsics.areEqual(searchTabManager != null ? searchTabManager.getActiveTabId() : null, tab.getId())) {
                        MythicPlusSearchFragment.this.showLoading(false);
                        MythicPlusSearchFragment.this.updateResults(tab.getCards(), pagination);
                    }
                    MythicPlusSearchFragment.this.refreshTabStrip();
                }
            }
        });
    }

    private final String extractNameQuery(SearchElement searchElement) {
        SearchGroup searchGroup = searchElement instanceof SearchGroup ? (SearchGroup) searchElement : null;
        if (searchGroup == null) {
            return "";
        }
        List<SearchElement> elements = searchGroup.getElements();
        ArrayList arrayList = new ArrayList();
        for (Object obj : elements) {
            if (obj instanceof SearchCondition) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return MythicPlusSearchFragment.extractNameQuery$lambda$0((SearchCondition) obj2);
            }
        }, 30, null);
    }

    static final CharSequence extractNameQuery$lambda$0(SearchCondition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }

    private final boolean getAllowRelevanceSort() {
        MythicPlusBottomSheetFragment parentMythicPlus = getParentMythicPlus();
        return parentMythicPlus != null && parentMythicPlus.getIsSmartDeck();
    }

    private final MythicPlusBottomSheetFragment getParentMythicPlus() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MythicPlusBottomSheetFragment) {
            return (MythicPlusBottomSheetFragment) parentFragment;
        }
        return null;
    }

    private final boolean isSimpleNameSearch(SearchElement searchElement) {
        if (!(searchElement instanceof SearchGroup)) {
            return false;
        }
        SearchGroup searchGroup = (SearchGroup) searchElement;
        if (searchGroup.getElements().isEmpty()) {
            return false;
        }
        List<SearchElement> elements = searchGroup.getElements();
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return true;
        }
        for (SearchElement searchElement2 : elements) {
            if (searchElement2 instanceof SearchCondition) {
                SearchCondition searchCondition = (SearchCondition) searchElement2;
                if (searchCondition.getKeyword() != SearchKeyword.NAME || !searchCondition.getInclude()) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage() {
        final SearchTab activeTab;
        MTPagination pagination;
        String strExtractNameQuery;
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null || activeTab.isLoading() || (pagination = activeTab.getPagination()) == null || !Intrinsics.areEqual((Object) pagination.getHas_next(), (Object) true)) {
            return;
        }
        int page = pagination.getPage() + 1;
        activeTab.setLoading(true);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
        SearchTabParams params = activeTab.getParams();
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        String scryfall = params.getScryfall();
        String string = scryfall != null ? StringsKt.trim((CharSequence) scryfall).toString() : null;
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            string = null;
            strExtractNameQuery = null;
        } else {
            SearchElement searchQuery = companion.parseSearchQuery(string);
            if (isSimpleNameSearch(searchQuery)) {
                string = null;
                strExtractNameQuery = extractNameQuery(searchQuery);
            } else {
                strExtractNameQuery = null;
            }
        }
        MTApi mtApi = MTApiKt.getMtApi();
        Integer numValueOf2 = Integer.valueOf(page);
        String orderBy = activeTab.getOrderBy();
        String orderDirection = Intrinsics.areEqual(activeTab.getOrderBy(), "relevance") ? null : activeTab.getOrderDirection();
        Integer numValueOf3 = Integer.valueOf(this.deckId);
        Integer num = numValueOf3.intValue() > 0 ? numValueOf3 : null;
        String similarTo = params.getSimilarTo();
        String similarMode = params.getSimilarMode();
        String fillGap = params.getFillGap();
        Boolean boolValueOf = Boolean.valueOf(this.fromCollection);
        Call<MTCardsResponse> callSearchCards$default = MTApi.searchCards$default(mtApi, string, strExtractNameQuery, numValueOf2, 50, null, orderBy, orderDirection, num, true, similarTo, similarMode, fillGap, boolValueOf.booleanValue() ? boolValueOf : null, numValueOf, 16, null);
        this.currentCall = callSearchCards$default;
        callSearchCards$default.enqueue(new Callback<MTCardsResponse>() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment.loadNextPage.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardsResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (!MythicPlusSearchFragment.this.isAdded() || call.isCanceled()) {
                    return;
                }
                activeTab.setLoading(false);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardsResponse> call, Response<MTCardsResponse> response) {
                List<MTFullCard> listEmptyList;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (MythicPlusSearchFragment.this.isAdded()) {
                    activeTab.setLoading(false);
                    MTCardsResponse mTCardsResponseBody = response.body();
                    if (mTCardsResponseBody == null || (listEmptyList = mTCardsResponseBody.getCards()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    MTCardsResponse mTCardsResponseBody2 = response.body();
                    MTPagination pagination2 = mTCardsResponseBody2 != null ? mTCardsResponseBody2.getPagination() : null;
                    activeTab.getCards().addAll(listEmptyList);
                    activeTab.setPagination(pagination2);
                    SearchTabManager searchTabManager2 = MythicPlusSearchFragment.this.tabManager;
                    if (Intrinsics.areEqual(searchTabManager2 != null ? searchTabManager2.getActiveTabId() : null, activeTab.getId())) {
                        MythicPlusSearchFragment.this.updateResults(activeTab.getCards(), pagination2);
                    }
                }
            }
        });
    }

    static final void onCreate$lambda$1(MythicPlusSearchFragment mythicPlusSearchFragment, ActivityResult result) {
        Intent data;
        MythicPlusBottomSheetFragment parentMythicPlus;
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        boolean booleanExtra = data.getBooleanExtra("deckChanged", false);
        try {
            Type type = new TypeToken<List<? extends String>>() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$onCreate$2$type$1
            }.getType();
            Gson gson = new Gson();
            String stringExtra = data.getStringExtra("newlyAddedOracleIds");
            if (stringExtra == null) {
                stringExtra = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            List listEmptyList = (List) gson.fromJson(stringExtra, type);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                mythicPlusSearchFragment.markCardAsAdded((String) it.next());
            }
            if (booleanExtra && (parentMythicPlus = mythicPlusSearchFragment.getParentMythicPlus()) != null && (callback = parentMythicPlus.getCallback()) != null) {
                callback.onDeckChanged();
            }
        } catch (Exception unused) {
        }
        mythicPlusSearchFragment.syncPagerStateBack(data);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void performSearch() {
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null) {
            return;
        }
        SearchTabParams searchTabParamsBuildCurrentParams = buildCurrentParams(string);
        if (searchTabParamsBuildCurrentParams.isEmpty()) {
            return;
        }
        this.pendingFillGap = null;
        String activeTabId = searchTabManager.getActiveTabId();
        if (activeTabId != null) {
            List<SearchTab> tabs = searchTabManager.getTabs();
            if ((tabs instanceof Collection) && tabs.isEmpty()) {
                executeSearch(SearchTabManager.createTab$default(searchTabManager, searchTabParamsBuildCurrentParams, false, 2, null));
            } else {
                Iterator<T> it = tabs.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((SearchTab) it.next()).getId(), activeTabId)) {
                        searchTabManager.updateTab(activeTabId, searchTabParamsBuildCurrentParams);
                        SearchTab activeTab = searchTabManager.getActiveTab();
                        if (activeTab == null) {
                            return;
                        }
                        activeTab.getCards().clear();
                        activeTab.setPagination(null);
                        executeSearch(activeTab);
                    }
                }
                executeSearch(SearchTabManager.createTab$default(searchTabManager, searchTabParamsBuildCurrentParams, false, 2, null));
            }
        }
        refreshTabStrip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshTabStrip() {
        HorizontalScrollView horizontalScrollView;
        View view;
        final SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null) {
            return;
        }
        LinearLayout linearLayout = this.tabStripLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabStripLayout");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        boolean zIsEmpty = searchTabManager.getTabs().isEmpty();
        LinearLayout linearLayout2 = this.tabStripContainer;
        if (zIsEmpty) {
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabStripContainer");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            View view2 = this.tabStripDivider;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabStripDivider");
                view = null;
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabStripContainer");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        View view3 = this.tabStripDivider;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabStripDivider");
            view3 = null;
        }
        view3.setVisibility(0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(requireContext());
        int color = ContextCompat.getColor(requireContext(), R.color.mythic_plus);
        final String activeTabId = searchTabManager.getActiveTabId();
        for (final SearchTab searchTab : searchTabManager.getTabs()) {
            int i = R.layout.search_tab_item;
            LinearLayout linearLayout3 = this.tabStripLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabStripLayout");
                linearLayout3 = null;
            }
            View viewInflate = layoutInflaterFrom.inflate(i, (ViewGroup) linearLayout3, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tabLabel);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tabCount);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tabClose);
            LinearLayout linearLayout4 = (LinearLayout) viewInflate.findViewById(R.id.tabRoot);
            textView.setText(searchTab.getLabel());
            if (Intrinsics.areEqual(searchTab.getId(), activeTabId)) {
                textView.setTextColor(color);
                linearLayout4.setBackgroundResource(R.drawable.background_box_selected_with_line_small);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        this.f$0.closeTab(searchTab.getId());
                    }
                });
            } else {
                textView.setTextColor(-5592406);
                linearLayout4.setBackgroundResource(R.drawable.background_box_mythic_with_line_small);
                textView3.setVisibility(8);
            }
            MTPagination pagination = searchTab.getPagination();
            if ((pagination != null ? pagination.getTotal() : null) != null) {
                Integer total = pagination.getTotal();
                Intrinsics.checkNotNull(total);
                if (total.intValue() > 0) {
                    textView2.setText("(" + pagination.getTotal() + ")");
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            }
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.switchToTab(searchTab.getId());
                }
            });
            LinearLayout linearLayout5 = this.tabStripLayout;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabStripLayout");
                linearLayout5 = null;
            }
            linearLayout5.addView(viewInflate);
        }
        HorizontalScrollView horizontalScrollView2 = this.tabStripScroll;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabStripScroll");
            horizontalScrollView = null;
        } else {
            horizontalScrollView = horizontalScrollView2;
        }
        horizontalScrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MythicPlusSearchFragment.refreshTabStrip$lambda$2(searchTabManager, this, activeTabId);
            }
        });
    }

    static final void refreshTabStrip$lambda$2(SearchTabManager searchTabManager, MythicPlusSearchFragment mythicPlusSearchFragment, String str) {
        Iterator<SearchTab> it = searchTabManager.getTabs().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), str)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            LinearLayout linearLayout = mythicPlusSearchFragment.tabStripLayout;
            HorizontalScrollView horizontalScrollView = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabStripLayout");
                linearLayout = null;
            }
            if (i < linearLayout.getChildCount()) {
                LinearLayout linearLayout2 = mythicPlusSearchFragment.tabStripLayout;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabStripLayout");
                    linearLayout2 = null;
                }
                View childAt = linearLayout2.getChildAt(i);
                HorizontalScrollView horizontalScrollView2 = mythicPlusSearchFragment.tabStripScroll;
                if (horizontalScrollView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabStripScroll");
                } else {
                    horizontalScrollView = horizontalScrollView2;
                }
                horizontalScrollView.smoothScrollTo(childAt.getLeft() - 20, 0);
            }
        }
    }

    private final void removeSmartFilter(boolean similarTo, boolean fillGap) {
        SearchTab activeTab;
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null) {
            return;
        }
        if (similarTo) {
            activeTab.getParams().setSimilarTo(null);
            activeTab.getParams().setSimilarToName(null);
            activeTab.getParams().setSimilarMode(null);
        }
        if (fillGap) {
            activeTab.getParams().setFillGap(null);
        }
        activeTab.setLabel(SearchTabManager.INSTANCE.buildLabel(activeTab.getParams()));
        SearchTabManager searchTabManager2 = this.tabManager;
        if (searchTabManager2 != null) {
            searchTabManager2.save();
        }
        updateSmartPills(activeTab.getParams());
        refreshTabStrip();
        if (activeTab.getParams().isEmpty()) {
            updateResults(CollectionsKt.emptyList(), null);
        } else {
            activeTab.getCards().clear();
            executeSearch(activeTab);
        }
    }

    static /* synthetic */ void removeSmartFilter$default(MythicPlusSearchFragment mythicPlusSearchFragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        mythicPlusSearchFragment.removeSmartFilter(z, z2);
    }

    private final void restoreActiveTab() {
        SearchTabManager searchTabManager = this.tabManager;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        if (activeTab == null) {
            refreshTabStrip();
            return;
        }
        sanitizeTabSort(activeTab);
        restoreTabState(activeTab);
        refreshTabStrip();
        if (activeTab.getNeedsRefresh() || activeTab.getCards().isEmpty()) {
            executeSearch(activeTab);
        }
    }

    private final void restoreTabState(final SearchTab tab) {
        EditText editText = this.searchEditText;
        RecyclerView recyclerView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String scryfall = tab.getParams().getScryfall();
        if (scryfall == null && (scryfall = tab.getParams().getName()) == null) {
            scryfall = "";
        }
        editText.setText(scryfall);
        updateSmartPills(tab.getParams());
        if (tab.getCards().isEmpty()) {
            updateResults(CollectionsKt.emptyList(), null);
            return;
        }
        updateResults(tab.getCards(), tab.getPagination());
        RecyclerView recyclerView2 = this.resultsRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                MythicPlusSearchFragment.restoreTabState$lambda$0(this.f$0, tab);
            }
        });
    }

    static final void restoreTabState$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment, SearchTab searchTab) {
        RecyclerView recyclerView = mythicPlusSearchFragment.resultsRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPosition(searchTab.getScrollPosition());
        }
    }

    private final void sanitizeTabSort(SearchTab tab) {
        if (getAllowRelevanceSort() || !Intrinsics.areEqual(tab.getOrderBy(), "relevance")) {
            return;
        }
        tab.setOrderBy("name");
        tab.setOrderDirection("asc");
    }

    private final void saveCurrentTabState() {
        SearchTab activeTab;
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null) {
            return;
        }
        RecyclerView recyclerView = this.resultsRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        activeTab.setScrollPosition(linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0);
    }

    private final void selectSort(String orderBy, String orderDirection) {
        SearchTab activeTab;
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null) {
            return;
        }
        activeTab.setOrderBy(orderBy);
        activeTab.setOrderDirection(orderDirection);
        SearchTabManager searchTabManager2 = this.tabManager;
        if (searchTabManager2 != null) {
            searchTabManager2.save();
        }
        activeTab.getCards().clear();
        executeSearch(activeTab);
    }

    private final void setupFilterButton() {
        TextView textView = this.filterButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterButton");
            textView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.setupFilterButton$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupFilterButton$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment) {
        SearchTabParams params;
        if (mythicPlusSearchFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        EditText editText = mythicPlusSearchFragment.searchEditText;
        String fillGap = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        SearchTabManager searchTabManager = mythicPlusSearchFragment.tabManager;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        Fragment parentFragment = mythicPlusSearchFragment.getParentFragment();
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = parentFragment instanceof MythicPlusBottomSheetFragment ? (MythicPlusBottomSheetFragment) parentFragment : null;
        UnifiedFiltersBottomSheetFragment.Builder currentFilters = new UnifiedFiltersBottomSheetFragment.Builder().setMode(FilterMode.SEARCH).setCurrentFilters(string);
        if (activeTab != null && (params = activeTab.getParams()) != null) {
            fillGap = params.getFillGap();
        }
        UnifiedFiltersBottomSheetFragment.Builder listener = currentFilters.setFillGap(fillGap).setSmartDeck(mythicPlusBottomSheetFragment != null ? mythicPlusBottomSheetFragment.getIsSmartDeck() : true).setListener(mythicPlusSearchFragment);
        FragmentManager childFragmentManager = mythicPlusSearchFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        listener.show(childFragmentManager, "UnifiedFiltersSearch");
        return Unit.INSTANCE;
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
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MythicPlusSearchFragment.setupFromCollection$lambda$0(this.f$0, compoundButton, z);
            }
        });
    }

    static final void setupFromCollection$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment, CompoundButton compoundButton, boolean z) {
        SearchTab activeTab;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        mythicPlusSearchFragment.fromCollection = z;
        SearchTabManager searchTabManager = mythicPlusSearchFragment.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null) {
            return;
        }
        activeTab.getCards().clear();
        activeTab.setPagination(null);
        mythicPlusSearchFragment.executeSearch(activeTab);
    }

    private final void setupGridToggle() {
        updateGridIcon();
        ImageView imageView = this.gridToggle;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.setupGridToggle$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupGridToggle$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment) {
        CardsLayout cardsLayout;
        Context contextRequireContext = mythicPlusSearchFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        int i = WhenMappings.$EnumSwitchMapping$0[mythicPlusSearchFragment.currentLayout.ordinal()];
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
        mythicPlusSearchFragment.currentLayout = cardsLayout;
        preferencesManager.setPreferredCardLayout(cardsLayout);
        mythicPlusSearchFragment.updateGridIcon();
        SearchTabManager searchTabManager = mythicPlusSearchFragment.tabManager;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        if (activeTab != null && !activeTab.getCards().isEmpty()) {
            mythicPlusSearchFragment.setupRecyclerViewForCurrentLayout(activeTab.getCards());
        }
        return Unit.INSTANCE;
    }

    private final void setupPagination() {
        RecyclerView recyclerView = this.resultsRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment.setupPagination.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                RecyclerView.LayoutManager layoutManager;
                int iFindLastVisibleItemPosition;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                if (dy > 0 && (layoutManager = recyclerView2.getLayoutManager()) != null) {
                    int itemCount = layoutManager.getItemCount();
                    if (layoutManager instanceof GridLayoutManager) {
                        iFindLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (!(layoutManager instanceof LinearLayoutManager)) {
                        return;
                    } else {
                        iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if (iFindLastVisibleItemPosition >= itemCount - 6) {
                        MythicPlusSearchFragment.this.loadNextPage();
                    }
                }
            }
        });
    }

    private final void setupRecyclerViewForCurrentLayout(List<MTFullCard> cards) {
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(cards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 1) {
            ImageView imageView = this.gridToggle;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.grid_2);
            RecyclerView recyclerView = this.resultsRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            RecyclerView recyclerView2 = this.resultsRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, CardSetsManager.INSTANCE.getCardSets(), false, this, this, this, this, this.addedCardIds));
            return;
        }
        if (i == 2) {
            ImageView imageView2 = this.gridToggle;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.grid_3);
            RecyclerView recyclerView3 = this.resultsRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            RecyclerView recyclerView4 = this.resultsRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
                recyclerView4 = null;
            }
            recyclerView4.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, CardSetsManager.INSTANCE.getCardSets(), true, this, this, this, this, this.addedCardIds));
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ImageView imageView3 = this.gridToggle;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.view_list);
        RecyclerView recyclerView5 = this.resultsRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView6 = this.resultsRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, this, this, this, this.addedCardIds));
    }

    private final void setupSearchInput() {
        EditText editText = this.searchEditText;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return MythicPlusSearchFragment.setupSearchInput$lambda$0(this.f$0, textView2, i, keyEvent);
            }
        });
        TextView textView2 = this.searchButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchButton");
        } else {
            textView = textView2;
        }
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.setupSearchInput$lambda$1(this.f$0);
            }
        });
    }

    static final boolean setupSearchInput$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        mythicPlusSearchFragment.performSearch();
        return true;
    }

    static final Unit setupSearchInput$lambda$1(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.performSearch();
        return Unit.INSTANCE;
    }

    private final void setupSortButton() {
        TextView textView = this.sortButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            textView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.setupSortButton$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupSortButton$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.showSortPopup();
        return Unit.INSTANCE;
    }

    private final void setupTabStrip() {
        TextView textView = this.addTabButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addTabButton");
            textView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.setupTabStrip$lambda$0(this.f$0);
            }
        });
        refreshTabStrip();
    }

    static final Unit setupTabStrip$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.startNewSearch();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean loading) {
        ProgressBar progressBar = this.loadingIndicator;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        if (loading) {
            TextView textView2 = this.emptyStateText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyStateText");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        }
    }

    private final void showSortPopup() {
        String orderBy;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SelectionPopupMenu selectionPopupMenu = new SelectionPopupMenu(contextRequireContext);
        SearchTabManager searchTabManager = this.tabManager;
        TextView textView = null;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        String str = getAllowRelevanceSort() ? "relevance" : "name";
        if (activeTab == null || (orderBy = activeTab.getOrderBy()) == null) {
            orderBy = str;
        }
        if (getAllowRelevanceSort()) {
            String string = getString(R.string.mythic_search_sort_relevance);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            selectionPopupMenu.addItem(string, ContextCompat.getDrawable(contextRequireContext, R.drawable.mythic_plus_small), Integer.valueOf(ContextCompat.getColor(contextRequireContext, R.color.mythic_plus)), Intrinsics.areEqual(orderBy, "relevance"), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MythicPlusSearchFragment.showSortPopup$lambda$0(this.f$0);
                }
            });
            selectionPopupMenu.addDivider();
        }
        String string2 = getString(R.string.sort_name);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string2, null, null, Intrinsics.areEqual(orderBy, "name"), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.showSortPopup$lambda$1(this.f$0);
            }
        }, 6, null);
        String string3 = getString(R.string.sort_mana_value);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string3, null, null, Intrinsics.areEqual(orderBy, "cmc"), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.showSortPopup$lambda$2(this.f$0);
            }
        }, 6, null);
        String string4 = getString(R.string.sort_rarity);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string4, null, null, Intrinsics.areEqual(orderBy, "rarity"), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.showSortPopup$lambda$3(this.f$0);
            }
        }, 6, null);
        String string5 = getString(R.string.sort_set_code);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string5, null, null, Intrinsics.areEqual(orderBy, "set"), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.showSortPopup$lambda$4(this.f$0);
            }
        }, 6, null);
        String string6 = getString(R.string.sort_price);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string6, null, null, Intrinsics.areEqual(orderBy, FirebaseAnalytics.Param.PRICE), new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.showSortPopup$lambda$5(this.f$0);
            }
        }, 6, null);
        TextView textView2 = this.sortButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
        } else {
            textView = textView2;
        }
        selectionPopupMenu.show(textView);
    }

    static final Unit showSortPopup$lambda$0(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort("relevance", "desc");
        return Unit.INSTANCE;
    }

    static final Unit showSortPopup$lambda$1(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort("name", "asc");
        return Unit.INSTANCE;
    }

    static final Unit showSortPopup$lambda$2(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort("cmc", "asc");
        return Unit.INSTANCE;
    }

    static final Unit showSortPopup$lambda$3(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort("rarity", "desc");
        return Unit.INSTANCE;
    }

    static final Unit showSortPopup$lambda$4(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort("set", "desc");
        return Unit.INSTANCE;
    }

    static final Unit showSortPopup$lambda$5(MythicPlusSearchFragment mythicPlusSearchFragment) {
        mythicPlusSearchFragment.selectSort(FirebaseAnalytics.Param.PRICE, "asc");
        return Unit.INSTANCE;
    }

    private final void startNewSearch() {
        saveCurrentTabState();
        SearchTabManager searchTabManager = this.tabManager;
        EditText editText = null;
        if (searchTabManager != null) {
            searchTabManager.setActiveTabId(null);
        }
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText2 = null;
        }
        editText2.setText("");
        updateSmartPills(new SearchTabParams(null, null, null, null, null, null, 63, null));
        updateResults(CollectionsKt.emptyList(), null);
        EditText editText3 = this.searchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        } else {
            editText = editText3;
        }
        editText.requestFocus();
        refreshTabStrip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchToTab(String tabId) {
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || Intrinsics.areEqual(searchTabManager.getActiveTabId(), tabId)) {
            return;
        }
        saveCurrentTabState();
        searchTabManager.switchTab(tabId);
        SearchTab activeTab = searchTabManager.getActiveTab();
        if (activeTab == null) {
            return;
        }
        restoreTabState(activeTab);
        refreshTabStrip();
        if (activeTab.getNeedsRefresh() || activeTab.getCards().isEmpty()) {
            executeSearch(activeTab);
        }
    }

    private final void syncPagerStateBack(Intent data) {
        SearchTab activeTab;
        Integer num;
        Integer total;
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null) {
            return;
        }
        int intExtra = data.getIntExtra("updatedPage", -1);
        boolean booleanExtra = data.getBooleanExtra("updatedHasMorePages", false);
        int intExtra2 = data.getIntExtra("updatedTotal", -1);
        String stringExtra = data.getStringExtra("updatedCards");
        try {
            String str = stringExtra;
            if (str != null && !StringsKt.isBlank(str)) {
                List listEmptyList = (List) new Gson().fromJson(stringExtra, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$syncPagerStateBack$type$1
                }.getType());
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                activeTab.getCards().clear();
                activeTab.getCards().addAll(listEmptyList);
            }
            if (intExtra > 0) {
                if (intExtra2 > 0) {
                    total = Integer.valueOf(intExtra2);
                } else {
                    MTPagination pagination = activeTab.getPagination();
                    if (pagination != null) {
                        total = pagination.getTotal();
                    } else {
                        num = null;
                        activeTab.setPagination(new MTPagination(intExtra, null, num, null, Boolean.valueOf(booleanExtra), null, 42, null));
                    }
                }
                num = total;
                activeTab.setPagination(new MTPagination(intExtra, null, num, null, Boolean.valueOf(booleanExtra), null, 42, null));
            }
            SearchTabManager searchTabManager2 = this.tabManager;
            if (Intrinsics.areEqual(searchTabManager2 != null ? searchTabManager2.getActiveTabId() : null, activeTab.getId())) {
                updateResults(activeTab.getCards(), activeTab.getPagination());
            }
        } catch (Exception unused) {
        }
    }

    private final void updateGridIcon() {
        int i;
        ImageView imageView = this.gridToggle;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridToggle");
            imageView = null;
        }
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
        imageView.setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateResults(List<MTFullCard> cards, MTPagination pagination) {
        SearchTabManager searchTabManager;
        SearchTab activeTab;
        Integer total;
        if (isAdded()) {
            int size = (pagination == null || (total = pagination.getTotal()) == null) ? cards.size() : total.intValue();
            TextView textView = this.numResultsText;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numResultsText");
                textView = null;
            }
            textView.setText(size > 0 ? getString(R.string.mythic_search_results_count, Integer.valueOf(size)) : "");
            TextView textView3 = this.emptyStateText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyStateText");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility((cards.isEmpty() && ((searchTabManager = this.tabManager) == null || (activeTab = searchTabManager.getActiveTab()) == null || !activeTab.isLoading())) ? 0 : 8);
            setupRecyclerViewForCurrentLayout(cards);
        }
    }

    private final void updateSmartPills(SearchTabParams params) {
        LinearLayout linearLayout = this.pillsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pillsContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(requireContext());
        String fillGap = params.getFillGap();
        if (fillGap != null && !StringsKt.isBlank(fillGap)) {
            String fillGap2 = params.getFillGap();
            Intrinsics.checkNotNull(fillGap2);
            String strReplace$default = StringsKt.replace$default(fillGap2, "_", " ", false, 4, (Object) null);
            if (strReplace$default.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(strReplace$default.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = strReplace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strReplace$default = sbAppend.append(strSubstring).toString();
            }
            Intrinsics.checkNotNull(layoutInflaterFrom);
            String string = getString(R.string.mythic_search_pill_theme, strReplace$default);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            addPill(layoutInflaterFrom, string, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MythicPlusSearchFragment.updateSmartPills$lambda$1(this.f$0);
                }
            });
        }
        String similarTo = params.getSimilarTo();
        if (similarTo == null || StringsKt.isBlank(similarTo)) {
            return;
        }
        String string2 = Intrinsics.areEqual(params.getSimilarMode(), "deck") ? getString(R.string.mythic_search_pill_played_together) : getString(R.string.mythic_search_pill_similar);
        Intrinsics.checkNotNull(string2);
        String similarToName = params.getSimilarToName();
        if (similarToName == null) {
            similarToName = params.getSimilarTo();
            Intrinsics.checkNotNull(similarToName);
        }
        Intrinsics.checkNotNull(layoutInflaterFrom);
        addPill(layoutInflaterFrom, string2 + ": " + similarToName, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusSearchFragment.updateSmartPills$lambda$2(this.f$0);
            }
        });
    }

    static final Unit updateSmartPills$lambda$1(MythicPlusSearchFragment mythicPlusSearchFragment) {
        removeSmartFilter$default(mythicPlusSearchFragment, false, true, 1, null);
        return Unit.INSTANCE;
    }

    static final Unit updateSmartPills$lambda$2(MythicPlusSearchFragment mythicPlusSearchFragment) {
        removeSmartFilter$default(mythicPlusSearchFragment, true, false, 2, null);
        return Unit.INSTANCE;
    }

    public final void markCardAsAdded(String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        this.addedCardIds.add(oracleId);
        RecyclerView recyclerView = this.resultsRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultsRecyclerView");
            recyclerView = null;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnCardAddToDeckListener
    public void onAddToDeck(MTFullCard card, String listType) {
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(listType, "listType");
        MythicPlusBottomSheetFragment parentMythicPlus = getParentMythicPlus();
        if (parentMythicPlus != null && (callback = parentMythicPlus.getCallback()) != null) {
            callback.onAddCardToDeck(card, listType);
        }
        String oracleid = card.getOracleid();
        if (oracleid != null) {
            this.addedCardIds.add(oracleid);
        }
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
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.MythicPlusSearchFragment$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MythicPlusSearchFragment.onCreate$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pagerActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mythic_plus_search, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Call<MTCardsResponse> call = this.currentCall;
        if (call != null) {
            call.cancel();
        }
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager != null) {
            searchTabManager.save();
        }
        super.onDestroyView();
    }

    @Override // com.studiolaganne.lengendarylens.UnifiedFiltersListener
    public void onFiltersApplied(String scryfallQuery) {
        Intrinsics.checkNotNullParameter(scryfallQuery, "scryfallQuery");
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String str = scryfallQuery;
        editText.setText(str);
        if (StringsKt.isBlank(str)) {
            return;
        }
        performSearch();
    }

    public final void onFiltersApplied(String scryfallQuery, String fillGap) {
        Intrinsics.checkNotNullParameter(scryfallQuery, "scryfallQuery");
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String str = scryfallQuery;
        editText.setText(str);
        SearchTabManager searchTabManager = this.tabManager;
        SearchTab activeTab = searchTabManager != null ? searchTabManager.getActiveTab() : null;
        if (activeTab != null) {
            activeTab.getParams().setFillGap(fillGap);
            activeTab.setLabel(SearchTabManager.INSTANCE.buildLabel(activeTab.getParams()));
            SearchTabManager searchTabManager2 = this.tabManager;
            if (searchTabManager2 != null) {
                searchTabManager2.save();
            }
            updateSmartPills(activeTab.getParams());
            refreshTabStrip();
        } else {
            this.pendingFillGap = fillGap;
            updateSmartPills(new SearchTabParams(StringsKt.isBlank(str) ? null : str, null, null, null, null, fillGap, 30, null));
        }
        performSearch();
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(MTFullCard card, int index) {
        SearchTab activeTab;
        Context context;
        String strExtractNameQuery;
        Integer total;
        Boolean has_next;
        Intrinsics.checkNotNullParameter(card, "card");
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (activeTab = searchTabManager.getActiveTab()) == null || activeTab.getCards().isEmpty() || (context = getContext()) == null) {
            return;
        }
        SearchTabParams params = activeTab.getParams();
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        String scryfall = params.getScryfall();
        ActivityResultLauncher<Intent> activityResultLauncher = null;
        String string = scryfall != null ? StringsKt.trim((CharSequence) scryfall).toString() : null;
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            strExtractNameQuery = null;
            string = null;
        } else {
            SearchElement searchQuery = companion.parseSearchQuery(string);
            if (isSimpleNameSearch(searchQuery)) {
                strExtractNameQuery = extractNameQuery(searchQuery);
                string = null;
            } else {
                strExtractNameQuery = null;
            }
        }
        Gson gson = new Gson();
        Intent intent = new Intent(context, (Class<?>) CardRecommendationsPagerActivity.class);
        intent.putExtra("cards", gson.toJson(activeTab.getCards()));
        intent.putExtra("startIndex", index);
        intent.putExtra("deckId", this.deckId);
        intent.putExtra("mainListId", this.mainListId);
        intent.putExtra("sideboardListId", this.sideboardListId);
        intent.putExtra("maybeboardListId", this.maybeboardListId);
        intent.putExtra("categoryLabel", activeTab.getLabel());
        MTPagination pagination = activeTab.getPagination();
        intent.putExtra("currentPage", pagination != null ? pagination.getPage() : 1);
        MTPagination pagination2 = activeTab.getPagination();
        intent.putExtra("hasMorePages", (pagination2 == null || (has_next = pagination2.getHas_next()) == null) ? false : has_next.booleanValue());
        MTPagination pagination3 = activeTab.getPagination();
        intent.putExtra("totalCards", (pagination3 == null || (total = pagination3.getTotal()) == null) ? -1 : total.intValue());
        intent.putExtra("addedCardIds", gson.toJson(CollectionsKt.toList(this.addedCardIds)));
        intent.putExtra("mode", FirebaseAnalytics.Event.SEARCH);
        intent.putExtra("searchScryfall", string);
        intent.putExtra("searchName", strExtractNameQuery);
        intent.putExtra("searchOrderBy", activeTab.getOrderBy());
        intent.putExtra("searchOrderDirection", Intrinsics.areEqual(activeTab.getOrderBy(), "relevance") ? null : activeTab.getOrderDirection());
        intent.putExtra("searchSimilarTo", params.getSimilarTo());
        intent.putExtra("searchSimilarMode", params.getSimilarMode());
        intent.putExtra("searchFillGap", params.getFillGap());
        intent.putExtra("fromCollection", this.fromCollection);
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
        View viewFindViewById = view.findViewById(R.id.tabStripContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tabStripContainer = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tabStripLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tabStripLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tabStripScroll);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.tabStripScroll = (HorizontalScrollView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tabStripDivider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.tabStripDivider = viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.addTabButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.addTabButton = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.searchEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.searchEditText = (EditText) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.searchButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.searchButton = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.filterButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.filterButton = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.filterPillsRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.filterPillsRow = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.pillsContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.pillsContainer = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.numResultsText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.numResultsText = (TextView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.sortButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.sortButton = (TextView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.gridToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.gridToggle = (ImageView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.resultsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.resultsRecyclerView = (RecyclerView) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.emptyStateText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.emptyStateText = (TextView) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.loadingIndicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.loadingIndicator = (ProgressBar) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.fromCollectionCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.fromCollectionCheckBox = (CheckBox) viewFindViewById17;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.currentLayout = new PreferencesManager(contextRequireContext).getPreferredCardLayout();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        SearchTabManager searchTabManager = new SearchTabManager(contextRequireContext2, this.deckId);
        this.tabManager = searchTabManager;
        searchTabManager.load();
        setupSearchInput();
        setupFilterButton();
        setupSortButton();
        setupGridToggle();
        setupPagination();
        setupTabStrip();
        setupFromCollection();
        restoreActiveTab();
    }

    public final void openSearchWithGap(String fillGap) {
        SearchTab searchTabCreateTab$default;
        Intrinsics.checkNotNullParameter(fillGap, "fillGap");
        SearchTabParams searchTabParams = new SearchTabParams(null, null, null, null, null, fillGap, 31, null);
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (searchTabCreateTab$default = SearchTabManager.createTab$default(searchTabManager, searchTabParams, false, 2, null)) == null) {
            return;
        }
        restoreTabState(searchTabCreateTab$default);
        refreshTabStrip();
        executeSearch(searchTabCreateTab$default);
    }

    public final void openSearchWithSimilar(String oracleId, String mode, String cardName) {
        SearchTab searchTabCreateTab$default;
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        SearchTabParams searchTabParams = new SearchTabParams(null, null, oracleId, cardName, mode, null, 35, null);
        SearchTabManager searchTabManager = this.tabManager;
        if (searchTabManager == null || (searchTabCreateTab$default = SearchTabManager.createTab$default(searchTabManager, searchTabParams, false, 2, null)) == null) {
            return;
        }
        restoreTabState(searchTabCreateTab$default);
        refreshTabStrip();
        executeSearch(searchTabCreateTab$default);
    }
}
