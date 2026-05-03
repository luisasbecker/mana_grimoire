package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
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
import com.studiolaganne.lengendarylens.FilterDialogFragment;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentBrowseCardsBinding;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: BrowseCardsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001WB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/J\u0010\u00107\u001a\u0002012\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u00108\u001a\u000209H\u0016J\u0016\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u000fH\u0016J\u0018\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0012\u0010E\u001a\u0002012\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J&\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010N\u001a\u000201H\u0016J\u001a\u0010O\u001a\u0002012\u0006\u0010P\u001a\u00020I2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0016\u0010Q\u001a\u0002012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002J\u0010\u0010S\u001a\u0002012\u0006\u0010=\u001a\u00020\u000fH\u0002J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u000201H\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00172\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u0001050504X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseCardsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "<init>", "()V", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "sortOrder", "Lcom/studiolaganne/lengendarylens/SortBy;", "sortAscending", "", "currentSetCode", "", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "dbHelpers", "", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "lang", "sets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "cardSets", "originalCards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentCards", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseCardsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseCardsBinding;", "lastQuery", "pickACardMode", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "viewModel", "Lcom/studiolaganne/lengendarylens/CardSearchViewModel;", "shouldShowIntFields", "filtersCollapsed", "cardSelectionListener", "Lcom/studiolaganne/lengendarylens/CardSelectionListener;", "setCardSelectionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "cardActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onFilterClick", "filter", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "onFilterDelete", "onFilterSubmitButton", "performSearch", SearchIntents.EXTRA_QUERY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFiltersApplied", "scryfallQuery", "onMTFullCardClick", "card", FirebaseAnalytics.Param.INDEX, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateCurrentCards", "cards", "updateFilterListFromQuery", "updateCardCount", "sortCardsAndReload", "sortCards", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseCardsFragment extends Fragment implements OnMTFullCardClickListener, FilterDialogListener, OnFilterClickListener, UnifiedFiltersListener {
    private FragmentBrowseCardsBinding _binding;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private CardSelectionListener cardSelectionListener;
    private MTGDBHelper dbHelper;
    private List<MTGDBHelperLocalized> dbHelpers;
    private boolean filtersCollapsed;
    private boolean pickACardMode;
    private Job searchJob;
    private CardSearchViewModel viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;
    private SortBy sortOrder = SortBy.COLLECTOR_NUMBER;
    private boolean sortAscending = true;
    private String currentSetCode = "";
    private String lang = "en";
    private List<CardSet> sets = CollectionsKt.emptyList();
    private List<CardSet> cardSets = CollectionsKt.emptyList();
    private List<MTFullCard> originalCards = CollectionsKt.emptyList();
    private List<MTFullCard> currentCards = CollectionsKt.emptyList();
    private String lastQuery = "";
    private boolean shouldShowIntFields = true;

    /* JADX INFO: compiled from: BrowseCardsFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseCardsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/BrowseCardsFragment;", "setCode", "", "lang", "pickACardMode", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ BrowseCardsFragment newInstance$default(Companion companion, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(str, str2, z);
        }

        @JvmStatic
        public final BrowseCardsFragment newInstance(String setCode, String lang, boolean pickACardMode) {
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            Intrinsics.checkNotNullParameter(lang, "lang");
            BrowseCardsFragment browseCardsFragment = new BrowseCardsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("setCode", setCode);
            bundle.putString("lang", lang);
            bundle.putBoolean("pickACardMode", pickACardMode);
            browseCardsFragment.setArguments(bundle);
            return browseCardsFragment;
        }
    }

    /* JADX INFO: compiled from: BrowseCardsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CardsLayout.values().length];
            try {
                iArr[CardsLayout.GRID_BY_3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardsLayout.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardsLayout.GRID_BY_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SortBy.values().length];
            try {
                iArr2[SortBy.COLLECTOR_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SortBy.NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseCardsFragment$onFiltersApplied$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseCardsFragment$onFiltersApplied$1", f = "BrowseCardsFragment.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scryfallQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scryfallQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrowseCardsFragment.this.new AnonymousClass1(this.$scryfallQuery, continuation);
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
                if (BrowseCardsFragment.this.getContext() == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (BrowseCardsFragment.this.performSearch(this.$scryfallQuery, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseCardsFragment$performSearch$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseCardsFragment$performSearch$2", f = "BrowseCardsFragment.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_TRACK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $newQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$newQuery = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrowseCardsFragment.this.new AnonymousClass2(this.$newQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CardSearchViewModel cardSearchViewModel = BrowseCardsFragment.this.viewModel;
                if (cardSearchViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cardSearchViewModel = null;
                }
                this.label = 1;
                if (CardSearchViewModel.searchCards$default(cardSearchViewModel, this.$newQuery.element, 1, null, null, null, false, false, false, this, 192, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseCardsFragment$updateFilterListFromQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseCardsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseCardsFragment$updateFilterListFromQuery$1", f = "BrowseCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11111(String str, Continuation<? super C11111> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11111 c11111 = BrowseCardsFragment.this.new C11111(this.$query, continuation);
            c11111.L$0 = obj;
            return c11111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (BrowseCardsFragment.this.isAdded() && (context = BrowseCardsFragment.this.getContext()) != null) {
                SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(this.$query);
                RecyclerView filtersRecyclerView = BrowseCardsFragment.this.getBinding().filtersRecyclerView;
                Intrinsics.checkNotNullExpressionValue(filtersRecyclerView, "filtersRecyclerView");
                filtersRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
                boolean z = BrowseCardsFragment.this.filtersCollapsed;
                BrowseCardsFragment browseCardsFragment = BrowseCardsFragment.this;
                if (z) {
                    TextView addFilterButton = browseCardsFragment.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton, "addFilterButton");
                    addFilterButton.setVisibility(4);
                    TextView addFilterTextView = BrowseCardsFragment.this.getBinding().addFilterTextView;
                    Intrinsics.checkNotNullExpressionValue(addFilterTextView, "addFilterTextView");
                    addFilterTextView.setVisibility(8);
                    filtersRecyclerView.setAdapter(null);
                    ImageView collapseImageView = BrowseCardsFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                    collapseImageView.setVisibility(0);
                    collapseImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.expand_24));
                    ConstraintLayout filterSummaryLayout = BrowseCardsFragment.this.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                    filterSummaryLayout.setVisibility(0);
                    SearchGroup searchGroup = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    if (searchGroup != null) {
                        BrowseCardsFragment browseCardsFragment2 = BrowseCardsFragment.this;
                        TextView filterNumberTextView = browseCardsFragment2.getBinding().filterNumberTextView;
                        Intrinsics.checkNotNullExpressionValue(filterNumberTextView, "filterNumberTextView");
                        filterNumberTextView.setText(String.valueOf(searchGroup.getElements().size()));
                        TextView filterSummaryTextView = browseCardsFragment2.getBinding().filterSummaryTextView;
                        Intrinsics.checkNotNullExpressionValue(filterSummaryTextView, "filterSummaryTextView");
                        filterSummaryTextView.setText(browseCardsFragment2.getResources().getString(R.string.filters_selected));
                    }
                } else {
                    ConstraintLayout filterSummaryLayout2 = browseCardsFragment.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
                    filterSummaryLayout2.setVisibility(8);
                    TextView addFilterButton2 = BrowseCardsFragment.this.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton2, "addFilterButton");
                    addFilterButton2.setVisibility(0);
                    ImageView collapseImageView2 = BrowseCardsFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView2, "collapseImageView");
                    collapseImageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.collapse));
                    SearchGroup searchGroup2 = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    BrowseCardsFragment browseCardsFragment3 = BrowseCardsFragment.this;
                    if (searchGroup2 == null) {
                        TextView addFilterTextView2 = browseCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView2, "addFilterTextView");
                        addFilterTextView2.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView3 = browseCardsFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView3, "collapseImageView");
                        collapseImageView3.setVisibility(8);
                    } else if (searchGroup2.getElements().isEmpty()) {
                        TextView addFilterTextView3 = browseCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView3, "addFilterTextView");
                        addFilterTextView3.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView4 = browseCardsFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView4, "collapseImageView");
                        collapseImageView4.setVisibility(8);
                    } else {
                        filtersRecyclerView.setAdapter(new FilterListAdapter(browseCardsFragment3.lang, searchGroup2, browseCardsFragment3));
                        TextView addFilterTextView4 = browseCardsFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView4, "addFilterTextView");
                        addFilterTextView4.setVisibility(8);
                        if (searchGroup2.getElements().size() > 2) {
                            ImageView collapseImageView5 = browseCardsFragment3.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView5, "collapseImageView");
                            collapseImageView5.setVisibility(0);
                        } else {
                            ImageView collapseImageView6 = browseCardsFragment3.getBinding().collapseImageView;
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

    public BrowseCardsFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda10
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BrowseCardsFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    static final void cardActivityLauncher$lambda$0(final BrowseCardsFragment browseCardsFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = browseCardsFragment.getContext();
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
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BrowseCardsFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(BrowseCardsFragment browseCardsFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = browseCardsFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentBrowseCardsBinding getBinding() {
        FragmentBrowseCardsBinding fragmentBrowseCardsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentBrowseCardsBinding);
        return fragmentBrowseCardsBinding;
    }

    @JvmStatic
    public static final BrowseCardsFragment newInstance(String str, String str2, boolean z) {
        return INSTANCE.newInstance(str, str2, z);
    }

    static final void onMTFullCardClick$lambda$0(final BrowseCardsFragment browseCardsFragment, MTFullCard mTFullCard, int i) {
        if (browseCardsFragment.getContext() == null || browseCardsFragment._binding == null) {
            return;
        }
        Context contextRequireContext = browseCardsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).syncRecentCard(mTFullCard);
        if (!browseCardsFragment.pickACardMode) {
            String json = new Gson().toJson(mTFullCard);
            Intent intent = new Intent(browseCardsFragment.requireContext(), (Class<?>) CardActivity.class);
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
            CardDataStore.INSTANCE.setMtCardList(browseCardsFragment.currentCards);
            intent.putExtra("hasMTCards", true);
            intent.putExtra("currentMTIndex", i);
            intent.putExtra("mtCardListId", -1);
            browseCardsFragment.cardActivityLauncher.launch(intent);
            return;
        }
        CardSelectionListener cardSelectionListener = browseCardsFragment.cardSelectionListener;
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
        final FragmentActivity activity = browseCardsFragment.getActivity();
        if (activity != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("newCardId", mTFullCard.getScryfallid());
            Integer face3 = mTFullCard.getFace();
            intent2.putExtra(OptionalModuleUtils.FACE, face3 != null ? face3.intValue() : 0);
            intent2.putExtra("cardPicked", new Gson().toJson(mTFullCard));
            activity.setResult(-1, intent2);
            browseCardsFragment.getBinding().cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseCardsFragment.onMTFullCardClick$lambda$0$1$0(this.f$0, activity);
                }
            }, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMTFullCardClick$lambda$0$1$0(BrowseCardsFragment browseCardsFragment, FragmentActivity fragmentActivity) {
        if (browseCardsFragment.getActivity() == null) {
            return;
        }
        fragmentActivity.finish();
    }

    static final void onViewCreated$lambda$10(final BrowseCardsFragment browseCardsFragment, final List list) {
        FragmentActivity activity = browseCardsFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseCardsFragment.onViewCreated$lambda$10$0(this.f$0, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$0(BrowseCardsFragment browseCardsFragment, List list) {
        Intrinsics.checkNotNull(list);
        browseCardsFragment.updateCurrentCards(list);
    }

    static final Unit onViewCreated$lambda$11(final BrowseCardsFragment browseCardsFragment, Boolean bool) {
        FragmentActivity activity;
        if (bool.booleanValue() && (activity = browseCardsFragment.getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseCardsFragment.onViewCreated$lambda$11$0(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$0(BrowseCardsFragment browseCardsFragment) {
        browseCardsFragment.updateCurrentCards(browseCardsFragment.originalCards);
    }

    static final Unit onViewCreated$lambda$12(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment.filtersCollapsed) {
            browseCardsFragment.filtersCollapsed = false;
            browseCardsFragment.updateFilterListFromQuery(browseCardsFragment.lastQuery);
        } else {
            browseCardsFragment.filtersCollapsed = true;
            browseCardsFragment.updateFilterListFromQuery(browseCardsFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$13(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment.filtersCollapsed) {
            browseCardsFragment.filtersCollapsed = false;
            browseCardsFragment.updateFilterListFromQuery(browseCardsFragment.lastQuery);
        } else {
            browseCardsFragment.filtersCollapsed = true;
            browseCardsFragment.updateFilterListFromQuery(browseCardsFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$14(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        UnifiedFiltersBottomSheetFragment.Builder listener = new UnifiedFiltersBottomSheetFragment.Builder().setMode(FilterMode.LOCAL_DB).setCurrentFilters(browseCardsFragment.getBinding().filterEditText.getText().toString()).setLang(browseCardsFragment.lang).setListener(browseCardsFragment);
        FragmentManager childFragmentManager = browseCardsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        listener.show(childFragmentManager, "UnifiedFiltersBottomSheet");
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(BrowseCardsFragment browseCardsFragment, ImageView imageView) {
        if (browseCardsFragment.sortAscending) {
            browseCardsFragment.sortAscending = false;
            imageView.setImageResource(R.drawable.down_circle);
            browseCardsFragment.sortCardsAndReload();
        } else {
            browseCardsFragment.sortAscending = true;
            imageView.setImageResource(R.drawable.up_circle);
            browseCardsFragment.sortCardsAndReload();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment.getParentFragment() == null) {
            return Unit.INSTANCE;
        }
        browseCardsFragment.requireParentFragment().getChildFragmentManager().popBackStack();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment.getBinding().filterLayout.getVisibility() == 8) {
            browseCardsFragment.getBinding().filterLayout.setVisibility(0);
        } else {
            browseCardsFragment.getBinding().filterLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(BrowseCardsFragment browseCardsFragment) {
        if (browseCardsFragment._binding != null && browseCardsFragment.getContext() != null) {
            Context contextRequireContext = browseCardsFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseCardsFragment.currentCards);
            int i = WhenMappings.$EnumSwitchMapping$0[browseCardsFragment.currentLayout.ordinal()];
            if (i == 1) {
                CardsLayout cardsLayout = CardsLayout.LIST;
                browseCardsFragment.currentLayout = cardsLayout;
                preferencesManager.setPreferredCardLayout(cardsLayout);
                browseCardsFragment.getBinding().gridImage.setImageResource(R.drawable.view_list);
                RecyclerView cardsRecyclerView = browseCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
                cardsRecyclerView.setLayoutManager(new LinearLayoutManager(browseCardsFragment.requireContext()));
                cardsRecyclerView.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, browseCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$3
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$4
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 96, null));
                browseCardsFragment.updateCardCount();
            } else if (i == 2) {
                CardsLayout cardsLayout2 = CardsLayout.GRID_BY_2;
                browseCardsFragment.currentLayout = cardsLayout2;
                preferencesManager.setPreferredCardLayout(cardsLayout2);
                browseCardsFragment.getBinding().gridImage.setImageResource(R.drawable.grid_2);
                RecyclerView cardsRecyclerView2 = browseCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView2, "cardsRecyclerView");
                cardsRecyclerView2.setLayoutManager(new GridLayoutManager(browseCardsFragment.requireContext(), 2));
                cardsRecyclerView2.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, browseCardsFragment.cardSets, false, browseCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$5
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$6
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
                browseCardsFragment.updateCardCount();
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                CardsLayout cardsLayout3 = CardsLayout.GRID_BY_3;
                browseCardsFragment.currentLayout = cardsLayout3;
                preferencesManager.setPreferredCardLayout(cardsLayout3);
                browseCardsFragment.getBinding().gridImage.setImageResource(R.drawable.grid_3);
                RecyclerView cardsRecyclerView3 = browseCardsFragment.getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView3, "cardsRecyclerView");
                cardsRecyclerView3.setLayoutManager(new GridLayoutManager(browseCardsFragment.requireContext(), 3));
                cardsRecyclerView3.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, browseCardsFragment.cardSets, true, browseCardsFragment, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$1
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$12$2
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 384, null));
                browseCardsFragment.updateCardCount();
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final boolean onViewCreated$lambda$7(BrowseCardsFragment browseCardsFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = browseCardsFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$8(EditText editText, BrowseCardsFragment browseCardsFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (browseCardsFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        editText.requestFocus();
        Object systemService = browseCardsFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final boolean onViewCreated$lambda$9(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14, types: [T, java.lang.String] */
    public final Object performSearch(String str, Continuation<? super Unit> continuation) {
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_search_from_sets");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("new_search_from_sets", null);
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0) {
            CardSearchViewModel cardSearchViewModel = this.viewModel;
            if (cardSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cardSearchViewModel = null;
            }
            cardSearchViewModel.getSearchResults().postValue(CollectionsKt.emptyList());
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = str;
            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "set:", false, 2, (Object) null)) {
                objectRef.element = objectRef.element + " set:" + this.currentSetCode;
            }
            Log.d("BrowseCards", "Searching for... " + str);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(objectRef, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    private final List<MTFullCard> sortCards(List<MTFullCard> cards) {
        int i = WhenMappings.$EnumSwitchMapping$1[this.sortOrder.ordinal()];
        return i != 1 ? i != 2 ? cards : this.sortAscending ? CollectionsKt.sortedWith(cards, new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$sortCards$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                MTFullCard mTFullCard = (MTFullCard) t;
                String printed_name = mTFullCard.getPrinted_name();
                if (printed_name == null && (printed_name = mTFullCard.getName()) == null) {
                    printed_name = "";
                }
                String str = printed_name;
                MTFullCard mTFullCard2 = (MTFullCard) t2;
                String printed_name2 = mTFullCard2.getPrinted_name();
                return ComparisonsKt.compareValues(str, (printed_name2 == null && (printed_name2 = mTFullCard2.getName()) == null) ? "" : printed_name2);
            }
        }) : CollectionsKt.sortedWith(cards, new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$sortCards$$inlined$sortedByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                MTFullCard mTFullCard = (MTFullCard) t2;
                String printed_name = mTFullCard.getPrinted_name();
                String str = "";
                if (printed_name == null && (printed_name = mTFullCard.getName()) == null) {
                    printed_name = "";
                }
                String str2 = printed_name;
                MTFullCard mTFullCard2 = (MTFullCard) t;
                String printed_name2 = mTFullCard2.getPrinted_name();
                if (printed_name2 == null) {
                    String name = mTFullCard2.getName();
                    if (name != null) {
                        str = name;
                    }
                } else {
                    str = printed_name2;
                }
                return ComparisonsKt.compareValues(str2, str);
            }
        }) : this.sortAscending ? CollectionsKt.sortedWith(cards, new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$sortCards$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
            @Override // java.util.Comparator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final int compare(T t, T t2) {
                Integer intOrNull;
                String collector_number = ((MTFullCard) t).getCollector_number();
                Integer intOrNull2 = null;
                if (collector_number != null) {
                    String strReplace = new Regex("[^\\d]").replace(collector_number, "");
                    intOrNull = strReplace != null ? StringsKt.toIntOrNull(strReplace) : null;
                }
                Integer num = intOrNull;
                String collector_number2 = ((MTFullCard) t2).getCollector_number();
                if (collector_number2 != null) {
                    String strReplace2 = new Regex("[^\\d]").replace(collector_number2, "");
                    if (strReplace2 != null) {
                        intOrNull2 = StringsKt.toIntOrNull(strReplace2);
                    }
                }
                return ComparisonsKt.compareValues(num, intOrNull2);
            }
        }) : CollectionsKt.sortedWith(cards, new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$sortCards$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
            @Override // java.util.Comparator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final int compare(T t, T t2) {
                Integer intOrNull;
                String collector_number = ((MTFullCard) t2).getCollector_number();
                Integer intOrNull2 = null;
                if (collector_number != null) {
                    String strReplace = new Regex("[^\\d]").replace(collector_number, "");
                    intOrNull = strReplace != null ? StringsKt.toIntOrNull(strReplace) : null;
                }
                Integer num = intOrNull;
                String collector_number2 = ((MTFullCard) t).getCollector_number();
                if (collector_number2 != null) {
                    String strReplace2 = new Regex("[^\\d]").replace(collector_number2, "");
                    if (strReplace2 != null) {
                        intOrNull2 = StringsKt.toIntOrNull(strReplace2);
                    }
                }
                return ComparisonsKt.compareValues(num, intOrNull2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortCardsAndReload() {
        List<MTFullCard> listSortCards = sortCards(this.currentCards);
        this.currentCards = listSortCards;
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(listSortCards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 1) {
            RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
            cardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, true, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.3
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.4
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
            updateCardCount();
            return;
        }
        if (i == 2) {
            RecyclerView cardsRecyclerView2 = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView2, "cardsRecyclerView");
            cardsRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
            cardsRecyclerView2.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.5
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.6
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 96, null));
            updateCardCount();
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        RecyclerView cardsRecyclerView3 = getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView3, "cardsRecyclerView");
        cardsRecyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        cardsRecyclerView3.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, false, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.1
            @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
            public void onCardLongPress(MTFullCard card, int position) {
                Intrinsics.checkNotNullParameter(card, "card");
            }
        }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.sortCardsAndReload.2
            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
            public void onCardSelectionToggle(MTFullCard card, int position) {
                Intrinsics.checkNotNullParameter(card, "card");
            }

            @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
            public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                Intrinsics.checkNotNullParameter(card, "card");
            }
        }, null, null, 384, null));
        updateCardCount();
    }

    private final void updateCardCount() {
        int size = this.currentCards.size();
        if (size == 0) {
            getBinding().numCardsTextView.setText(getString(R.string.no_cards));
            return;
        }
        if (size == 1) {
            getBinding().numCardsTextView.setText(getString(R.string.one_card));
            return;
        }
        TextView textView = getBinding().numCardsTextView;
        String string = getString(R.string.x_cards);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(size), false, 4, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentCards(List<MTFullCard> cards) {
        this.currentCards = cards;
        this.currentCards = sortCards(cards);
        RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 1) {
            getBinding().gridImage.setImageResource(R.drawable.grid_3);
            cardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, true, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.3
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.4
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
            getBinding().gridImage.setImageResource(R.drawable.view_list);
            cardsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            cardsRecyclerView.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.5
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.6
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
            cardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            cardsRecyclerView.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, this.cardSets, false, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.1
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.updateCurrentCards.2
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
        updateCardCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterListFromQuery(String query) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11111(query, null), 3, null);
    }

    public final Job getSearchJob() {
        return this.searchJob;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pickACardMode = arguments.getBoolean("pickACardMode", false);
        }
        this.sets = CardSetsManager.INSTANCE.getCardSets();
        this.cardSets = CardSetsManager.INSTANCE.getCardSets();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentBrowseCardsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterClick(final SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        final EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        final String string = filterEditText.getText().toString();
        if (string != null) {
            new FilterDialogFragment.Builder().setSearchElement(filter).setLang(this.lang).setListener(new FilterDialogListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onFilterClick$1$filterDialog$1
                @Override // com.studiolaganne.lengendarylens.FilterDialogListener
                public void onFilterSubmitButton(SearchCondition newFilter) {
                    Intrinsics.checkNotNullParameter(newFilter, "newFilter");
                    String strReplace$default = StringsKt.replace$default(string, filter.getOriginalToken(), newFilter.toShortString(), false, 4, (Object) null);
                    filterEditText.setText(strReplace$default);
                    this.updateFilterListFromQuery(strReplace$default);
                    this.lastQuery = strReplace$default;
                    Job searchJob = this.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    BrowseCardsFragment browseCardsFragment = this;
                    browseCardsFragment.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(browseCardsFragment), Dispatchers.getIO(), null, new BrowseCardsFragment$onFilterClick$1$filterDialog$1$onFilterSubmitButton$1(this, strReplace$default, null), 2, null));
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
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        ?? string = filterEditText.getText().toString();
        if (string != 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = string;
            objectRef.element = StringsKt.replace$default((String) objectRef.element, filter.getOriginalToken(), "", false, 4, (Object) null);
            objectRef.element = StringsKt.replace$default((String) objectRef.element, "  ", " ", false, 4, (Object) null);
            CardSearchViewModel cardSearchViewModel = null;
            if (StringsKt.trim((CharSequence) objectRef.element).toString().length() > 0) {
                filterEditText.setText((CharSequence) objectRef.element);
                updateFilterListFromQuery((String) objectRef.element);
                this.lastQuery = (String) objectRef.element;
                Job job = this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BrowseCardsFragment$onFilterDelete$1$1(this, objectRef, null), 2, null);
                return;
            }
            this.lastQuery = "";
            filterEditText.setText("");
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
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.FilterDialogListener
    public void onFilterSubmitButton(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (getContext() == null) {
            return;
        }
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        ?? string = filterEditText.getText().toString();
        if (string != 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = string;
            objectRef.element = objectRef.element + " " + filter.toShortString();
            if (StringsKt.trim((CharSequence) objectRef.element).toString().length() > 0) {
                filterEditText.setText((CharSequence) objectRef.element);
                updateFilterListFromQuery((String) objectRef.element);
                this.lastQuery = (String) objectRef.element;
                Job job = this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BrowseCardsFragment$onFilterSubmitButton$1$1(this, objectRef, null), 2, null);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.UnifiedFiltersListener
    public void onFiltersApplied(String scryfallQuery) {
        Intrinsics.checkNotNullParameter(scryfallQuery, "scryfallQuery");
        if (getContext() == null) {
            return;
        }
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        String str = scryfallQuery;
        filterEditText.setText(str);
        updateFilterListFromQuery(scryfallQuery);
        if (StringsKt.trim((CharSequence) str).toString().length() <= 0) {
            this.lastQuery = "";
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
        } else {
            this.lastQuery = scryfallQuery;
            Job job = this.searchJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(scryfallQuery, null), 2, null);
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(final MTFullCard card, final int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
        cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                BrowseCardsFragment.onMTFullCardClick$lambda$0(this.f$0, card, index);
            }
        }, 150L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CardSearchViewModel cardSearchViewModel;
        List<CardRecord> allCardsFromSet;
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.currentLayout = preferencesManager.getPreferredCardLayout();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("setCode") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("lang") : null;
        if (string2 != null) {
            this.lang = string2;
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (string != null) {
            this.currentSetCode = string;
            if (Intrinsics.areEqual(this.lang, "en")) {
                MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                allCardsFromSet = companion.getInstance(contextRequireContext2).getAllCardsFromSet(string);
            } else {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                MTGDBHelperLocalized companion3 = companion2.getInstance(contextRequireContext3, this.lang);
                if (!companion3.isValid()) {
                    return;
                }
                allCardsFromSet = companion3.getAllCardsFromSet(string);
                if (allCardsFromSet.isEmpty()) {
                    MTGDBHelper.Companion companion4 = MTGDBHelper.INSTANCE;
                    Context contextRequireContext4 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                    allCardsFromSet = companion4.getInstance(contextRequireContext4).getAllCardsFromSet(string);
                }
            }
            List<CardRecord> list = allCardsFromSet;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CardRecord cardRecord : list) {
                String scryfall_id = cardRecord.getScryfall_id();
                String oracle_id = cardRecord.getOracle_id();
                arrayList.add(new MTFullCard(null, null, null, null, null, cardRecord.getNumber(), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(cardRecord.getFace()), null, null, null, null, null, null, null, null, null, cardRecord.getLang(), null, null, null, null, null, null, cardRecord.getMana_cost(), null, cardRecord.getEn_title(), cardRecord.getOracle_text(), oracle_id, null, cardRecord.getTitle(), null, null, null, null, 1, null, scryfall_id, cardRecord.getSet(), null, null, null, null, cardRecord.getType_line(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -471073315, -5464825, 127, null));
            }
            ArrayList arrayList2 = arrayList;
            this.originalCards = arrayList2;
            this.currentCards = arrayList2;
            this.currentCards = sortCards(arrayList2);
            RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
            cardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            cardsRecyclerView.setAdapter(new MTFullCardsAdapter(BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards), -1, this.cardSets, false, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$2$2
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$2$3
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
            updateCardCount();
            Iterator<T> it = this.sets.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String lowerCase = ((CardSet) next).getCode().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    break;
                }
            }
            CardSet cardSet = (CardSet) next;
            if (cardSet != null) {
                TextView textView = getBinding().titleTextView;
                String name = cardSet.getName();
                String upperCase = cardSet.getCode().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView.setText(name + " (" + upperCase + ")");
                if (Intrinsics.areEqual(this.lang, "fr")) {
                    Iterator<T> it2 = CardSetsManager.INSTANCE.getFrCardSets().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next2 = it2.next();
                            if (Intrinsics.areEqual(((CardSet) next2).getCode(), cardSet.getCode())) {
                                break;
                            }
                        } else {
                            next2 = null;
                            break;
                        }
                    }
                    CardSet cardSet2 = (CardSet) next2;
                    if (cardSet2 != null) {
                        TextView textView2 = getBinding().titleTextView;
                        String name2 = cardSet2.getName();
                        String upperCase2 = cardSet.getCode().toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        textView2.setText(name2 + " (" + upperCase2 + ")");
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
                Unit unit5 = Unit.INSTANCE;
            } else {
                getBinding().titleTextView.setVisibility(8);
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i != 1) {
            if (i == 2) {
                getBinding().gridImage.setImageResource(R.drawable.view_list);
                RecyclerView cardsRecyclerView2 = getBinding().cardsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(cardsRecyclerView2, "cardsRecyclerView");
                cardsRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
                cardsRecyclerView2.setAdapter(new MTFullCardListAdapter(BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards), -1, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.5
                    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                    public void onCardLongPress(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.6
                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onCardSelectionToggle(MTFullCard card, int position) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }

                    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                        Intrinsics.checkNotNullParameter(card, "card");
                    }
                }, null, null, 96, null));
                updateCardCount();
            }
            Unit unit9 = Unit.INSTANCE;
        } else {
            getBinding().gridImage.setImageResource(R.drawable.grid_3);
            RecyclerView cardsRecyclerView3 = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView3, "cardsRecyclerView");
            cardsRecyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            cardsRecyclerView3.setAdapter(new MTFullCardsAdapter(BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards), -1, this.cardSets, true, this, new OnCardLongPressListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.3
                @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
                public void onCardLongPress(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, new OnCardSelectionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.4
                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onCardSelectionToggle(MTFullCard card, int position) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }

                @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
                public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
                    Intrinsics.checkNotNullParameter(card, "card");
                }
            }, null, null, 384, null));
            updateCardCount();
            Unit unit10 = Unit.INSTANCE;
        }
        getBinding().filterLayout.setVisibility(8);
        Spinner sortSpinner = getBinding().sortSpinner;
        Intrinsics.checkNotNullExpressionValue(sortSpinner, "sortSpinner");
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.custom_spinner_item, new String[]{getString(R.string.collector_number), getString(R.string.name)});
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        sortSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (BrowseCardsFragment.this.getContext() == null) {
                    return;
                }
                BrowseCardsFragment browseCardsFragment = BrowseCardsFragment.this;
                if (position == 0) {
                    browseCardsFragment.sortOrder = SortBy.COLLECTOR_NUMBER;
                } else {
                    browseCardsFragment.sortOrder = SortBy.NAME;
                }
                BrowseCardsFragment.this.sortCardsAndReload();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        final ImageView sortOrderImageView = getBinding().sortOrderImageView;
        Intrinsics.checkNotNullExpressionValue(sortOrderImageView, "sortOrderImageView");
        ViewExtensionsKt.setOnClickWithFade(sortOrderImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$2(this.f$0, sortOrderImageView);
            }
        });
        ImageView backImage = getBinding().backImage;
        Intrinsics.checkNotNullExpressionValue(backImage, "backImage");
        ViewExtensionsKt.setOnClickWithFade(backImage, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$onViewCreated$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.getParentFragment() == null) {
                    return;
                }
                this.this$0.requireParentFragment().getChildFragmentManager().popBackStack();
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
        LinearLayout topLayout = getBinding().topLayout;
        Intrinsics.checkNotNullExpressionValue(topLayout, "topLayout");
        ViewExtensionsKt.setOnClickWithFade(topLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
        ImageView filterImage = getBinding().filterImage;
        Intrinsics.checkNotNullExpressionValue(filterImage, "filterImage");
        ViewExtensionsKt.setOnClickWithFade(filterImage, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$5(this.f$0);
            }
        });
        ImageView gridImage = getBinding().gridImage;
        Intrinsics.checkNotNullExpressionValue(gridImage, "gridImage");
        ViewExtensionsKt.setOnClickWithFade(gridImage, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        final EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        filterEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i2, KeyEvent keyEvent) {
                return BrowseCardsFragment.onViewCreated$lambda$7(this.f$0, textView3, i2, keyEvent);
            }
        });
        filterEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BrowseCardsFragment.onViewCreated$lambda$8(filterEditText, this, view2, motionEvent);
            }
        });
        filterEditText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment.onViewCreated.15
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    filterEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    filterEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                this.lastQuery = strValueOf;
                int length = this.lastQuery.length();
                BrowseCardsFragment browseCardsFragment = this;
                if (length != 0) {
                    Job searchJob = browseCardsFragment.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    BrowseCardsFragment browseCardsFragment2 = this;
                    browseCardsFragment2.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(browseCardsFragment2), Dispatchers.getIO(), null, new BrowseCardsFragment$onViewCreated$15$afterTextChanged$1(this, strValueOf, null), 2, null));
                    return;
                }
                ImageView collapseImageView = browseCardsFragment.getBinding().collapseImageView;
                Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                collapseImageView.setVisibility(8);
                ConstraintLayout filterSummaryLayout = this.getBinding().filterSummaryLayout;
                Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                filterSummaryLayout.setVisibility(8);
                this.filtersCollapsed = false;
                this.updateFilterListFromQuery("");
                BrowseCardsFragment browseCardsFragment3 = this;
                browseCardsFragment3.updateCurrentCards(browseCardsFragment3.originalCards);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BrowseCardsFragment.onViewCreated$lambda$9(view2, motionEvent);
            }
        });
        MTGDBHelper.Companion companion5 = MTGDBHelper.INSTANCE;
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
        this.dbHelper = companion5.getInstance(contextRequireContext5);
        this.dbHelpers = new ArrayList();
        for (String str : preferencesManager.getSupportedLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion6 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext6 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                MTGDBHelperLocalized companion7 = companion6.getInstance(contextRequireContext6, str);
                List<MTGDBHelperLocalized> list2 = this.dbHelpers;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dbHelpers");
                    list2 = null;
                }
                list2.add(companion7);
            }
        }
        MTGDBHelper mTGDBHelper = this.dbHelper;
        if (mTGDBHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbHelper");
            mTGDBHelper = null;
        }
        List<MTGDBHelperLocalized> list3 = this.dbHelpers;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbHelpers");
            list3 = null;
        }
        Context contextRequireContext7 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext(...)");
        CardSearchViewModel cardSearchViewModel2 = (CardSearchViewModel) new ViewModelProvider(this, new CardSearchViewModelFactory(mTGDBHelper, list3, preferencesManager, contextRequireContext7)).get(CardSearchViewModel.class);
        this.viewModel = cardSearchViewModel2;
        if (cardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel2 = null;
        }
        cardSearchViewModel2.setCurrentLanguage(this.lang);
        CardSearchViewModel cardSearchViewModel3 = this.viewModel;
        if (cardSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel3 = null;
        }
        cardSearchViewModel3.getSearchResults().observe(requireActivity(), new Observer() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BrowseCardsFragment.onViewCreated$lambda$10(this.f$0, (List) obj);
            }
        });
        CardSearchViewModel cardSearchViewModel4 = this.viewModel;
        if (cardSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cardSearchViewModel = null;
        } else {
            cardSearchViewModel = cardSearchViewModel4;
        }
        cardSearchViewModel.getEmptyResult().observe(requireActivity(), new BrowseCardsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseCardsFragment.onViewCreated$lambda$11(this.f$0, (Boolean) obj);
            }
        }));
        ImageView collapseImageView = getBinding().collapseImageView;
        Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
        collapseImageView.setVisibility(8);
        ConstraintLayout filterSummaryLayout = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
        filterSummaryLayout.setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(collapseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$12(this.f$0);
            }
        });
        ConstraintLayout filterSummaryLayout2 = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
        ViewExtensionsKt.setOnClickWithFade(filterSummaryLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$13(this.f$0);
            }
        });
        LinearLayout addFilterLayout = getBinding().addFilterLayout;
        Intrinsics.checkNotNullExpressionValue(addFilterLayout, "addFilterLayout");
        ViewExtensionsKt.setOnClickWithFade(addFilterLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseCardsFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseCardsFragment.onViewCreated$lambda$14(this.f$0);
            }
        });
    }

    public final void setCardSelectionListener(CardSelectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cardSelectionListener = listener;
    }

    public final void setSearchJob(Job job) {
        this.searchJob = job;
    }
}
