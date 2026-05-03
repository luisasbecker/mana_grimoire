package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.MTEvaluationCardsAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MythicPlusEvaluationsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0010H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\u0018\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0007H\u0016J\u0010\u0010A\u001a\u00020*2\u0006\u0010?\u001a\u00020\u0011H\u0016J\u0018\u0010B\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0017H\u0016J\u000e\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0017J\u0010\u0010F\u001a\u00020*2\u0006\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006J"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusEvaluationsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardClickListener;", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;", "<init>", "()V", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "rankingsResponse", "Lcom/studiolaganne/lengendarylens/MTCardRankingsResponse;", "cardsByCategory", "", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "selectedCategory", "isLoading", "", "actedCardIds", "", "", "summaryLabel", "Landroid/widget/TextView;", "categoryTabsRow", "Landroid/widget/LinearLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadingIndicator", "Landroid/widget/ProgressBar;", "errorText", "categoryTabViews", "", "adapter", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter;", "parentMythicPlus", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "getParentMythicPlus", "()Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupCategoryTabs", "updateCategoryTabSelection", "setupRecyclerView", "updateDisplayedCards", "buildSectionedItems", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item;", "loadCardRankings", "processRankings", "updateSummaryRow", "onEvaluationCardClick", "card", "position", "onRemoveFromDeck", "onMoveCard", "listType", "markCardAsActed", "oracleId", "showCardEvaluationDetail", "dpToPx", "dp", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusEvaluationsFragment extends Fragment implements OnEvaluationCardClickListener, OnEvaluationCardActionListener {
    private static final String TAG = "MythicPlusEvalFragment";
    private MTEvaluationCardsAdapter adapter;
    private LinearLayout categoryTabsRow;
    private TextView errorText;
    private boolean isLoading;
    private ProgressBar loadingIndicator;
    private MTCardRankingsResponse rankingsResponse;
    private RecyclerView recyclerView;
    private TextView summaryLabel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final List<MTCardRankingCategory> CATEGORY_TABS = CollectionsKt.listOf((Object[]) new MTCardRankingCategory[]{MTCardRankingCategory.ALL, MTCardRankingCategory.PROTECTED_STAPLES, MTCardRankingCategory.CORE_SYNERGY, MTCardRankingCategory.SUPPORTING_PIECES, MTCardRankingCategory.OUTLIERS});
    private static final List<MTCardRankingCategory> SECTIONED_CATEGORIES = CollectionsKt.listOf((Object[]) new MTCardRankingCategory[]{MTCardRankingCategory.PROTECTED_STAPLES, MTCardRankingCategory.CORE_SYNERGY, MTCardRankingCategory.SUPPORTING_PIECES, MTCardRankingCategory.OUTLIERS});
    private int deckId = -1;
    private int mainListId = -1;
    private int sideboardListId = -1;
    private int maybeboardListId = -1;
    private Map<MTCardRankingCategory, ? extends List<MTFullCard>> cardsByCategory = MapsKt.emptyMap();
    private MTCardRankingCategory selectedCategory = MTCardRankingCategory.ALL;
    private final Set<String> actedCardIds = new LinkedHashSet();
    private final Map<MTCardRankingCategory, TextView> categoryTabViews = new LinkedHashMap();

    /* JADX INFO: compiled from: MythicPlusEvaluationsFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusEvaluationsFragment$Companion;", "", "<init>", "()V", "TAG", "", "CATEGORY_TABS", "", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "SECTIONED_CATEGORIES", "newInstance", "Lcom/studiolaganne/lengendarylens/MythicPlusEvaluationsFragment;", "deckId", "", "mainListId", "sideboardListId", "maybeboardListId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MythicPlusEvaluationsFragment newInstance(int deckId, int mainListId, int sideboardListId, int maybeboardListId) {
            MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment = new MythicPlusEvaluationsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("deckId", deckId);
            bundle.putInt("mainListId", mainListId);
            bundle.putInt("sideboardListId", sideboardListId);
            bundle.putInt("maybeboardListId", maybeboardListId);
            mythicPlusEvaluationsFragment.setArguments(bundle);
            return mythicPlusEvaluationsFragment;
        }
    }

    private final List<MTEvaluationCardsAdapter.Item> buildSectionedItems() {
        ArrayList arrayList = new ArrayList();
        for (MTCardRankingCategory mTCardRankingCategory : SECTIONED_CATEGORIES) {
            List<MTFullCard> list = this.cardsByCategory.get(mTCardRankingCategory);
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(new MTEvaluationCardsAdapter.Item.SectionHeader(mTCardRankingCategory, list.size()));
                List<MTFullCard> list2 = list;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new MTEvaluationCardsAdapter.Item.Card((MTFullCard) it.next(), mTCardRankingCategory));
                }
                CollectionsKt.addAll(arrayList2, arrayList3);
            }
        }
        return arrayList;
    }

    private final int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MythicPlusBottomSheetFragment getParentMythicPlus() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MythicPlusBottomSheetFragment) {
            return (MythicPlusBottomSheetFragment) parentFragment;
        }
        return null;
    }

    private final void loadCardRankings() {
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
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        TextView textView = this.errorText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
            textView = null;
        }
        textView.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        MTApiKt.getMtApi().getCardRankings(this.deckId, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new Callback<MTCardRankingsResponse>() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment.loadCardRankings.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardRankingsResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (MythicPlusEvaluationsFragment.this.isAdded()) {
                    MythicPlusEvaluationsFragment.this.isLoading = false;
                    ProgressBar progressBar2 = MythicPlusEvaluationsFragment.this.loadingIndicator;
                    TextView textView2 = null;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
                        progressBar2 = null;
                    }
                    progressBar2.setVisibility(8);
                    TextView textView3 = MythicPlusEvaluationsFragment.this.errorText;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorText");
                        textView3 = null;
                    }
                    textView3.setText(MythicPlusEvaluationsFragment.this.getString(R.string.mythic_coming_soon));
                    TextView textView4 = MythicPlusEvaluationsFragment.this.errorText;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorText");
                    } else {
                        textView2 = textView4;
                    }
                    textView2.setVisibility(0);
                    Log.e(MythicPlusEvaluationsFragment.TAG, "Card rankings API failure", t);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardRankingsResponse> call, Response<MTCardRankingsResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (MythicPlusEvaluationsFragment.this.isAdded()) {
                    MythicPlusEvaluationsFragment.this.isLoading = false;
                    ProgressBar progressBar2 = MythicPlusEvaluationsFragment.this.loadingIndicator;
                    TextView textView2 = null;
                    RecyclerView recyclerView2 = null;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
                        progressBar2 = null;
                    }
                    progressBar2.setVisibility(8);
                    boolean zIsSuccessful = response.isSuccessful();
                    MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment = MythicPlusEvaluationsFragment.this;
                    if (zIsSuccessful) {
                        mythicPlusEvaluationsFragment.rankingsResponse = response.body();
                        MythicPlusEvaluationsFragment.this.processRankings();
                        RecyclerView recyclerView3 = MythicPlusEvaluationsFragment.this.recyclerView;
                        if (recyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView2 = recyclerView3;
                        }
                        recyclerView2.setVisibility(0);
                        MythicPlusEvaluationsFragment.this.updateDisplayedCards();
                        return;
                    }
                    TextView textView3 = mythicPlusEvaluationsFragment.errorText;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorText");
                        textView3 = null;
                    }
                    textView3.setText(MythicPlusEvaluationsFragment.this.getString(R.string.mythic_coming_soon));
                    TextView textView4 = MythicPlusEvaluationsFragment.this.errorText;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorText");
                    } else {
                        textView2 = textView4;
                    }
                    textView2.setVisibility(0);
                    Log.e(MythicPlusEvaluationsFragment.TAG, "Card rankings API error: " + response.code());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processRankings() {
        List<MTFullCard> listEmptyList;
        MTCardRankingsResponse mTCardRankingsResponse = this.rankingsResponse;
        if (mTCardRankingsResponse == null || (listEmptyList = mTCardRankingsResponse.getCards()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(listEmptyList), new Function1() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MythicPlusEvaluationsFragment.processRankings$lambda$0((MTFullCard) obj));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceFilter) {
            MTCardRankingCategory mTCardRankingCategoryCategorizeCard = MTRankingHelpers.INSTANCE.categorizeCard(((MTFullCard) obj).getRanking());
            Object obj2 = linkedHashMap.get(mTCardRankingCategoryCategorizeCard);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(mTCardRankingCategoryCategorizeCard, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.cardsByCategory = linkedHashMap;
        updateSummaryRow();
    }

    static final boolean processRankings$lambda$0(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        MTCardRanking ranking = card.getRanking();
        String type_line = card.getType_line();
        boolean z = type_line != null && StringsKt.contains((CharSequence) type_line, (CharSequence) "Land", true);
        if (ranking == null || !ranking.isCommander()) {
            if (!Intrinsics.areEqual(ranking != null ? ranking.getVerdict() : null, "commander") && !z) {
                return true;
            }
        }
        return false;
    }

    private final void setupCategoryTabs() {
        LinearLayout linearLayout = this.categoryTabsRow;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryTabsRow");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        this.categoryTabViews.clear();
        for (final MTCardRankingCategory mTCardRankingCategory : CATEGORY_TABS) {
            TextView textView = new TextView(requireContext());
            textView.setText(getString(MTRankingHelpers.INSTANCE.categoryLabelResId(mTCardRankingCategory)));
            textView.setTextSize(11.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setGravity(17);
            textView.setPadding(dpToPx(10), dpToPx(6), dpToPx(10), dpToPx(6));
            textView.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(dpToPx(3));
            layoutParams.setMarginEnd(dpToPx(3));
            LinearLayout linearLayout2 = this.categoryTabsRow;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryTabsRow");
                linearLayout2 = null;
            }
            linearLayout2.addView(textView, layoutParams);
            this.categoryTabViews.put(mTCardRankingCategory, textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MythicPlusEvaluationsFragment.setupCategoryTabs$lambda$1(this.f$0, mTCardRankingCategory, view);
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MythicPlusEvaluationsFragment.setupCategoryTabs$lambda$2(this.f$0, mTCardRankingCategory, view);
                }
            });
        }
        updateCategoryTabSelection();
    }

    static final void setupCategoryTabs$lambda$1(MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment, MTCardRankingCategory mTCardRankingCategory, View view) {
        mythicPlusEvaluationsFragment.selectedCategory = mTCardRankingCategory;
        mythicPlusEvaluationsFragment.updateCategoryTabSelection();
        mythicPlusEvaluationsFragment.updateDisplayedCards();
    }

    static final boolean setupCategoryTabs$lambda$2(MythicPlusEvaluationsFragment mythicPlusEvaluationsFragment, MTCardRankingCategory mTCardRankingCategory, View view) {
        String string = mythicPlusEvaluationsFragment.getString(MTRankingHelpers.INSTANCE.categoryDescriptionResId(mTCardRankingCategory));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast.makeText(mythicPlusEvaluationsFragment.requireContext(), string, 1).show();
        return true;
    }

    private final void setupRecyclerView() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment.setupRecyclerView.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                MTEvaluationCardsAdapter mTEvaluationCardsAdapter = MythicPlusEvaluationsFragment.this.adapter;
                if (mTEvaluationCardsAdapter != null && mTEvaluationCardsAdapter.isHeaderAt(position)) {
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        this.adapter = new MTEvaluationCardsAdapter(CollectionsKt.emptyList(), this, this);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.adapter);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.studiolaganne.lengendarylens.MythicPlusEvaluationsFragment.setupRecyclerView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                MythicPlusBottomSheetFragment parentMythicPlus;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                if (newState != 0 || recyclerView5.canScrollVertically(-1) || (parentMythicPlus = MythicPlusEvaluationsFragment.this.getParentMythicPlus()) == null) {
                    return;
                }
                parentMythicPlus.expandTabLabels();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                MythicPlusBottomSheetFragment parentMythicPlus;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                if (dy <= 4 || (parentMythicPlus = MythicPlusEvaluationsFragment.this.getParentMythicPlus()) == null) {
                    return;
                }
                parentMythicPlus.collapseTabLabels();
            }
        });
    }

    private final void showCardEvaluationDetail(MTFullCard card) {
        CardEvaluationDetailHelper cardEvaluationDetailHelper = CardEvaluationDetailHelper.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        cardEvaluationDetailHelper.show(fragmentActivityRequireActivity, this.deckId, card);
    }

    private final void updateCategoryTabSelection() {
        Iterator<MTCardRankingCategory> it = CATEGORY_TABS.iterator();
        while (it.hasNext()) {
            MTCardRankingCategory next = it.next();
            TextView textView = this.categoryTabViews.get(next);
            if (textView != null) {
                int size = 0;
                boolean z = next == this.selectedCategory;
                int iCategoryAccent = MTRankingHelpers.INSTANCE.categoryAccent(next);
                if (z) {
                    textView.setTextColor(iCategoryAccent);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(dpToPx(10));
                    gradientDrawable.setStroke(dpToPx(1), Color.argb(64, Color.red(iCategoryAccent), Color.green(iCategoryAccent), Color.blue(iCategoryAccent)));
                    gradientDrawable.setColor(Color.argb(30, Color.red(iCategoryAccent), Color.green(iCategoryAccent), Color.blue(iCategoryAccent)));
                    textView.setBackground(gradientDrawable);
                } else {
                    textView.setTextColor(-5592406);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(dpToPx(10));
                    gradientDrawable2.setStroke(dpToPx(1), 866822826);
                    gradientDrawable2.setColor(0);
                    textView.setBackground(gradientDrawable2);
                }
                MTCardRankingCategory mTCardRankingCategory = MTCardRankingCategory.ALL;
                Map<MTCardRankingCategory, ? extends List<MTFullCard>> map = this.cardsByCategory;
                if (next == mTCardRankingCategory) {
                    Iterator<T> it2 = map.values().iterator();
                    while (it2.hasNext()) {
                        size += ((List) it2.next()).size();
                    }
                } else {
                    List<MTFullCard> list = map.get(next);
                    if (list != null) {
                        size = list.size();
                    }
                }
                String string = getString(MTRankingHelpers.INSTANCE.categoryLabelResId(next));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (size > 0) {
                    string = string + " (" + size + ")";
                }
                textView.setText(string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDisplayedCards() {
        ArrayList arrayListBuildSectionedItems;
        if (this.selectedCategory == MTCardRankingCategory.ALL) {
            arrayListBuildSectionedItems = buildSectionedItems();
        } else {
            List<MTFullCard> listEmptyList = this.cardsByCategory.get(this.selectedCategory);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<MTFullCard> list = listEmptyList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MTEvaluationCardsAdapter.Item.Card((MTFullCard) it.next(), this.selectedCategory));
            }
            arrayListBuildSectionedItems = arrayList;
        }
        MTEvaluationCardsAdapter mTEvaluationCardsAdapter = this.adapter;
        if (mTEvaluationCardsAdapter != null) {
            mTEvaluationCardsAdapter.updateItems(arrayListBuildSectionedItems);
        }
        updateCategoryTabSelection();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSummaryRow() {
        int size;
        MTCardRankingsSummary summary;
        MTCardRankingsSummary summary2;
        MTCardRankingsResponse mTCardRankingsResponse = this.rankingsResponse;
        TextView textView = null;
        if (mTCardRankingsResponse == null || (summary2 = mTCardRankingsResponse.getSummary()) == null) {
            List<MTFullCard> list = this.cardsByCategory.get(MTCardRankingCategory.PROTECTED_STAPLES);
            size = list != null ? list.size() : 0;
        } else {
            Integer numValueOf = Integer.valueOf(summary2.getProtectedCount());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                size = numValueOf.intValue();
            }
        }
        MTCardRankingsResponse mTCardRankingsResponse2 = this.rankingsResponse;
        int redundantCount = (mTCardRankingsResponse2 == null || (summary = mTCardRankingsResponse2.getSummary()) == null) ? 0 : summary.getRedundantCount();
        ArrayList arrayList = new ArrayList();
        if (size > 0) {
            arrayList.add(getString(R.string.eval_protected_count, Integer.valueOf(size)));
        }
        if (redundantCount > 0) {
            arrayList.add(getString(R.string.eval_possibly_redundant_count, Integer.valueOf(redundantCount)));
        }
        boolean zIsEmpty = arrayList.isEmpty();
        TextView textView2 = this.summaryLabel;
        if (zIsEmpty) {
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryLabel");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryLabel");
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.summaryLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryLabel");
        } else {
            textView = textView3;
        }
        textView.setText(CollectionsKt.joinToString$default(arrayList, "  •  ", null, null, 0, null, null, 62, null));
    }

    public final void markCardAsActed(String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        this.actedCardIds.add(oracleId);
        MTEvaluationCardsAdapter mTEvaluationCardsAdapter = this.adapter;
        if (mTEvaluationCardsAdapter != null) {
            mTEvaluationCardsAdapter.setActedCardIds(this.actedCardIds);
        }
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
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mythic_plus_evaluations, container, false);
    }

    @Override // com.studiolaganne.lengendarylens.OnEvaluationCardClickListener
    public void onEvaluationCardClick(MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(card, "card");
        showCardEvaluationDetail(card);
    }

    @Override // com.studiolaganne.lengendarylens.OnEvaluationCardActionListener
    public void onMoveCard(MTFullCard card, String listType) {
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(listType, "listType");
        MythicPlusBottomSheetFragment parentMythicPlus = getParentMythicPlus();
        if (parentMythicPlus == null || (callback = parentMythicPlus.getCallback()) == null) {
            return;
        }
        callback.onMoveCard(card, listType);
    }

    @Override // com.studiolaganne.lengendarylens.OnEvaluationCardActionListener
    public void onRemoveFromDeck(MTFullCard card) {
        MythicPlusCallback callback;
        Intrinsics.checkNotNullParameter(card, "card");
        MythicPlusBottomSheetFragment parentMythicPlus = getParentMythicPlus();
        if (parentMythicPlus == null || (callback = parentMythicPlus.getCallback()) == null) {
            return;
        }
        callback.onRemoveCardFromDeck(card);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.evalSummaryLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.summaryLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.verdictTabsRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.categoryTabsRow = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.evalRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.recyclerView = (RecyclerView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.evalLoadingIndicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.loadingIndicator = (ProgressBar) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.evalErrorText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.errorText = (TextView) viewFindViewById5;
        setupCategoryTabs();
        setupRecyclerView();
        if (this.rankingsResponse != null || this.isLoading) {
            updateDisplayedCards();
        } else {
            loadCardRankings();
        }
    }
}
