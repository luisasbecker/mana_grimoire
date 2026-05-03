package com.studiolaganne.lengendarylens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.muxer.WebmConstants;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.BrowseListCardItem;
import com.studiolaganne.lengendarylens.FilterDialogFragment;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.SearchMode;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentSearchCardsBinding;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: SearchCardsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001qB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000103J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0018\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u000208H\u0016J\u0016\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020<H\u0016J\b\u0010P\u001a\u00020<H\u0016J\u0012\u0010Q\u001a\u00020<2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J&\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u000e\u0010Z\u001a\u00020<2\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020U2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010]\u001a\u00020<H\u0002J\u0010\u0010^\u001a\u00020<2\u0006\u0010_\u001a\u00020\tH\u0002J\u0010\u0010`\u001a\u00020<2\u0006\u0010M\u001a\u00020\u001dH\u0002J\b\u0010a\u001a\u00020<H\u0002J\b\u0010b\u001a\u00020<H\u0002J\b\u0010c\u001a\u00020<H\u0002J\b\u0010d\u001a\u00020<H\u0002J\b\u0010e\u001a\u00020<H\u0002J\u0010\u0010f\u001a\u00020<2\u0006\u0010g\u001a\u00020UH\u0002J\u0010\u0010h\u001a\u00020<2\u0006\u0010g\u001a\u00020UH\u0002J\u0010\u0010i\u001a\u00020<2\u0006\u0010g\u001a\u00020UH\u0002J\b\u0010j\u001a\u00020<H\u0002J\b\u0010k\u001a\u00020<H\u0002J\b\u0010l\u001a\u00020<H\u0002J\u0010\u0010m\u001a\u00020<2\u0006\u0010n\u001a\u00020oH\u0002J\u0010\u0010p\u001a\u00020<2\u0006\u0010J\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010@0@0?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchCardsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "<init>", "()V", "condense", "", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "dbHelpers", "", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "viewModel", "Lcom/studiolaganne/lengendarylens/CardSearchViewModel;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "cards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "currentSearchLanguage", "", "lastQuery", "paused", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentSearchCardsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentSearchCardsBinding;", "pickACardMode", "initialQuery", "overrideLanguage", "searchLanguageFilter", "forceLocalDb", "shouldShowIntFields", "filtersCollapsed", "cardSelectionListener", "Lcom/studiolaganne/lengendarylens/CardSelectionListener;", "currentSortBy", "currentGroupBy", "currentSortDirection", "currentPage", "", "isLoadingMore", "isCollectionSearch", "setCardSelectionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "cardActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onFilterClick", "filter", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "onFilterDelete", "onFilterSubmitButton", "onFiltersApplied", "scryfallQuery", "onMTFullCardClick", "card", FirebaseAnalytics.Param.INDEX, "performSearch", SearchIntents.EXTRA_QUERY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPause", "onResume", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateCondenseSetting", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateCardCount", "showLoadingFooter", "show", "updateFilterListFromQuery", "setupSortAndGroupButtons", "setupSearchSourceToggle", "selectAllCards", "selectMyCollection", "updateCollectionReminderVisibility", "showSortByPopupMenu", "anchor", "showGroupByPopupMenu", "showLanguageFilterPopupMenu", "triggerSearch", "restartSearch", "loadNextPage", "updateUIForMode", "mode", "Lcom/studiolaganne/lengendarylens/SearchMode;", "copyCardNameToClipboard", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchCardsFragment extends Fragment implements OnMTFullCardClickListener, FilterDialogListener, OnFilterClickListener, UnifiedFiltersListener {
    private FragmentSearchCardsBinding _binding;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private CardSelectionListener cardSelectionListener;
    private String currentGroupBy;
    private MTGDBHelper dbHelper;
    private List<MTGDBHelperLocalized> dbHelpers;
    private boolean filtersCollapsed;
    private boolean forceLocalDb;
    private boolean isCollectionSearch;
    private boolean isLoadingMore;
    private boolean paused;
    private boolean pickACardMode;
    private PreferencesManager prefs;
    private RecyclerView recyclerView;
    private Job searchJob;
    private CardSearchViewModel viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private boolean condense = true;
    private List<CardSet> cardSets = CollectionsKt.emptyList();
    private List<MTFullCard> cards = CollectionsKt.emptyList();
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;
    private String currentSearchLanguage = "en";
    private String lastQuery = "";
    private String initialQuery = "";
    private String overrideLanguage = "";
    private String searchLanguageFilter = "";
    private boolean shouldShowIntFields = true;
    private String currentSortBy = "name";
    private String currentSortDirection = "asc";
    private int currentPage = 1;

    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchCardsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/SearchCardsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SearchCardsFragment newInstance() {
            SearchCardsFragment searchCardsFragment = new SearchCardsFragment();
            searchCardsFragment.setArguments(new Bundle());
            return searchCardsFragment;
        }
    }

    /* JADX INFO: compiled from: SearchCardsFragment.kt */
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$loadNextPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$loadNextPage$1", f = "SearchCardsFragment.kt", i = {}, l = {1446}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (SearchCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                CardSearchViewModel cardSearchViewModel = SearchCardsFragment.this.viewModel;
                if (cardSearchViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cardSearchViewModel = null;
                }
                this.label = 1;
                if (cardSearchViewModel.searchCards(SearchCardsFragment.this.lastQuery, SearchCardsFragment.this.currentPage, SearchCardsFragment.this.currentSortBy, SearchCardsFragment.this.currentGroupBy, SearchCardsFragment.this.currentSortDirection, SearchCardsFragment.this.condense, SearchCardsFragment.this.isCollectionSearch, SearchCardsFragment.this.forceLocalDb, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$onFiltersApplied$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$onFiltersApplied$1", f = "SearchCardsFragment.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_TRACK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scryfallQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12391(String str, Continuation<? super C12391> continuation) {
            super(2, continuation);
            this.$scryfallQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new C12391(this.$scryfallQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (SearchCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (SearchCardsFragment.this.performSearch(this.$scryfallQuery, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$23, reason: invalid class name */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$23", f = "SearchCardsFragment.kt", i = {}, l = {1058}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass23 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass23(String str, Continuation<? super AnonymousClass23> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new AnonymousClass23(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass23) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SearchCardsFragment.this.performSearch(this.$query, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$performSearch$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$performSearch$4", f = "SearchCardsFragment.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12424 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12424(String str, Continuation<? super C12424> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new C12424(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12424) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SearchCardsFragment.this.currentPage = 1;
                CardSearchViewModel cardSearchViewModel = SearchCardsFragment.this.viewModel;
                if (cardSearchViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cardSearchViewModel = null;
                }
                this.label = 1;
                if (cardSearchViewModel.searchCards(this.$query, SearchCardsFragment.this.currentPage, SearchCardsFragment.this.currentSortBy, SearchCardsFragment.this.currentGroupBy, SearchCardsFragment.this.currentSortDirection, SearchCardsFragment.this.condense, SearchCardsFragment.this.isCollectionSearch, SearchCardsFragment.this.forceLocalDb, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$restartSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$restartSearch$1", f = "SearchCardsFragment.kt", i = {}, l = {1419}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12431(Continuation<? super C12431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new C12431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (SearchCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                CardSearchViewModel cardSearchViewModel = SearchCardsFragment.this.viewModel;
                if (cardSearchViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cardSearchViewModel = null;
                }
                this.label = 1;
                if (cardSearchViewModel.searchCards(SearchCardsFragment.this.lastQuery, SearchCardsFragment.this.currentPage, SearchCardsFragment.this.currentSortBy, SearchCardsFragment.this.currentGroupBy, SearchCardsFragment.this.currentSortDirection, SearchCardsFragment.this.condense, SearchCardsFragment.this.isCollectionSearch, SearchCardsFragment.this.forceLocalDb, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$triggerSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$triggerSearch$1", f = "SearchCardsFragment.kt", i = {}, l = {1401}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12441(String str, Continuation<? super C12441> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new C12441(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (SearchCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (SearchCardsFragment.this.performSearch(this.$query, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$updateCondenseSetting$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$updateCondenseSetting$1", f = "SearchCardsFragment.kt", i = {}, l = {Videoio.CAP_PROP_XI_CC_MATRIX_00}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12451(Continuation<? super C12451> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchCardsFragment.this.new C12451(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (SearchCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                SearchCardsFragment searchCardsFragment = SearchCardsFragment.this;
                this.label = 1;
                if (searchCardsFragment.performSearch(searchCardsFragment.lastQuery, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$updateFilterListFromQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SearchCardsFragment$updateFilterListFromQuery$1", f = "SearchCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12461(String str, Continuation<? super C12461> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12461 c12461 = SearchCardsFragment.this.new C12461(this.$query, continuation);
            c12461.L$0 = obj;
            return c12461;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (SearchCardsFragment.this.isAdded() && (context = SearchCardsFragment.this.getContext()) != null) {
                SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(this.$query);
                RecyclerView filtersRecyclerView = SearchCardsFragment.this.getBinding().filtersRecyclerView;
                Intrinsics.checkNotNullExpressionValue(filtersRecyclerView, "filtersRecyclerView");
                filtersRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
                boolean z = SearchCardsFragment.this.filtersCollapsed;
                SearchCardsFragment searchCardsFragment = SearchCardsFragment.this;
                if (z) {
                    TextView addFilterButton = searchCardsFragment.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton, "addFilterButton");
                    addFilterButton.setVisibility(4);
                    TextView addFilterTextView = SearchCardsFragment.this.getBinding().addFilterTextView;
                    Intrinsics.checkNotNullExpressionValue(addFilterTextView, "addFilterTextView");
                    addFilterTextView.setVisibility(8);
                    filtersRecyclerView.setAdapter(null);
                    ImageView collapseImageView = SearchCardsFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                    collapseImageView.setVisibility(0);
                    collapseImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.expand_24));
                    ConstraintLayout filterSummaryLayout = SearchCardsFragment.this.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                    filterSummaryLayout.setVisibility(0);
                    SearchGroup searchGroup = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    if (searchGroup != null) {
                        SearchCardsFragment searchCardsFragment2 = SearchCardsFragment.this;
                        TextView filterNumberTextView = searchCardsFragment2.getBinding().filterNumberTextView;
                        Intrinsics.checkNotNullExpressionValue(filterNumberTextView, "filterNumberTextView");
                        filterNumberTextView.setText(String.valueOf(searchGroup.getElements().size()));
                        TextView filterSummaryTextView = searchCardsFragment2.getBinding().filterSummaryTextView;
                        Intrinsics.checkNotNullExpressionValue(filterSummaryTextView, "filterSummaryTextView");
                        filterSummaryTextView.setText(searchCardsFragment2.getResources().getString(R.string.filters_selected));
                    }
                } else {
                    ConstraintLayout filterSummaryLayout2 = searchCardsFragment.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
                    filterSummaryLayout2.setVisibility(8);
                    TextView addFilterButton2 = SearchCardsFragment.this.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton2, "addFilterButton");
                    addFilterButton2.setVisibility(0);
                    ImageView collapseImageView2 = SearchCardsFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView2, "collapseImageView");
                    collapseImageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.collapse));
                    SearchGroup searchGroup2 = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    SearchCardsFragment searchCardsFragment3 = SearchCardsFragment.this;
                    if (searchGroup2 == null) {
                        TextView addFilterTextView2 = searchCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView2, "addFilterTextView");
                        addFilterTextView2.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView3 = searchCardsFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView3, "collapseImageView");
                        collapseImageView3.setVisibility(8);
                    } else if (searchGroup2.getElements().isEmpty()) {
                        TextView addFilterTextView3 = searchCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView3, "addFilterTextView");
                        addFilterTextView3.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView4 = searchCardsFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView4, "collapseImageView");
                        collapseImageView4.setVisibility(8);
                    } else {
                        filtersRecyclerView.setAdapter(new FilterListAdapter(searchCardsFragment3.currentSearchLanguage, searchGroup2, searchCardsFragment3));
                        TextView addFilterTextView4 = searchCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView4, "addFilterTextView");
                        addFilterTextView4.setVisibility(8);
                        if (searchGroup2.getElements().size() > 2) {
                            ImageView collapseImageView5 = searchCardsFragment3.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView5, "collapseImageView");
                            collapseImageView5.setVisibility(0);
                        } else {
                            ImageView collapseImageView6 = searchCardsFragment3.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView6, "collapseImageView");
                            collapseImageView6.setVisibility(8);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    public SearchCardsFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda23
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SearchCardsFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    static final void cardActivityLauncher$lambda$0(final SearchCardsFragment searchCardsFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        Context context = searchCardsFragment.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            if (preferencesManager.getBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, false)) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_card", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda10
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SearchCardsFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(SearchCardsFragment searchCardsFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = searchCardsFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyCardNameToClipboard(MTFullCard card) {
        String printed_name = card.getPrinted_name();
        if (printed_name == null) {
            printed_name = card.getName();
        }
        Object systemService = requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Card name", printed_name));
        Toast.makeText(requireContext(), R.string.card_name_copied, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSearchCardsBinding getBinding() {
        FragmentSearchCardsBinding fragmentSearchCardsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentSearchCardsBinding);
        return fragmentSearchCardsBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage() {
        CardSearchViewModel cardSearchViewModel = this.viewModel;
        if (cardSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel = null;
        }
        SearchPaginationState value = cardSearchViewModel.getPaginationState().getValue();
        if (value == null || value.isLoading() || !value.getHasMorePages()) {
            return;
        }
        this.currentPage++;
        showLoadingFooter(true);
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    @JvmStatic
    public static final SearchCardsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onMTFullCardClick$lambda$0(final SearchCardsFragment searchCardsFragment, MTFullCard mTFullCard, int i) {
        if (searchCardsFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = searchCardsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).syncRecentCard(mTFullCard);
        if (!searchCardsFragment.pickACardMode) {
            String json = new Gson().toJson(mTFullCard);
            Intent intent = new Intent(searchCardsFragment.requireContext(), (Class<?>) CardActivity.class);
            intent.putExtra("singleMTCard", json);
            intent.putExtra("lang", mTFullCard.getLang());
            intent.putExtra("enTitle", mTFullCard.getName());
            Integer face = mTFullCard.getFace();
            intent.putExtra(OptionalModuleUtils.FACE, face != null ? face.intValue() : 0);
            intent.putExtra("localizedTypeLine", mTFullCard.getType_line());
            String printed_name = mTFullCard.getPrinted_name();
            if (printed_name == null) {
                printed_name = mTFullCard.getName();
            }
            intent.putExtra("localizedTitle", printed_name);
            intent.putExtra("localizedOracle", mTFullCard.getOracle_text());
            CardDataStore.INSTANCE.setMtCardList(searchCardsFragment.cards);
            intent.putExtra("hasMTCards", true);
            intent.putExtra("currentMTIndex", i);
            intent.putExtra("mtCardListId", -1);
            intent.putExtra("readOnly", true);
            searchCardsFragment.cardActivityLauncher.launch(intent);
            return;
        }
        CardSelectionListener cardSelectionListener = searchCardsFragment.cardSelectionListener;
        if (cardSelectionListener != null) {
            String oracleid = mTFullCard.getOracleid();
            String scryfallid = mTFullCard.getScryfallid();
            String lang = mTFullCard.getLang();
            String printed_name2 = mTFullCard.getPrinted_name();
            if (printed_name2 == null && (printed_name2 = mTFullCard.getName()) == null) {
                printed_name2 = "";
            }
            MTSimpleCard mTSimpleCard = new MTSimpleCard(mTFullCard.getCollector_number(), null, null, lang, printed_name2, oracleid, null, scryfallid, mTFullCard.getSet_code(), 70, null);
            Integer face2 = mTFullCard.getFace();
            cardSelectionListener.onCardSelected(mTSimpleCard, face2 != null ? face2.intValue() : 0);
            return;
        }
        final FragmentActivity activity = searchCardsFragment.getActivity();
        if (activity != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("newCardId", mTFullCard.getScryfallid());
            Integer face3 = mTFullCard.getFace();
            intent2.putExtra(OptionalModuleUtils.FACE, face3 != null ? face3.intValue() : 0);
            intent2.putExtra("cardPicked", new Gson().toJson(mTFullCard));
            activity.setResult(-1, intent2);
            searchCardsFragment.getBinding().cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    SearchCardsFragment.onMTFullCardClick$lambda$0$1$0(this.f$0, activity);
                }
            }, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMTFullCardClick$lambda$0$1$0(SearchCardsFragment searchCardsFragment, FragmentActivity fragmentActivity) {
        if (searchCardsFragment.getActivity() == null) {
            return;
        }
        fragmentActivity.finish();
    }

    static final boolean onViewCreated$lambda$0(SearchCardsFragment searchCardsFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        searchCardsFragment.triggerSearch();
        Object systemService = searchCardsFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$1(EditText editText, SearchCardsFragment searchCardsFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (searchCardsFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(4);
        editText.requestFocus();
        Object systemService = searchCardsFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final Unit onViewCreated$lambda$10(SearchCardsFragment searchCardsFragment, SearchMode searchMode) {
        Intrinsics.checkNotNull(searchMode);
        searchCardsFragment.updateUIForMode(searchMode);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$11(SearchCardsFragment searchCardsFragment, SearchPaginationState searchPaginationState) {
        searchCardsFragment.updateCardCount();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit onViewCreated$lambda$12(final SearchCardsFragment searchCardsFragment, List list) {
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty() && searchCardsFragment.currentGroupBy != null) {
            RecyclerView cardsRecyclerView = searchCardsFragment.getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
            List<BrowseListCardItem> browseListCardItemsFromGroups = BrowseListCardItemKt.toBrowseListCardItemsFromGroups(list);
            if (cardsRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.LayoutManager layoutManager = cardsRecyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                boolean z = ((GridLayoutManager) layoutManager).getSpanSizeLookup() instanceof GridLayoutManager.DefaultSpanSizeLookup;
                final int i = 3;
                final int i2 = 2;
                if (cardsRecyclerView.getAdapter() == null || z) {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[searchCardsFragment.currentLayout.ordinal()];
                    if (i3 == 1) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(searchCardsFragment.requireContext(), 2);
                        final MTFullCardsAdapter mTFullCardsAdapter = new MTFullCardsAdapter(browseListCardItemsFromGroups, -1, searchCardsFragment.cardSets, false, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$adapter$1
                            @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                            public void onCardLongPress(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                                this.this$0.copyCardNameToClipboard(card);
                            }
                        }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$adapter$2
                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onCardSelectionToggle(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }

                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }
                        }, null, null, 384, null);
                        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$1
                            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                            public int getSpanSize(int position) {
                                if (mTFullCardsAdapter.getItemAt(position) instanceof BrowseListCardItem.SectionHeader) {
                                    return i2;
                                }
                                return 1;
                            }
                        });
                        cardsRecyclerView.setLayoutManager(gridLayoutManager);
                        cardsRecyclerView.setAdapter(mTFullCardsAdapter);
                    } else if (i3 == 2) {
                        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(searchCardsFragment.requireContext(), 3);
                        final MTFullCardsAdapter mTFullCardsAdapter2 = new MTFullCardsAdapter(browseListCardItemsFromGroups, -1, searchCardsFragment.cardSets, true, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$adapter$3
                            @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                            public void onCardLongPress(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                                this.this$0.copyCardNameToClipboard(card);
                            }
                        }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$adapter$4
                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onCardSelectionToggle(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }

                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }
                        }, null, null, 384, null);
                        gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$2
                            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                            public int getSpanSize(int position) {
                                if (mTFullCardsAdapter2.getItemAt(position) instanceof BrowseListCardItem.SectionHeader) {
                                    return i;
                                }
                                return 1;
                            }
                        });
                        cardsRecyclerView.setLayoutManager(gridLayoutManager2);
                        cardsRecyclerView.setAdapter(mTFullCardsAdapter2);
                    } else {
                        if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        cardsRecyclerView.setLayoutManager(new LinearLayoutManager(searchCardsFragment.requireContext()));
                        cardsRecyclerView.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromGroups, -1, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$3
                            @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                            public void onCardLongPress(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                                this.this$0.copyCardNameToClipboard(card);
                            }
                        }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$21$4
                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onCardSelectionToggle(MTFullCard card, int position) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }

                            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                            public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                                Intrinsics.checkNotNullParameter(card, "card");
                            }
                        }, null, null, 96, null));
                    }
                } else {
                    int i4 = WhenMappings.$EnumSwitchMapping$0[searchCardsFragment.currentLayout.ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        RecyclerView.Adapter adapter = cardsRecyclerView.getAdapter();
                        MTFullCardsAdapter mTFullCardsAdapter3 = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
                        if (mTFullCardsAdapter3 != null) {
                            mTFullCardsAdapter3.updateItems(browseListCardItemsFromGroups);
                        }
                    } else {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        RecyclerView.Adapter adapter2 = cardsRecyclerView.getAdapter();
                        MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
                        if (mTFullCardListAdapter != null) {
                            mTFullCardListAdapter.updateItems(browseListCardItemsFromGroups);
                        }
                    }
                }
                FragmentActivity activity = searchCardsFragment.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            SearchCardsFragment.onViewCreated$lambda$12$0(this.f$0);
                        }
                    });
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12$0(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.getBinding().loadingBackgroundView.setVisibility(4);
        searchCardsFragment.getBinding().loadingAnimationView.setVisibility(4);
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(4);
        searchCardsFragment.showLoadingFooter(false);
        searchCardsFragment.updateCardCount();
    }

    static final Unit onViewCreated$lambda$13(final SearchCardsFragment searchCardsFragment, Boolean bool) {
        FragmentActivity activity;
        if (bool.booleanValue() && (activity = searchCardsFragment.getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    SearchCardsFragment.onViewCreated$lambda$13$0(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13$0(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.getBinding().loadingBackgroundView.setVisibility(4);
        searchCardsFragment.getBinding().loadingAnimationView.setVisibility(4);
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(0);
        searchCardsFragment.showLoadingFooter(false);
    }

    static final void onViewCreated$lambda$14(EditText editText, SearchCardsFragment searchCardsFragment) {
        editText.requestFocus();
        Object systemService = searchCardsFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    static final Unit onViewCreated$lambda$2(SearchCardsFragment searchCardsFragment) {
        Object systemService = searchCardsFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(searchCardsFragment.getBinding().searchEditText.getWindowToken(), 0);
        searchCardsFragment.triggerSearch();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(final SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment._binding != null && searchCardsFragment.getContext() != null) {
            Context contextRequireContext = searchCardsFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(searchCardsFragment.cards);
            int i = WhenMappings.$EnumSwitchMapping$0[searchCardsFragment.currentLayout.ordinal()];
            if (i == 1) {
                CardsLayout cardsLayout = CardsLayout.GRID_BY_3;
                searchCardsFragment.currentLayout = cardsLayout;
                preferencesManager.setPreferredCardLayout(cardsLayout);
                searchCardsFragment.getBinding().gridImage.setImageResource(R.drawable.grid_3);
                RecyclerView cardsRecyclerView = searchCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
                cardsRecyclerView.setLayoutManager(new GridLayoutManager(searchCardsFragment.requireContext(), 3));
                cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, searchCardsFragment.cardSets, true, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$1
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$2
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
            } else if (i == 2) {
                CardsLayout cardsLayout2 = CardsLayout.LIST;
                searchCardsFragment.currentLayout = cardsLayout2;
                preferencesManager.setPreferredCardLayout(cardsLayout2);
                searchCardsFragment.getBinding().gridImage.setImageResource(R.drawable.view_list);
                RecyclerView cardsRecyclerView2 = searchCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView2, "cardsRecyclerView");
                cardsRecyclerView2.setLayoutManager(new LinearLayoutManager(searchCardsFragment.requireContext()));
                cardsRecyclerView2.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$3
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$4
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 96, null));
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                CardsLayout cardsLayout3 = CardsLayout.GRID_BY_2;
                searchCardsFragment.currentLayout = cardsLayout3;
                preferencesManager.setPreferredCardLayout(cardsLayout3);
                searchCardsFragment.getBinding().gridImage.setImageResource(R.drawable.grid_2);
                RecyclerView cardsRecyclerView3 = searchCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView3, "cardsRecyclerView");
                cardsRecyclerView3.setLayoutManager(new GridLayoutManager(searchCardsFragment.requireContext(), 2));
                cardsRecyclerView3.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, searchCardsFragment.cardSets, false, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$5
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$5$6
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment.getContext() == null || searchCardsFragment._binding == null) {
            return Unit.INSTANCE;
        }
        searchCardsFragment.getBinding().marketplaceSelectorView.showMarketplaceSelectionDialog();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(final SearchCardsFragment searchCardsFragment, String marketplace) {
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        if (searchCardsFragment.getContext() == null || searchCardsFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = searchCardsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).syncCurrentSettingsToAPI(new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$5$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5$0(SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment.getContext() != null && searchCardsFragment._binding != null) {
            searchCardsFragment.restartSearch();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment.filtersCollapsed) {
            searchCardsFragment.filtersCollapsed = false;
            searchCardsFragment.updateFilterListFromQuery(searchCardsFragment.lastQuery);
        } else {
            searchCardsFragment.filtersCollapsed = true;
            searchCardsFragment.updateFilterListFromQuery(searchCardsFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment.filtersCollapsed) {
            searchCardsFragment.filtersCollapsed = false;
            searchCardsFragment.updateFilterListFromQuery(searchCardsFragment.lastQuery);
        } else {
            searchCardsFragment.filtersCollapsed = true;
            searchCardsFragment.updateFilterListFromQuery(searchCardsFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(SearchCardsFragment searchCardsFragment) {
        if (searchCardsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        UnifiedFiltersBottomSheetFragment.Builder listener = new UnifiedFiltersBottomSheetFragment.Builder().setMode(searchCardsFragment.isCollectionSearch ? FilterMode.COLLECTION : FilterMode.GENERAL).setCurrentFilters(searchCardsFragment.getBinding().searchEditText.getText().toString()).setLang(searchCardsFragment.currentSearchLanguage).setListener(searchCardsFragment);
        FragmentManager childFragmentManager = searchCardsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        listener.show(childFragmentManager, "UnifiedFiltersBottomSheet");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final void onViewCreated$lambda$9(final SearchCardsFragment searchCardsFragment, List list) {
        boolean z;
        FragmentActivity activity;
        if (searchCardsFragment.currentGroupBy != null) {
            return;
        }
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty() && (activity = searchCardsFragment.getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    SearchCardsFragment.onViewCreated$lambda$9$0(this.f$0);
                }
            });
        }
        PreferencesManager preferencesManager = searchCardsFragment.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.setCurrentSearch(searchCardsFragment.lastQuery);
        PreferencesManager preferencesManager2 = searchCardsFragment.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager2, null, 1, null);
        searchCardsFragment.cards = list;
        RecyclerView cardsRecyclerView = searchCardsFragment.getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(searchCardsFragment.cards);
        if (cardsRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager = cardsRecyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            z = !(((GridLayoutManager) layoutManager).getSpanSizeLookup() instanceof GridLayoutManager.DefaultSpanSizeLookup);
        }
        if (cardsRecyclerView.getAdapter() == null || z) {
            int i = WhenMappings.$EnumSwitchMapping$0[searchCardsFragment.currentLayout.ordinal()];
            if (i == 1) {
                cardsRecyclerView.setLayoutManager(new GridLayoutManager(searchCardsFragment.requireContext(), 2));
                cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, searchCardsFragment.cardSets, false, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$2
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$3
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
            } else if (i == 2) {
                cardsRecyclerView.setLayoutManager(new GridLayoutManager(searchCardsFragment.requireContext(), 3));
                cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, searchCardsFragment.cardSets, true, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$4
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$5
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                cardsRecyclerView.setLayoutManager(new LinearLayoutManager(searchCardsFragment.requireContext()));
                cardsRecyclerView.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, searchCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$6
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                        this.this$0.copyCardNameToClipboard(card);
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$18$7
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 96, null));
            }
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[searchCardsFragment.currentLayout.ordinal()];
            if (i2 == 1 || i2 == 2) {
                RecyclerView.Adapter adapter = cardsRecyclerView.getAdapter();
                MTFullCardsAdapter mTFullCardsAdapter = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
                if (mTFullCardsAdapter != null) {
                    mTFullCardsAdapter.updateItems(browseListCardItemsFromCards);
                }
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                RecyclerView.Adapter adapter2 = cardsRecyclerView.getAdapter();
                MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
                if (mTFullCardListAdapter != null) {
                    mTFullCardListAdapter.updateItems(browseListCardItemsFromCards);
                }
            }
        }
        FragmentActivity activity2 = searchCardsFragment.getActivity();
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    SearchCardsFragment.onViewCreated$lambda$9$1(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$0(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.getBinding().loadingBackgroundView.setVisibility(4);
        searchCardsFragment.getBinding().loadingAnimationView.setVisibility(4);
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(4);
        searchCardsFragment.showLoadingFooter(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$1(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.updateCardCount();
        searchCardsFragment.updateCollectionReminderVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performSearch(String str, Continuation<? super Unit> continuation) {
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_search");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("new_search", null);
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchCardsFragment.performSearch$lambda$0$0(this.f$0);
                    }
                });
            }
            CardSearchViewModel cardSearchViewModel = this.viewModel;
            if (cardSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cardSearchViewModel = null;
            }
            cardSearchViewModel.getSearchResults().postValue(CollectionsKt.emptyList());
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            Log.d("SearchActivity", "Searching for... " + str);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda25
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchCardsFragment.performSearch$lambda$1$0(this.f$0);
                    }
                });
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C12424(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performSearch$lambda$0$0(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.getBinding().loadingBackgroundView.setVisibility(4);
        searchCardsFragment.getBinding().loadingAnimationView.setVisibility(4);
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performSearch$lambda$1$0(SearchCardsFragment searchCardsFragment) {
        RecyclerView recyclerView = searchCardsFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
        searchCardsFragment.getBinding().noMatchesTextView.setVisibility(4);
        searchCardsFragment.getBinding().loadingBackgroundView.setVisibility(0);
        searchCardsFragment.getBinding().loadingAnimationView.setVisibility(0);
    }

    private final void restartSearch() {
        this.currentPage = 1;
        String string = getBinding().searchEditText.getText().toString();
        this.lastQuery = string;
        if (StringsKt.trim((CharSequence) string).toString().length() == 0) {
            return;
        }
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C12431(null), 2, null);
    }

    private final void selectAllCards() {
        this.isCollectionSearch = false;
        getBinding().btnAllCards.setBackgroundResource(R.drawable.type_selected_background);
        getBinding().btnAllCards.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        getBinding().btnMyCollection.setBackground(null);
        getBinding().btnMyCollection.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        updateCollectionReminderVisibility();
        if (this.lastQuery.length() > 0) {
            restartSearch();
        }
    }

    private final void selectMyCollection() {
        this.isCollectionSearch = true;
        getBinding().btnMyCollection.setBackgroundResource(R.drawable.type_selected_background);
        getBinding().btnMyCollection.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        getBinding().btnAllCards.setBackground(null);
        getBinding().btnAllCards.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        updateCollectionReminderVisibility();
        if (this.lastQuery.length() > 0) {
            restartSearch();
        }
    }

    private final void setupSearchSourceToggle() {
        if (this.forceLocalDb) {
            getBinding().searchSourceToggle.setVisibility(8);
            return;
        }
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        if (preferencesManager.getCurrentUser() == null) {
            getBinding().searchSourceToggle.setVisibility(8);
            return;
        }
        getBinding().searchSourceToggle.setVisibility(0);
        NetworkHelper networkHelper = NetworkHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final boolean zIsNetworkAvailable = networkHelper.isNetworkAvailable(contextRequireContext);
        getBinding().btnMyCollection.setAlpha(zIsNetworkAvailable ? 1.0f : 0.5f);
        TextView btnAllCards = getBinding().btnAllCards;
        Intrinsics.checkNotNullExpressionValue(btnAllCards, "btnAllCards");
        ViewExtensionsKt.setOnClickWithFade(btnAllCards, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.setupSearchSourceToggle$lambda$0(this.f$0);
            }
        });
        TextView btnMyCollection = getBinding().btnMyCollection;
        Intrinsics.checkNotNullExpressionValue(btnMyCollection, "btnMyCollection");
        ViewExtensionsKt.setOnClickWithFade(btnMyCollection, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.setupSearchSourceToggle$lambda$1(zIsNetworkAvailable, this);
            }
        });
    }

    static final Unit setupSearchSourceToggle$lambda$0(SearchCardsFragment searchCardsFragment) {
        searchCardsFragment.selectAllCards();
        return Unit.INSTANCE;
    }

    static final Unit setupSearchSourceToggle$lambda$1(boolean z, SearchCardsFragment searchCardsFragment) {
        if (z) {
            searchCardsFragment.selectMyCollection();
        }
        return Unit.INSTANCE;
    }

    private final void setupSortAndGroupButtons() {
        final TextView sortByButton = getBinding().sortByButton;
        Intrinsics.checkNotNullExpressionValue(sortByButton, "sortByButton");
        final TextView groupByButton = getBinding().groupByButton;
        Intrinsics.checkNotNullExpressionValue(groupByButton, "groupByButton");
        sortByButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showSortByPopupMenu(sortByButton);
            }
        });
        groupByButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showGroupByPopupMenu(groupByButton);
            }
        });
        TextView searchSettingsIcon = getBinding().searchSettingsIcon;
        Intrinsics.checkNotNullExpressionValue(searchSettingsIcon, "searchSettingsIcon");
        ViewExtensionsKt.setOnClickWithBounce(searchSettingsIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.setupSortAndGroupButtons$lambda$2(this.f$0);
            }
        });
    }

    static final Unit setupSortAndGroupButtons$lambda$2(SearchCardsFragment searchCardsFragment) {
        TextView searchSettingsIcon = searchCardsFragment.getBinding().searchSettingsIcon;
        Intrinsics.checkNotNullExpressionValue(searchSettingsIcon, "searchSettingsIcon");
        searchCardsFragment.showLanguageFilterPopupMenu(searchSettingsIcon);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void showGroupByPopupMenu(View anchor) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        MenuItem menuItemFindItem5;
        MenuItem menuItemFindItem6;
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.search_group_by_menu, popupMenu.getMenu());
        String str = this.currentGroupBy;
        if (str != null) {
            switch (str.hashCode()) {
                case -938161749:
                    if (str.equals("rarity") && (menuItemFindItem = popupMenu.getMenu().findItem(R.id.group_rarity)) != null) {
                        menuItemFindItem.setChecked(true);
                    }
                    break;
                case 3355:
                    if (str.equals("id") && (menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.group_color_identity)) != null) {
                        menuItemFindItem2.setChecked(true);
                    }
                    break;
                case 98617:
                    if (str.equals("cmc") && (menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.group_cmc)) != null) {
                        menuItemFindItem3.setChecked(true);
                    }
                    break;
                case 113762:
                    if (str.equals("set") && (menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.group_set)) != null) {
                        menuItemFindItem4.setChecked(true);
                    }
                    break;
                case 3575610:
                    if (str.equals("type") && (menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.group_type)) != null) {
                        menuItemFindItem5.setChecked(true);
                    }
                    break;
                case 94842723:
                    if (str.equals("color") && (menuItemFindItem6 = popupMenu.getMenu().findItem(R.id.group_color)) != null) {
                        menuItemFindItem6.setChecked(true);
                    }
                    break;
            }
        } else {
            MenuItem menuItemFindItem7 = popupMenu.getMenu().findItem(R.id.group_none);
            if (menuItemFindItem7 != null) {
                menuItemFindItem7.setChecked(true);
            }
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda26
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return SearchCardsFragment.showGroupByPopupMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showGroupByPopupMenu$lambda$0(SearchCardsFragment searchCardsFragment, MenuItem menuItem) {
        if (searchCardsFragment.getContext() == null) {
            return false;
        }
        int itemId = menuItem.getItemId();
        if (itemId == R.id.group_none) {
            searchCardsFragment.currentGroupBy = null;
        } else if (itemId == R.id.group_type) {
            searchCardsFragment.currentGroupBy = "type";
        } else if (itemId == R.id.group_color) {
            searchCardsFragment.currentGroupBy = "color";
        } else if (itemId == R.id.group_color_identity) {
            searchCardsFragment.currentGroupBy = "id";
        } else if (itemId == R.id.group_cmc) {
            searchCardsFragment.currentGroupBy = "cmc";
        } else if (itemId == R.id.group_rarity) {
            searchCardsFragment.currentGroupBy = "rarity";
        } else if (itemId == R.id.group_set) {
            searchCardsFragment.currentGroupBy = "set";
        }
        searchCardsFragment.restartSearch();
        return true;
    }

    private final void showLanguageFilterPopupMenu(View anchor) {
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.search_language_menu, popupMenu.getMenu());
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("", Integer.valueOf(R.id.lang_all)), TuplesKt.to("en", Integer.valueOf(R.id.lang_en)), TuplesKt.to("fr", Integer.valueOf(R.id.lang_fr)), TuplesKt.to("es", Integer.valueOf(R.id.lang_es)), TuplesKt.to("de", Integer.valueOf(R.id.lang_de)), TuplesKt.to("it", Integer.valueOf(R.id.lang_it)), TuplesKt.to("pt", Integer.valueOf(R.id.lang_pt)), TuplesKt.to("ja", Integer.valueOf(R.id.lang_ja)), TuplesKt.to("ko", Integer.valueOf(R.id.lang_ko)), TuplesKt.to("zht", Integer.valueOf(R.id.lang_zht)), TuplesKt.to("zhs", Integer.valueOf(R.id.lang_zhs)), TuplesKt.to("ru", Integer.valueOf(R.id.lang_ru)));
        Set<Map.Entry> setEntrySet = mapMapOf.entrySet();
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Pair pair = TuplesKt.to(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Integer num = (Integer) mapMapOf.get(this.searchLanguageFilter);
        if (num != null) {
            MenuItem menuItemFindItem = popupMenu.getMenu().findItem(num.intValue());
            if (menuItemFindItem != null) {
                menuItemFindItem.setChecked(true);
            }
        } else {
            MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.lang_all);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setChecked(true);
            }
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda19
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return SearchCardsFragment.showLanguageFilterPopupMenu$lambda$3(this.f$0, linkedHashMap, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showLanguageFilterPopupMenu$lambda$3(SearchCardsFragment searchCardsFragment, Map map, MenuItem menuItem) {
        String deviceLanguage;
        if (searchCardsFragment.getContext() == null) {
            return false;
        }
        String str = (String) map.get(Integer.valueOf(menuItem.getItemId()));
        if (str == null) {
            str = "";
        }
        searchCardsFragment.searchLanguageFilter = str;
        PreferencesManager preferencesManager = searchCardsFragment.prefs;
        CardSearchViewModel cardSearchViewModel = null;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.setString(PreferencesManager.SEARCH_LANGUAGE_FILTER, str);
        if (searchCardsFragment.overrideLanguage.length() > 0) {
            deviceLanguage = searchCardsFragment.overrideLanguage;
        } else if (searchCardsFragment.searchLanguageFilter.length() > 0) {
            deviceLanguage = searchCardsFragment.searchLanguageFilter;
        } else {
            PreferencesManager preferencesManager2 = searchCardsFragment.prefs;
            if (preferencesManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager2 = null;
            }
            deviceLanguage = preferencesManager2.getDeviceLanguage();
        }
        searchCardsFragment.currentSearchLanguage = deviceLanguage;
        CardSearchViewModel cardSearchViewModel2 = searchCardsFragment.viewModel;
        if (cardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel2 = null;
        }
        cardSearchViewModel2.setCurrentLanguage(searchCardsFragment.currentSearchLanguage);
        CardSearchViewModel cardSearchViewModel3 = searchCardsFragment.viewModel;
        if (cardSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cardSearchViewModel = cardSearchViewModel3;
        }
        cardSearchViewModel.setSearchLanguageFilter(searchCardsFragment.searchLanguageFilter);
        searchCardsFragment.restartSearch();
        return true;
    }

    private final void showLoadingFooter(boolean show) {
        if (this._binding == null) {
            return;
        }
        getBinding().scrollAnimationView.setVisibility(show ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void showSortByPopupMenu(View anchor) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        MenuItem menuItemFindItem5;
        MenuItem menuItemFindItem6;
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.search_sort_by_menu, popupMenu.getMenu());
        String str = this.currentSortBy;
        if (str != null) {
            switch (str.hashCode()) {
                case -938161749:
                    if (str.equals("rarity") && (menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.sort_rarity)) != null) {
                        menuItemFindItem2.setChecked(true);
                    }
                    break;
                case 98617:
                    if (str.equals("cmc") && (menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.sort_cmc)) != null) {
                        menuItemFindItem3.setChecked(true);
                    }
                    break;
                case 113762:
                    if (str.equals("set") && (menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.sort_set)) != null) {
                        menuItemFindItem4.setChecked(true);
                    }
                    break;
                case 3373707:
                    if (str.equals("name") && (menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.sort_name)) != null) {
                        menuItemFindItem5.setChecked(true);
                    }
                    break;
                case 106934601:
                    if (str.equals(FirebaseAnalytics.Param.PRICE) && (menuItemFindItem6 = popupMenu.getMenu().findItem(R.id.sort_price)) != null) {
                        menuItemFindItem6.setChecked(true);
                    }
                    break;
            }
        }
        String str2 = this.currentSortDirection;
        if (Intrinsics.areEqual(str2, "asc")) {
            MenuItem menuItemFindItem7 = popupMenu.getMenu().findItem(R.id.sort_ascending);
            if (menuItemFindItem7 != null) {
                menuItemFindItem7.setChecked(true);
            }
        } else if (Intrinsics.areEqual(str2, "desc") && (menuItemFindItem = popupMenu.getMenu().findItem(R.id.sort_descending)) != null) {
            menuItemFindItem.setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda18
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return SearchCardsFragment.showSortByPopupMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showSortByPopupMenu$lambda$0(SearchCardsFragment searchCardsFragment, MenuItem menuItem) {
        if (searchCardsFragment.getContext() == null) {
            return false;
        }
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sort_name) {
            searchCardsFragment.currentSortBy = "name";
        } else if (itemId == R.id.sort_set) {
            searchCardsFragment.currentSortBy = "set";
        } else if (itemId == R.id.sort_cmc) {
            searchCardsFragment.currentSortBy = "cmc";
        } else if (itemId == R.id.sort_rarity) {
            searchCardsFragment.currentSortBy = "rarity";
        } else if (itemId == R.id.sort_price) {
            searchCardsFragment.currentSortBy = FirebaseAnalytics.Param.PRICE;
        } else if (itemId == R.id.sort_ascending) {
            searchCardsFragment.currentSortDirection = "asc";
        } else if (itemId == R.id.sort_descending) {
            searchCardsFragment.currentSortDirection = "desc";
        }
        searchCardsFragment.restartSearch();
        return true;
    }

    private final void triggerSearch() {
        String string = getBinding().searchEditText.getText().toString();
        if (StringsKt.trim((CharSequence) string).toString().length() == 0) {
            return;
        }
        this.lastQuery = string;
        updateFilterListFromQuery(string);
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C12441(string, null), 2, null);
    }

    private final void updateCardCount() {
        TextView numCardsTextView = getBinding().numCardsTextView;
        Intrinsics.checkNotNullExpressionValue(numCardsTextView, "numCardsTextView");
        CardSearchViewModel cardSearchViewModel = this.viewModel;
        if (cardSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel = null;
        }
        SearchPaginationState value = cardSearchViewModel.getPaginationState().getValue();
        int totalResults = value != null ? value.getTotalResults() : 0;
        if (totalResults <= 0) {
            totalResults = this.cards.size();
        }
        if (totalResults == 0) {
            numCardsTextView.setVisibility(8);
            return;
        }
        numCardsTextView.setVisibility(0);
        if (totalResults == 1) {
            numCardsTextView.setText(getResources().getString(R.string.one_card));
            return;
        }
        String string = getResources().getString(R.string.x_cards);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        numCardsTextView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(totalResults), false, 4, (Object) null));
    }

    private final void updateCollectionReminderVisibility() {
        getBinding().collectionReminderTextView.setVisibility((!this.isCollectionSearch || this.cards.isEmpty()) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterListFromQuery(String query) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C12461(query, null), 3, null);
    }

    private final void updateUIForMode(SearchMode mode) {
        if (this.forceLocalDb) {
            TextView textView = getBinding().sortByButton;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = getBinding().groupByButton;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = getBinding().offlineModeIndicator;
            if (textView3 != null) {
                textView3.setVisibility(8);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(mode, SearchMode.Online.INSTANCE)) {
            TextView textView4 = getBinding().sortByButton;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = getBinding().groupByButton;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            TextView textView6 = getBinding().offlineModeIndicator;
            if (textView6 != null) {
                textView6.setVisibility(8);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(mode, SearchMode.Offline.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        TextView textView7 = getBinding().sortByButton;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        TextView textView8 = getBinding().groupByButton;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        TextView textView9 = getBinding().offlineModeIndicator;
        if (textView9 != null) {
            textView9.setVisibility(0);
        }
    }

    public final Job getSearchJob() {
        return this.searchJob;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.prefs = preferencesManager;
        boolean z = preferencesManager.getBoolean(PreferencesManager.CONDENSE_SEARCH, true);
        this.condense = z;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pickACardMode = arguments.getBoolean("pickACardMode", false);
            this.condense = arguments.getBoolean("condense", z);
            String string = arguments.getString(SearchIntents.EXTRA_QUERY, "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.initialQuery = string;
            String string2 = arguments.getString("lang", "");
            this.overrideLanguage = string2 != null ? string2 : "";
            this.forceLocalDb = arguments.getBoolean("forceLocalDb", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSearchCardsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterClick(final SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        final EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        final String string = searchEditText.getText().toString();
        if (string != null) {
            new FilterDialogFragment.Builder().setSearchElement(filter).setLang(this.currentSearchLanguage).setListener(new FilterDialogListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$onFilterClick$1$filterDialog$1
                @Override // com.studiolaganne.lengendarylens.FilterDialogListener
                public void onFilterSubmitButton(SearchCondition newFilter) {
                    Intrinsics.checkNotNullParameter(newFilter, "newFilter");
                    String strReplace$default = StringsKt.replace$default(string, filter.getOriginalToken(), newFilter.toShortString(), false, 4, (Object) null);
                    searchEditText.setText(strReplace$default);
                    this.updateFilterListFromQuery(strReplace$default);
                    this.lastQuery = strReplace$default;
                    Job searchJob = this.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    SearchCardsFragment searchCardsFragment = this;
                    searchCardsFragment.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(searchCardsFragment), Dispatchers.getIO(), null, new SearchCardsFragment$onFilterClick$1$filterDialog$1$onFilterSubmitButton$1(this, strReplace$default, null), 2, null));
                }
            }).build().show(getChildFragmentManager(), "FilterDialogFragment");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterDelete(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        ?? string = searchEditText.getText().toString();
        if (string != 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = string;
            objectRef.element = StringsKt.replace$default((String) objectRef.element, filter.getOriginalToken(), "", false, 4, (Object) null);
            objectRef.element = StringsKt.replace$default((String) objectRef.element, "  ", " ", false, 4, (Object) null);
            CardSearchViewModel cardSearchViewModel = null;
            if (StringsKt.trim((CharSequence) objectRef.element).toString().length() > 0) {
                searchEditText.setText((CharSequence) objectRef.element);
                updateFilterListFromQuery((String) objectRef.element);
                this.lastQuery = (String) objectRef.element;
                Job job = this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SearchCardsFragment$onFilterDelete$1$1(this, objectRef, null), 2, null);
                return;
            }
            this.lastQuery = "";
            searchEditText.setText("");
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
            CardSearchViewModel cardSearchViewModel2 = this.viewModel;
            if (cardSearchViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cardSearchViewModel = cardSearchViewModel2;
            }
            cardSearchViewModel.getSearchResults().postValue(CollectionsKt.emptyList());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.FilterDialogListener
    public void onFilterSubmitButton(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (getContext() == null) {
            return;
        }
        EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        ?? string = searchEditText.getText().toString();
        if (string != 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = string;
            objectRef.element = objectRef.element + " " + filter.toShortString();
            if (StringsKt.trim((CharSequence) objectRef.element).toString().length() > 0) {
                EditText searchEditText2 = getBinding().searchEditText;
                Intrinsics.checkNotNullExpressionValue(searchEditText2, "searchEditText");
                searchEditText2.setText((CharSequence) objectRef.element);
                updateFilterListFromQuery((String) objectRef.element);
                this.lastQuery = (String) objectRef.element;
                Job job = this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SearchCardsFragment$onFilterSubmitButton$1$1(this, objectRef, null), 2, null);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.UnifiedFiltersListener
    public void onFiltersApplied(String scryfallQuery) {
        Intrinsics.checkNotNullParameter(scryfallQuery, "scryfallQuery");
        if (getContext() == null) {
            return;
        }
        EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        String str = scryfallQuery;
        searchEditText.setText(str);
        updateFilterListFromQuery(scryfallQuery);
        int length = StringsKt.trim((CharSequence) str).toString().length();
        CardSearchViewModel cardSearchViewModel = null;
        if (length > 0) {
            this.lastQuery = scryfallQuery;
            Job job = this.searchJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C12391(scryfallQuery, null), 2, null);
            return;
        }
        this.lastQuery = "";
        this.filtersCollapsed = false;
        updateFilterListFromQuery("");
        CardSearchViewModel cardSearchViewModel2 = this.viewModel;
        if (cardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cardSearchViewModel = cardSearchViewModel2;
        }
        cardSearchViewModel.getSearchResults().postValue(CollectionsKt.emptyList());
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(final MTFullCard card, final int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getActivity() == null || getContext() == null) {
            return;
        }
        Object systemService = requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        inputMethodManager.hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
        getBinding().cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                SearchCardsFragment.onMTFullCardClick$lambda$0(this.f$0, card, index);
            }
        }, 150L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.paused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.paused = false;
        PreferencesManager preferencesManager = this.prefs;
        RecyclerView recyclerView = null;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        this.currentLayout = preferencesManager.getPreferredCardLayout();
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.cards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 1) {
            getBinding().gridImage.setImageResource(R.drawable.grid_2);
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, false, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.1
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                    SearchCardsFragment.this.copyCardNameToClipboard(card);
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.2
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
            return;
        }
        if (i == 2) {
            getBinding().gridImage.setImageResource(R.drawable.grid_3);
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            recyclerView4.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView5;
            }
            recyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, true, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.3
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                    SearchCardsFragment.this.copyCardNameToClipboard(card);
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.4
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        getBinding().gridImage.setImageResource(R.drawable.view_list);
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView7;
        }
        recyclerView.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.5
            @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
            public void onCardLongPress(MTFullCard card, int position) {
                Intrinsics.checkNotNullParameter(card, "card");
                SearchCardsFragment.this.copyCardNameToClipboard(card);
            }
        }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onResume.6
            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
            public void onCardSelectionToggle(MTFullCard card, int position) {
                Intrinsics.checkNotNullParameter(card, "card");
            }

            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
            public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                Intrinsics.checkNotNullParameter(card, "card");
            }
        }, null, null, 96, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String deviceLanguage;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.prefs = preferencesManager;
        this.currentLayout = preferencesManager.getPreferredCardLayout();
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        this.dbHelper = companion.getInstance(contextRequireContext2);
        this.dbHelpers = new ArrayList();
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        for (String str : preferencesManager2.getSupportedLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                MTGDBHelperLocalized companion3 = companion2.getInstance(contextRequireContext3, str);
                List<MTGDBHelperLocalized> list = this.dbHelpers;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dbHelpers");
                    list = null;
                }
                list.add(companion3);
            }
        }
        this.cardSets = CardSetsManager.INSTANCE.getCardSets();
        setupSearchSourceToggle();
        setupSortAndGroupButtons();
        View loadingBackgroundView = getBinding().loadingBackgroundView;
        Intrinsics.checkNotNullExpressionValue(loadingBackgroundView, "loadingBackgroundView");
        LottieAnimationView loadingAnimationView = getBinding().loadingAnimationView;
        Intrinsics.checkNotNullExpressionValue(loadingAnimationView, "loadingAnimationView");
        loadingBackgroundView.setVisibility(4);
        loadingAnimationView.setVisibility(4);
        getBinding().numCardsTextView.setVisibility(8);
        final EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setInputType(524288);
        searchEditText.setImportantForAutofill(2);
        searchEditText.requestFocus();
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda27
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchCardsFragment.onViewCreated$lambda$0(this.f$0, textView, i, keyEvent);
            }
        });
        searchEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return SearchCardsFragment.onViewCreated$lambda$1(searchEditText, this, view2, motionEvent);
            }
        });
        searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.3

            /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SearchCardsFragment$onViewCreated$3$WhenMappings */
            /* JADX INFO: compiled from: SearchCardsFragment.kt */
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

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    searchEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.getBinding().noMatchesTextView.setVisibility(4);
                    this.getBinding().searchButton.setEnabled(false);
                    this.getBinding().searchButton.setAlpha(0.5f);
                } else {
                    searchEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                    this.getBinding().searchButton.setEnabled(true);
                    this.getBinding().searchButton.setAlpha(1.0f);
                }
                if (Intrinsics.areEqual(String.valueOf(s), "")) {
                    ImageView collapseImageView = this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                    collapseImageView.setVisibility(8);
                    ConstraintLayout filterSummaryLayout = this.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                    filterSummaryLayout.setVisibility(8);
                    this.filtersCollapsed = false;
                    this.cards = CollectionsKt.emptyList();
                    this.getBinding().numCardsTextView.setVisibility(8);
                    RecyclerView cardsRecyclerView = this.getBinding().cardsRecyclerView;
                    Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
                    int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
                    if (i == 1 || i == 2) {
                        RecyclerView.Adapter adapter = cardsRecyclerView.getAdapter();
                        MTFullCardsAdapter mTFullCardsAdapter = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
                        if (mTFullCardsAdapter != null) {
                            mTFullCardsAdapter.updateItems(CollectionsKt.emptyList());
                        }
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        RecyclerView.Adapter adapter2 = cardsRecyclerView.getAdapter();
                        MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
                        if (mTFullCardListAdapter != null) {
                            mTFullCardListAdapter.updateItems(CollectionsKt.emptyList());
                        }
                    }
                    this.updateFilterListFromQuery("");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        TextView searchButton = getBinding().searchButton;
        Intrinsics.checkNotNullExpressionValue(searchButton, "searchButton");
        ViewExtensionsKt.setOnClickWithFade(searchButton, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        ImageView gridImage = getBinding().gridImage;
        Intrinsics.checkNotNullExpressionValue(gridImage, "gridImage");
        ViewExtensionsKt.setOnClickWithFade(gridImage, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        MarketplaceSelectorView marketplaceSelectorView = getBinding().marketplaceSelectorView;
        Intrinsics.checkNotNullExpressionValue(marketplaceSelectorView, "marketplaceSelectorView");
        ViewExtensionsKt.setOnClickWithFade(marketplaceSelectorView, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        getBinding().marketplaceSelectorView.setOnMarketplaceChangedListener(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchCardsFragment.onViewCreated$lambda$5(this.f$0, (String) obj);
            }
        });
        ImageView collapseImageView = getBinding().collapseImageView;
        Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
        collapseImageView.setVisibility(8);
        ConstraintLayout filterSummaryLayout = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
        filterSummaryLayout.setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(collapseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        ConstraintLayout filterSummaryLayout2 = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
        ViewExtensionsKt.setOnClickWithFade(filterSummaryLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        LinearLayout addFilterLayout = getBinding().addFilterLayout;
        Intrinsics.checkNotNullExpressionValue(addFilterLayout, "addFilterLayout");
        ViewExtensionsKt.setOnClickWithFade(addFilterLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchCardsFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 2) {
            getBinding().gridImage.setImageResource(R.drawable.grid_3);
            RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
            cardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        } else if (i == 3) {
            getBinding().gridImage.setImageResource(R.drawable.view_list);
            RecyclerView cardsRecyclerView2 = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView2, "cardsRecyclerView");
            cardsRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        }
        PreferencesManager preferencesManager3 = this.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        String currentSearch = "";
        this.searchLanguageFilter = preferencesManager3.getString(PreferencesManager.SEARCH_LANGUAGE_FILTER, "");
        if (this.overrideLanguage.length() > 0) {
            deviceLanguage = this.overrideLanguage;
        } else if (this.searchLanguageFilter.length() > 0) {
            deviceLanguage = this.searchLanguageFilter;
        } else {
            PreferencesManager preferencesManager4 = this.prefs;
            if (preferencesManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager4 = null;
            }
            deviceLanguage = preferencesManager4.getDeviceLanguage();
        }
        this.currentSearchLanguage = deviceLanguage;
        MTGDBHelper mTGDBHelper = this.dbHelper;
        if (mTGDBHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbHelper");
            mTGDBHelper = null;
        }
        List<MTGDBHelperLocalized> list2 = this.dbHelpers;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbHelpers");
            list2 = null;
        }
        PreferencesManager preferencesManager5 = this.prefs;
        if (preferencesManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager5 = null;
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        CardSearchViewModel cardSearchViewModel = (CardSearchViewModel) new ViewModelProvider(this, new CardSearchViewModelFactory(mTGDBHelper, list2, preferencesManager5, contextRequireContext4)).get(CardSearchViewModel.class);
        this.viewModel = cardSearchViewModel;
        if (cardSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel = null;
        }
        cardSearchViewModel.setCurrentLanguage(this.currentSearchLanguage);
        CardSearchViewModel cardSearchViewModel2 = this.viewModel;
        if (cardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel2 = null;
        }
        cardSearchViewModel2.setSearchLanguageFilter(this.searchLanguageFilter);
        RecyclerView cardsRecyclerView3 = getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView3, "cardsRecyclerView");
        this.recyclerView = cardsRecyclerView3;
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.cards);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i2 == 1) {
            getBinding().gridImage.setImageResource(R.drawable.grid_2);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, false, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.11
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                    SearchCardsFragment.this.copyCardNameToClipboard(card);
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.12
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
        } else if (i2 == 2) {
            getBinding().gridImage.setImageResource(R.drawable.grid_3);
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            recyclerView4.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, true, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.13
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                    SearchCardsFragment.this.copyCardNameToClipboard(card);
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.14
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            getBinding().gridImage.setImageResource(R.drawable.view_list);
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView5 = null;
            }
            recyclerView5.setLayoutManager(new LinearLayoutManager(requireContext()));
            RecyclerView recyclerView6 = this.recyclerView;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView6 = null;
            }
            recyclerView6.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.15
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                    SearchCardsFragment.this.copyCardNameToClipboard(card);
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.16
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 96, null));
        }
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView7 = null;
        }
        recyclerView7.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment.onViewCreated.17
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView8, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView8, "recyclerView");
                super.onScrolled(recyclerView8, dx, dy);
                CardSearchViewModel cardSearchViewModel3 = SearchCardsFragment.this.viewModel;
                CardSearchViewModel cardSearchViewModel4 = null;
                if (cardSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cardSearchViewModel3 = null;
                }
                if (Intrinsics.areEqual(cardSearchViewModel3.getSearchMode().getValue(), SearchMode.Online.INSTANCE) && dy > 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView8.getLayoutManager();
                    int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
                    int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
                    int iFindFirstVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() : layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition() : 0;
                    CardSearchViewModel cardSearchViewModel5 = SearchCardsFragment.this.viewModel;
                    if (cardSearchViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        cardSearchViewModel4 = cardSearchViewModel5;
                    }
                    SearchPaginationState value = cardSearchViewModel4.getPaginationState().getValue();
                    boolean zIsLoading = value != null ? value.isLoading() : false;
                    boolean hasMorePages = value != null ? value.getHasMorePages() : false;
                    if (zIsLoading || !hasMorePages || childCount + iFindFirstVisibleItemPosition < itemCount - 5) {
                        return;
                    }
                    SearchCardsFragment.this.loadNextPage();
                }
            }
        });
        CardSearchViewModel cardSearchViewModel3 = this.viewModel;
        if (cardSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel3 = null;
        }
        cardSearchViewModel3.getSearchResults().observe(requireActivity(), new Observer() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchCardsFragment.onViewCreated$lambda$9(this.f$0, (List) obj);
            }
        });
        CardSearchViewModel cardSearchViewModel4 = this.viewModel;
        if (cardSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel4 = null;
        }
        cardSearchViewModel4.getSearchMode().observe(getViewLifecycleOwner(), new SearchCardsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchCardsFragment.onViewCreated$lambda$10(this.f$0, (SearchMode) obj);
            }
        }));
        CardSearchViewModel cardSearchViewModel5 = this.viewModel;
        if (cardSearchViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel5 = null;
        }
        cardSearchViewModel5.getPaginationState().observe(getViewLifecycleOwner(), new SearchCardsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchCardsFragment.onViewCreated$lambda$11(this.f$0, (SearchPaginationState) obj);
            }
        }));
        CardSearchViewModel cardSearchViewModel6 = this.viewModel;
        if (cardSearchViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel6 = null;
        }
        cardSearchViewModel6.getGroupedResults().observe(getViewLifecycleOwner(), new SearchCardsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchCardsFragment.onViewCreated$lambda$12(this.f$0, (List) obj);
            }
        }));
        CardSearchViewModel cardSearchViewModel7 = this.viewModel;
        if (cardSearchViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel7 = null;
        }
        cardSearchViewModel7.getEmptyResult().observe(requireActivity(), new SearchCardsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchCardsFragment.onViewCreated$lambda$13(this.f$0, (Boolean) obj);
            }
        }));
        if (this.initialQuery.length() <= 0) {
            PreferencesManager preferencesManager6 = this.prefs;
            if (preferencesManager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                preferencesManager6 = null;
            }
            currentSearch = preferencesManager6.getCurrentSearch();
        } else if (!Intrinsics.areEqual(this.initialQuery, "_blank_")) {
            currentSearch = this.initialQuery;
        }
        String str2 = currentSearch;
        if (str2.length() <= 0) {
            Boolean.valueOf(searchEditText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SearchCardsFragment$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    SearchCardsFragment.onViewCreated$lambda$14(searchEditText, this);
                }
            }, 100L));
            return;
        }
        getBinding().searchEditText.setText(str2);
        updateFilterListFromQuery(currentSearch);
        getBinding().searchButton.setEnabled(true);
        getBinding().searchButton.setAlpha(1.0f);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass23(currentSearch, null), 2, null);
    }

    public final void setCardSelectionListener(CardSelectionListener listener) {
        this.cardSelectionListener = listener;
    }

    public final void setSearchJob(Job job) {
        this.searchJob = job;
    }

    public final void updateCondenseSetting(boolean condense) {
        this.condense = condense;
        if (this.lastQuery.length() > 0) {
            Job job = this.searchJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C12451(null), 2, null);
        }
    }
}
