package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.FilterDialogFragment;
import com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001gB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00107\u001a\u000208H\u0016J&\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010B\u001a\u0002082\u0006\u0010A\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u000208H\u0002J\b\u0010D\u001a\u000208H\u0002J\b\u0010E\u001a\u000208H\u0002J\b\u0010F\u001a\u000208H\u0002J\b\u0010G\u001a\u000208H\u0002J\b\u0010H\u001a\u000208H\u0002J\b\u0010I\u001a\u000208H\u0002J\b\u0010J\u001a\u000208H\u0002J\b\u0010K\u001a\u000208H\u0002J\b\u0010L\u001a\u000208H\u0002J\b\u0010M\u001a\u000208H\u0002J\u0010\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020\r2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010R\u001a\u0002082\u0006\u0010S\u001a\u00020\rH\u0002J\u0016\u0010T\u001a\u0002082\f\u0010U\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\b\u0010V\u001a\u000208H\u0002J\u0010\u0010W\u001a\u0002082\u0006\u0010S\u001a\u00020\rH\u0002J\u0018\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020\u0010H\u0016J\u0018\u0010[\u001a\u0002082\u0006\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020\u0010H\u0016J \u0010\\\u001a\u0002082\u0006\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u0010H\u0016J\u0018\u0010^\u001a\u0002082\u0006\u0010Y\u001a\u00020.2\u0006\u0010_\u001a\u00020\u0010H\u0016J\u0010\u0010`\u001a\u0002082\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u0002082\u0006\u0010d\u001a\u00020\rH\u0016J\u0010\u0010e\u001a\u0002082\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010f\u001a\u0002082\u0006\u0010a\u001a\u00020bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/MTCardPickerCallback;", "initialQuery", "", Constants.GP_IAP_TITLE, "deckId", "", "Ljava/lang/Integer;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchEditText", "Landroid/widget/EditText;", "searchButton", "Landroid/widget/TextView;", "gridImage", "Landroid/widget/ImageView;", "numCardsTextView", "noMatchesTextView", "advancedSearchLayout", "Landroid/view/View;", "filtersRecyclerView", "addFilterLayout", "legalCardsOnlyLayout", "legalCardsOnlyCheckBox", "Landroid/widget/CheckBox;", "collapseImageView", "filterSummaryLayout", "filterNumberTextView", "filterSummaryTextView", "searchSourceToggle", "Landroid/widget/LinearLayout;", "btnAllCards", "btnMyCollection", "collectionReminderTextView", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "lastQuery", "searchJob", "Lkotlinx/coroutines/Job;", "filtersCollapsed", "", "isCollectionSearch", "onStart", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "initializeViews", "setupSearch", "triggerSearch", "setupGridToggle", "setupLegalCardsOnlyCheckbox", "setupSearchSourceToggle", "selectAllCards", "selectMyCollection", "updateCollectionReminderVisibility", "setupFilters", "setupRecyclerView", "setupRecyclerViewForCurrentLayout", "isSimpleNameSearch", "searchElement", "Lcom/studiolaganne/lengendarylens/SearchElement;", "extractNameQuery", "performSearch", SearchIntents.EXTRA_QUERY, "updateCards", "newCards", "updateCardCount", "updateFilterListFromQuery", "onCardLongPress", "card", "position", "onCardSelectionToggle", "onQuantityChange", "newQuantity", "onMTFullCardClick", FirebaseAnalytics.Param.INDEX, "onFilterSubmitButton", "filter", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "onFiltersApplied", "scryfallQuery", "onFilterClick", "onFilterDelete", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardPickerBottomSheetFragment extends TransparentBottomSheet implements OnMTFullCardClickListener, FilterDialogListener, OnFilterClickListener, OnCardLongPressListener, OnCardSelectionListener, UnifiedFiltersListener {
    public static final String TAG = "MTCardPickerBottomSheetFragment";
    private View addFilterLayout;
    private View advancedSearchLayout;
    private TextView btnAllCards;
    private TextView btnMyCollection;
    private MTCardPickerCallback callback;
    private ImageView collapseImageView;
    private TextView collectionReminderTextView;
    private Integer deckId;
    private TextView filterNumberTextView;
    private View filterSummaryLayout;
    private TextView filterSummaryTextView;
    private boolean filtersCollapsed;
    private RecyclerView filtersRecyclerView;
    private ImageView gridImage;
    private boolean isCollectionSearch;
    private CheckBox legalCardsOnlyCheckBox;
    private View legalCardsOnlyLayout;
    private TextView noMatchesTextView;
    private TextView numCardsTextView;
    private RecyclerView recyclerView;
    private TextView searchButton;
    private EditText searchEditText;
    private Job searchJob;
    private LinearLayout searchSourceToggle;
    private String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String initialQuery = "";
    private List<MTFullCard> cards = CollectionsKt.emptyList();
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;
    private String lastQuery = "";

    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/MTCardPickerCallback;", Constants.GP_IAP_TITLE, "initialQuery", "deckId", "", "(Lcom/studiolaganne/lengendarylens/MTCardPickerCallback;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MTCardPickerBottomSheetFragment newInstance$default(Companion companion, MTCardPickerCallback mTCardPickerCallback, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                num = null;
            }
            return companion.newInstance(mTCardPickerCallback, str, str2, num);
        }

        public final MTCardPickerBottomSheetFragment newInstance(MTCardPickerCallback callback, String title, String initialQuery, Integer deckId) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(initialQuery, "initialQuery");
            MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = new MTCardPickerBottomSheetFragment();
            mTCardPickerBottomSheetFragment.callback = callback;
            mTCardPickerBottomSheetFragment.initialQuery = initialQuery;
            mTCardPickerBottomSheetFragment.title = title;
            mTCardPickerBottomSheetFragment.deckId = deckId;
            return mTCardPickerBottomSheetFragment;
        }
    }

    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFilterDelete$1, reason: invalid class name */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFilterDelete$1", f = "MTCardPickerBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $newQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newQuery = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MTCardPickerBottomSheetFragment.this.new AnonymousClass1(this.$newQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MTCardPickerBottomSheetFragment.this.performSearch(this.$newQuery.element);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFilterSubmitButton$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFilterSubmitButton$1", f = "MTCardPickerBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12041(String str, Continuation<? super C12041> continuation) {
            super(2, continuation);
            this.$newQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MTCardPickerBottomSheetFragment.this.new C12041(this.$newQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MTCardPickerBottomSheetFragment.this.performSearch(this.$newQuery);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFiltersApplied$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFiltersApplied$1", f = "MTCardPickerBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scryfallQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12051(String str, Continuation<? super C12051> continuation) {
            super(2, continuation);
            this.$scryfallQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MTCardPickerBottomSheetFragment.this.new C12051(this.$scryfallQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MTCardPickerBottomSheetFragment.this.performSearch(this.$scryfallQuery);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$performSearch$2, reason: invalid class name */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment$performSearch$2", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardsResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass2 implements Callback<MTCardsResponse> {
        AnonymousClass2() {
        }

        static final void onFailure$lambda$1(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
            View view = mTCardPickerBottomSheetFragment.getView();
            View viewFindViewById = view != null ? view.findViewById(R.id.loadingBackgroundView) : null;
            View view2 = mTCardPickerBottomSheetFragment.getView();
            LottieAnimationView lottieAnimationView = view2 != null ? (LottieAnimationView) view2.findViewById(R.id.loadingAnimationView) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(4);
            }
            mTCardPickerBottomSheetFragment.updateCards(CollectionsKt.emptyList());
        }

        static final void onResponse$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment, Response response) {
            List<MTFullCard> listEmptyList;
            View view = mTCardPickerBottomSheetFragment.getView();
            View viewFindViewById = view != null ? view.findViewById(R.id.loadingBackgroundView) : null;
            View view2 = mTCardPickerBottomSheetFragment.getView();
            LottieAnimationView lottieAnimationView = view2 != null ? (LottieAnimationView) view2.findViewById(R.id.loadingAnimationView) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(4);
            }
            if (!response.isSuccessful()) {
                mTCardPickerBottomSheetFragment.updateCards(CollectionsKt.emptyList());
                return;
            }
            MTCardsResponse mTCardsResponse = (MTCardsResponse) response.body();
            if (mTCardsResponse == null || (listEmptyList = mTCardsResponse.getCards()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            mTCardPickerBottomSheetFragment.updateCards(listEmptyList);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTCardsResponse> call, Throwable t) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (MTCardPickerBottomSheetFragment.this.getContext() == null || (activity = MTCardPickerBottomSheetFragment.this.getActivity()) == null) {
                return;
            }
            final MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = MTCardPickerBottomSheetFragment.this;
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$performSearch$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MTCardPickerBottomSheetFragment.AnonymousClass2.onFailure$lambda$1(mTCardPickerBottomSheetFragment);
                }
            });
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTCardsResponse> call, final Response<MTCardsResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            FragmentActivity activity = MTCardPickerBottomSheetFragment.this.getActivity();
            if (activity != null) {
                final MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = MTCardPickerBottomSheetFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$performSearch$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MTCardPickerBottomSheetFragment.AnonymousClass2.onResponse$lambda$0(mTCardPickerBottomSheetFragment, response);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$triggerSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$triggerSearch$1", f = "MTCardPickerBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12071(String str, Continuation<? super C12071> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MTCardPickerBottomSheetFragment.this.new C12071(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!MTCardPickerBottomSheetFragment.this.isAdded()) {
                return Unit.INSTANCE;
            }
            MTCardPickerBottomSheetFragment.this.performSearch(this.$query);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$updateFilterListFromQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MTCardPickerBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$updateFilterListFromQuery$1", f = "MTCardPickerBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12081(String str, Continuation<? super C12081> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12081 c12081 = MTCardPickerBottomSheetFragment.this.new C12081(this.$query, continuation);
            c12081.L$0 = obj;
            return c12081;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!MTCardPickerBottomSheetFragment.this.isAdded()) {
                return Unit.INSTANCE;
            }
            SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(this.$query);
            RecyclerView recyclerView = MTCardPickerBottomSheetFragment.this.filtersRecyclerView;
            ImageView imageView = null;
            TextView textView = null;
            ImageView imageView2 = null;
            ImageView imageView3 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filtersRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
            Context context = MTCardPickerBottomSheetFragment.this.getContext();
            if (context == null) {
                return Unit.INSTANCE;
            }
            boolean z = MTCardPickerBottomSheetFragment.this.filtersCollapsed;
            MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = MTCardPickerBottomSheetFragment.this;
            if (z) {
                View view = mTCardPickerBottomSheetFragment.addFilterLayout;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFilterLayout");
                    view = null;
                }
                view.setVisibility(4);
                RecyclerView recyclerView2 = MTCardPickerBottomSheetFragment.this.filtersRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filtersRecyclerView");
                    recyclerView2 = null;
                }
                recyclerView2.setAdapter(null);
                ImageView imageView4 = MTCardPickerBottomSheetFragment.this.collapseImageView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
                ImageView imageView5 = MTCardPickerBottomSheetFragment.this.collapseImageView;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    imageView5 = null;
                }
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.expand_24));
                View view2 = MTCardPickerBottomSheetFragment.this.filterSummaryLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterSummaryLayout");
                    view2 = null;
                }
                view2.setVisibility(0);
                SearchGroup searchGroup = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                if (searchGroup != null) {
                    MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment2 = MTCardPickerBottomSheetFragment.this;
                    TextView textView2 = mTCardPickerBottomSheetFragment2.filterNumberTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterNumberTextView");
                        textView2 = null;
                    }
                    textView2.setText(String.valueOf(searchGroup.getElements().size()));
                    TextView textView3 = mTCardPickerBottomSheetFragment2.filterSummaryTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterSummaryTextView");
                    } else {
                        textView = textView3;
                    }
                    textView.setText(mTCardPickerBottomSheetFragment2.getResources().getString(R.string.filters_selected));
                }
            } else {
                View view3 = mTCardPickerBottomSheetFragment.filterSummaryLayout;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterSummaryLayout");
                    view3 = null;
                }
                view3.setVisibility(8);
                View view4 = MTCardPickerBottomSheetFragment.this.addFilterLayout;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFilterLayout");
                    view4 = null;
                }
                view4.setVisibility(0);
                ImageView imageView6 = MTCardPickerBottomSheetFragment.this.collapseImageView;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    imageView6 = null;
                }
                imageView6.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.collapse));
                SearchGroup searchGroup2 = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment3 = MTCardPickerBottomSheetFragment.this;
                if (searchGroup2 == null) {
                    RecyclerView recyclerView3 = mTCardPickerBottomSheetFragment3.filtersRecyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filtersRecyclerView");
                        recyclerView3 = null;
                    }
                    recyclerView3.setAdapter(null);
                    ImageView imageView7 = mTCardPickerBottomSheetFragment3.collapseImageView;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    } else {
                        imageView = imageView7;
                    }
                    imageView.setVisibility(8);
                } else if (searchGroup2.getElements().isEmpty()) {
                    RecyclerView recyclerView4 = mTCardPickerBottomSheetFragment3.filtersRecyclerView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filtersRecyclerView");
                        recyclerView4 = null;
                    }
                    recyclerView4.setAdapter(null);
                    ImageView imageView8 = mTCardPickerBottomSheetFragment3.collapseImageView;
                    if (imageView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    } else {
                        imageView2 = imageView8;
                    }
                    imageView2.setVisibility(8);
                } else {
                    FilterListAdapter filterListAdapter = new FilterListAdapter("en", searchGroup2, mTCardPickerBottomSheetFragment3);
                    RecyclerView recyclerView5 = mTCardPickerBottomSheetFragment3.filtersRecyclerView;
                    if (recyclerView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filtersRecyclerView");
                        recyclerView5 = null;
                    }
                    recyclerView5.setAdapter(filterListAdapter);
                    ImageView imageView9 = mTCardPickerBottomSheetFragment3.collapseImageView;
                    if (imageView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                    } else {
                        imageView3 = imageView9;
                    }
                    imageView3.setVisibility(searchGroup2.getElements().size() <= 2 ? 8 : 0);
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final String extractNameQuery(SearchElement searchElement) {
        if (!(searchElement instanceof SearchGroup)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (SearchElement searchElement2 : ((SearchGroup) searchElement).getElements()) {
            if (searchElement2 instanceof SearchCondition) {
                SearchCondition searchCondition = (SearchCondition) searchElement2;
                if (searchCondition.getKeyword() == SearchKeyword.NAME && searchCondition.getInclude()) {
                    arrayList.add(searchCondition.getValue());
                }
            }
        }
        return StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null)).toString();
    }

    private final void initializeViews(View view) {
        View viewFindViewById = view.findViewById(R.id.cards_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.searchEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.searchEditText = (EditText) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.searchButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.searchButton = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.gridImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.gridImage = (ImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.numCardsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.numCardsTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.noMatchesTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.noMatchesTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.advancedSearchLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.advancedSearchLayout = viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.filtersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.filtersRecyclerView = (RecyclerView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.addFilterLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.addFilterLayout = viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.legalCardsOnlyLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.legalCardsOnlyLayout = viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.legalCardsOnlyCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.legalCardsOnlyCheckBox = (CheckBox) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.collapseImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.collapseImageView = (ImageView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.filterSummaryLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.filterSummaryLayout = viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.filterNumberTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.filterNumberTextView = (TextView) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.filterSummaryTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.filterSummaryTextView = (TextView) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.searchSourceToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.searchSourceToggle = (LinearLayout) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.btnAllCards);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.btnAllCards = (TextView) viewFindViewById17;
        View viewFindViewById18 = view.findViewById(R.id.btnMyCollection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.btnMyCollection = (TextView) viewFindViewById18;
        View viewFindViewById19 = view.findViewById(R.id.collectionReminderTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.collectionReminderTextView = (TextView) viewFindViewById19;
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

    static final Unit onCreateView$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        MTCardPickerCallback mTCardPickerCallback = mTCardPickerBottomSheetFragment.callback;
        if (mTCardPickerCallback != null) {
            mTCardPickerCallback.onCardPickerClosed();
        }
        mTCardPickerBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$1(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        Object systemService = mTCardPickerBottomSheetFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = mTCardPickerBottomSheetFragment.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        inputMethodManager.showSoftInput(editText, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void performSearch(String query) {
        Integer num;
        Call callSearchCards$default;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String str = query;
        if (StringsKt.trim((CharSequence) str).toString().length() == 0) {
            updateCards(CollectionsKt.emptyList());
            return;
        }
        if (StringsKt.trim((CharSequence) str).toString().length() < 2) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    MTCardPickerBottomSheetFragment.performSearch$lambda$0(this.f$0);
                }
            });
        }
        if (this.deckId == null) {
            num = null;
        } else {
            CheckBox checkBox = this.legalCardsOnlyCheckBox;
            if (checkBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legalCardsOnlyCheckBox");
                checkBox = null;
            }
            if (checkBox.isChecked()) {
                num = this.deckId;
            }
        }
        SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(query);
        boolean zIsSimpleNameSearch = isSimpleNameSearch(searchQuery);
        String strExtractNameQuery = zIsSimpleNameSearch ? extractNameQuery(searchQuery) : null;
        if (this.isCollectionSearch) {
            MTUser currentUser = preferencesManager.getCurrentUser();
            Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
            if (numValueOf == null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            MTCardPickerBottomSheetFragment.performSearch$lambda$1(this.f$0);
                        }
                    });
                    return;
                }
                return;
            }
            callSearchCards$default = (!zIsSimpleNameSearch || strExtractNameQuery == null || strExtractNameQuery.length() <= 0) ? MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), numValueOf.intValue(), null, query, null, null, null, null, null, num, null, 762, null) : MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), numValueOf.intValue(), strExtractNameQuery, null, null, null, null, null, null, num, null, 764, null);
        } else if (!zIsSimpleNameSearch || strExtractNameQuery == null || strExtractNameQuery.length() <= 0) {
            MTApi mtApi = MTApiKt.getMtApi();
            MTUser currentUser2 = preferencesManager.getCurrentUser();
            callSearchCards$default = MTApi.searchCards$default(mtApi, query, null, null, null, null, null, null, num, null, null, null, null, null, currentUser2 != null ? Integer.valueOf(currentUser2.getId()) : null, 8062, null);
        } else {
            MTApi mtApi2 = MTApiKt.getMtApi();
            MTUser currentUser3 = preferencesManager.getCurrentUser();
            callSearchCards$default = MTApi.searchCards$default(mtApi2, null, strExtractNameQuery, null, null, null, null, null, num, null, null, null, null, null, currentUser3 != null ? Integer.valueOf(currentUser3.getId()) : null, 8061, null);
        }
        callSearchCards$default.enqueue(new AnonymousClass2());
    }

    static final void performSearch$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        View view = mTCardPickerBottomSheetFragment.getView();
        TextView textView = null;
        View viewFindViewById = view != null ? view.findViewById(R.id.loadingBackgroundView) : null;
        View view2 = mTCardPickerBottomSheetFragment.getView();
        LottieAnimationView lottieAnimationView = view2 != null ? (LottieAnimationView) view2.findViewById(R.id.loadingAnimationView) : null;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
        TextView textView2 = mTCardPickerBottomSheetFragment.noMatchesTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noMatchesTextView");
        } else {
            textView = textView2;
        }
        textView.setVisibility(4);
    }

    static final void performSearch$lambda$1(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        View view = mTCardPickerBottomSheetFragment.getView();
        View viewFindViewById = view != null ? view.findViewById(R.id.loadingBackgroundView) : null;
        View view2 = mTCardPickerBottomSheetFragment.getView();
        LottieAnimationView lottieAnimationView = view2 != null ? (LottieAnimationView) view2.findViewById(R.id.loadingAnimationView) : null;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(4);
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(4);
        }
        mTCardPickerBottomSheetFragment.updateCards(CollectionsKt.emptyList());
    }

    private final void selectAllCards() {
        this.isCollectionSearch = false;
        TextView textView = this.btnAllCards;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllCards");
            textView = null;
        }
        textView.setBackgroundResource(R.drawable.type_selected_background);
        TextView textView3 = this.btnAllCards;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllCards");
            textView3 = null;
        }
        textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        TextView textView4 = this.btnMyCollection;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
            textView4 = null;
        }
        textView4.setBackground(null);
        TextView textView5 = this.btnMyCollection;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
        } else {
            textView2 = textView5;
        }
        textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        updateCollectionReminderVisibility();
        if (this.lastQuery.length() > 0) {
            performSearch(this.lastQuery);
        }
    }

    private final void selectMyCollection() {
        this.isCollectionSearch = true;
        TextView textView = this.btnMyCollection;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
            textView = null;
        }
        textView.setBackgroundResource(R.drawable.type_selected_background);
        TextView textView3 = this.btnMyCollection;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
            textView3 = null;
        }
        textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        TextView textView4 = this.btnAllCards;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllCards");
            textView4 = null;
        }
        textView4.setBackground(null);
        TextView textView5 = this.btnAllCards;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllCards");
        } else {
            textView2 = textView5;
        }
        textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        updateCollectionReminderVisibility();
        if (this.lastQuery.length() > 0) {
            performSearch(this.lastQuery);
        }
    }

    private final void setupFilters() {
        ImageView imageView = this.collapseImageView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view2 = this.filterSummaryLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSummaryLayout");
            view2 = null;
        }
        view2.setVisibility(8);
        ImageView imageView2 = this.collapseImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
            imageView2 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupFilters$lambda$0(this.f$0);
            }
        });
        View view3 = this.filterSummaryLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSummaryLayout");
            view3 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(view3, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupFilters$lambda$1(this.f$0);
            }
        });
        View view4 = this.addFilterLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFilterLayout");
        } else {
            view = view4;
        }
        ViewExtensionsKt.setOnClickWithFade(view, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupFilters$lambda$2(this.f$0);
            }
        });
    }

    static final Unit setupFilters$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        mTCardPickerBottomSheetFragment.filtersCollapsed = !mTCardPickerBottomSheetFragment.filtersCollapsed;
        mTCardPickerBottomSheetFragment.updateFilterListFromQuery(mTCardPickerBottomSheetFragment.lastQuery);
        return Unit.INSTANCE;
    }

    static final Unit setupFilters$lambda$1(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        mTCardPickerBottomSheetFragment.filtersCollapsed = !mTCardPickerBottomSheetFragment.filtersCollapsed;
        mTCardPickerBottomSheetFragment.updateFilterListFromQuery(mTCardPickerBottomSheetFragment.lastQuery);
        return Unit.INSTANCE;
    }

    static final Unit setupFilters$lambda$2(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        EditText editText = mTCardPickerBottomSheetFragment.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        UnifiedFiltersBottomSheetFragment.Builder listener = new UnifiedFiltersBottomSheetFragment.Builder().setMode(FilterMode.GENERAL).setCurrentFilters(editText.getText().toString()).setLang("en").setListener(mTCardPickerBottomSheetFragment);
        FragmentManager childFragmentManager = mTCardPickerBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        listener.show(childFragmentManager, "UnifiedFiltersBottomSheet");
        return Unit.INSTANCE;
    }

    private final void setupGridToggle() {
        ImageView imageView = this.gridImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridImage");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupGridToggle$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupGridToggle$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        int i = WhenMappings.$EnumSwitchMapping$0[mTCardPickerBottomSheetFragment.currentLayout.ordinal()];
        ImageView imageView = null;
        if (i == 1) {
            mTCardPickerBottomSheetFragment.currentLayout = CardsLayout.GRID_BY_3;
            ImageView imageView2 = mTCardPickerBottomSheetFragment.gridImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridImage");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.grid_3);
            mTCardPickerBottomSheetFragment.setupRecyclerViewForCurrentLayout();
        } else if (i == 2) {
            mTCardPickerBottomSheetFragment.currentLayout = CardsLayout.LIST;
            ImageView imageView3 = mTCardPickerBottomSheetFragment.gridImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridImage");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.view_list);
            mTCardPickerBottomSheetFragment.setupRecyclerViewForCurrentLayout();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            mTCardPickerBottomSheetFragment.currentLayout = CardsLayout.GRID_BY_2;
            ImageView imageView4 = mTCardPickerBottomSheetFragment.gridImage;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridImage");
            } else {
                imageView = imageView4;
            }
            imageView.setImageResource(R.drawable.grid_2);
            mTCardPickerBottomSheetFragment.setupRecyclerViewForCurrentLayout();
        }
        return Unit.INSTANCE;
    }

    private final void setupLegalCardsOnlyCheckbox() {
        Integer num = this.deckId;
        View view = this.legalCardsOnlyLayout;
        CheckBox checkBox = null;
        if (num == null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legalCardsOnlyLayout");
                view = null;
            }
            view.setVisibility(8);
            return;
        }
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalCardsOnlyLayout");
            view = null;
        }
        view.setVisibility(0);
        CheckBox checkBox2 = this.legalCardsOnlyCheckBox;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalCardsOnlyCheckBox");
        } else {
            checkBox = checkBox2;
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MTCardPickerBottomSheetFragment.setupLegalCardsOnlyCheckbox$lambda$0(this.f$0, compoundButton, z);
            }
        });
    }

    static final void setupLegalCardsOnlyCheckbox$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        EditText editText = mTCardPickerBottomSheetFragment.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        if (string.length() > 0) {
            mTCardPickerBottomSheetFragment.lastQuery = string;
            mTCardPickerBottomSheetFragment.performSearch(string);
        }
    }

    private final void setupRecyclerView() {
        Log.d("MTCardPicker", "Setting up RecyclerView");
        setupRecyclerViewForCurrentLayout();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        Log.d("MTCardPicker", "RecyclerView setup complete, adapter: " + recyclerView.getAdapter());
    }

    private final void setupRecyclerViewForCurrentLayout() {
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.cards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        if (i == 1) {
            ImageView imageView = this.gridImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridImage");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.grid_2);
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
            recyclerView2.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, CardSetsManager.INSTANCE.getCardSets(), false, this, this, this, null, null, 384, null));
            return;
        }
        if (i == 2) {
            ImageView imageView2 = this.gridImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridImage");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.grid_3);
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
            recyclerView4.setAdapter(new MTFullCardsAdapter(browseListCardItemsFromCards, -1, CardSetsManager.INSTANCE.getCardSets(), false, this, this, this, null, null, 384, null));
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ImageView imageView3 = this.gridImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridImage");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.view_list);
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
        recyclerView6.setAdapter(new MTFullCardListAdapter(browseListCardItemsFromCards, -1, this, this, this, null, null, 96, null));
    }

    private final void setupSearch() {
        EditText editText = this.searchEditText;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment.setupSearch.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String strValueOf = String.valueOf(s);
                int length = strValueOf.length();
                MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = MTCardPickerBottomSheetFragment.this;
                TextView textView2 = null;
                if (length == 0) {
                    ImageView imageView = mTCardPickerBottomSheetFragment.collapseImageView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collapseImageView");
                        imageView = null;
                    }
                    imageView.setVisibility(8);
                    View view = MTCardPickerBottomSheetFragment.this.filterSummaryLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterSummaryLayout");
                        view = null;
                    }
                    view.setVisibility(8);
                    MTCardPickerBottomSheetFragment.this.filtersCollapsed = false;
                    TextView textView3 = MTCardPickerBottomSheetFragment.this.noMatchesTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noMatchesTextView");
                        textView3 = null;
                    }
                    textView3.setVisibility(4);
                    TextView textView4 = MTCardPickerBottomSheetFragment.this.searchButton;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchButton");
                        textView4 = null;
                    }
                    textView4.setEnabled(false);
                    TextView textView5 = MTCardPickerBottomSheetFragment.this.searchButton;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchButton");
                    } else {
                        textView2 = textView5;
                    }
                    textView2.setAlpha(0.5f);
                    MTCardPickerBottomSheetFragment.this.updateFilterListFromQuery("");
                    MTCardPickerBottomSheetFragment.this.updateCards(CollectionsKt.emptyList());
                } else {
                    TextView textView6 = mTCardPickerBottomSheetFragment.searchButton;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchButton");
                        textView6 = null;
                    }
                    textView6.setEnabled(true);
                    TextView textView7 = MTCardPickerBottomSheetFragment.this.searchButton;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchButton");
                    } else {
                        textView2 = textView7;
                    }
                    textView2.setAlpha(1.0f);
                }
                MTCardPickerCallback mTCardPickerCallback = MTCardPickerBottomSheetFragment.this.callback;
                if (mTCardPickerCallback != null) {
                    mTCardPickerCallback.onQueryChanged(strValueOf);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText2 = null;
        }
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return MTCardPickerBottomSheetFragment.setupSearch$lambda$0(this.f$0, textView2, i, keyEvent);
            }
        });
        TextView textView2 = this.searchButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchButton");
        } else {
            textView = textView2;
        }
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupSearch$lambda$1(this.f$0);
            }
        });
    }

    static final boolean setupSearch$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        mTCardPickerBottomSheetFragment.triggerSearch();
        Object systemService = mTCardPickerBottomSheetFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final Unit setupSearch$lambda$1(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        mTCardPickerBottomSheetFragment.triggerSearch();
        return Unit.INSTANCE;
    }

    private final void setupSearchSourceToggle() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean z = new PreferencesManager(contextRequireContext).getCurrentUser() != null;
        NetworkHelper networkHelper = NetworkHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        final boolean z2 = z && networkHelper.isNetworkAvailable(contextRequireContext2);
        TextView textView = this.btnMyCollection;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
            textView = null;
        }
        textView.setAlpha(z2 ? 1.0f : 0.5f);
        TextView textView3 = this.btnAllCards;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllCards");
            textView3 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupSearchSourceToggle$lambda$0(this.f$0);
            }
        });
        TextView textView4 = this.btnMyCollection;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMyCollection");
        } else {
            textView2 = textView4;
        }
        ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.setupSearchSourceToggle$lambda$1(z2, this);
            }
        });
    }

    static final Unit setupSearchSourceToggle$lambda$0(MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        mTCardPickerBottomSheetFragment.selectAllCards();
        return Unit.INSTANCE;
    }

    static final Unit setupSearchSourceToggle$lambda$1(boolean z, MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment) {
        if (z) {
            mTCardPickerBottomSheetFragment.selectMyCollection();
        }
        return Unit.INSTANCE;
    }

    private final void triggerSearch() {
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        if (StringsKt.trim((CharSequence) string).toString().length() == 0) {
            return;
        }
        this.lastQuery = string;
        updateFilterListFromQuery(string);
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new C12071(string, null), 2, null);
    }

    private final void updateCardCount() {
        boolean zIsEmpty = this.cards.isEmpty();
        TextView textView = this.numCardsTextView;
        TextView textView2 = null;
        if (zIsEmpty) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numCardsTextView");
                textView = null;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numCardsTextView");
            textView = null;
        }
        textView.setVisibility(0);
        int size = this.cards.size();
        TextView textView3 = this.numCardsTextView;
        if (size == 1) {
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numCardsTextView");
            } else {
                textView2 = textView3;
            }
            textView2.setText(getResources().getString(R.string.one_card));
            return;
        }
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numCardsTextView");
        } else {
            textView2 = textView3;
        }
        String string = getResources().getString(R.string.x_cards);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView2.setText(StringsKt.replace$default(string, "{1}", String.valueOf(this.cards.size()), false, 4, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCards(List<MTFullCard> newCards) {
        this.cards = newCards;
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        TextView textView = null;
        if (i == 1 || i == 2) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            MTFullCardsAdapter mTFullCardsAdapter = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
            if (mTFullCardsAdapter != null) {
                mTFullCardsAdapter.updateCards(newCards);
            }
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
            MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
            if (mTFullCardListAdapter != null) {
                mTFullCardListAdapter.updateCards(newCards);
            }
        }
        updateCardCount();
        updateCollectionReminderVisibility();
        if (!newCards.isEmpty() || this.lastQuery.length() <= 0) {
            TextView textView2 = this.noMatchesTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMatchesTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(4);
            return;
        }
        TextView textView3 = this.noMatchesTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noMatchesTextView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(0);
    }

    private final void updateCollectionReminderVisibility() {
        TextView textView = this.collectionReminderTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionReminderTextView");
            textView = null;
        }
        textView.setVisibility((!this.isCollectionSearch || this.cards.isEmpty()) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterListFromQuery(String query) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C12081(query, null), 3, null);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Log.d("MTCardPicker", "Creating view with layout fragment_mt_card_picker");
        View viewInflate = inflater.inflate(R.layout.fragment_mt_card_picker, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTCardPickerBottomSheetFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("mt_card_picker_opened", null);
        return viewInflate;
    }

    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterClick(final SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        final String string = editText.getText().toString();
        new FilterDialogFragment.Builder().setSearchElement(filter).setLang("en").setListener(new FilterDialogListener() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$onFilterClick$filterDialog$1
            @Override // com.studiolaganne.lengendarylens.FilterDialogListener
            public void onFilterSubmitButton(SearchCondition newFilter) {
                Intrinsics.checkNotNullParameter(newFilter, "newFilter");
                String strReplace$default = StringsKt.replace$default(string, filter.getOriginalToken(), newFilter.toShortString(), false, 4, (Object) null);
                EditText editText2 = this.searchEditText;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                    editText2 = null;
                }
                editText2.setText(strReplace$default);
                this.updateFilterListFromQuery(strReplace$default);
                this.lastQuery = strReplace$default;
                MTCardPickerCallback mTCardPickerCallback = this.callback;
                if (mTCardPickerCallback != null) {
                    mTCardPickerCallback.onQueryChanged(strReplace$default);
                }
                Job job = this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = this;
                LifecycleOwner viewLifecycleOwner = mTCardPickerBottomSheetFragment.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                mTCardPickerBottomSheetFragment.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new MTCardPickerBottomSheetFragment$onFilterClick$filterDialog$1$onFilterSubmitButton$1(this, strReplace$default, null), 2, null);
            }
        }).build().show(getChildFragmentManager(), "FilterDialogFragment");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterDelete(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        EditText editText = this.searchEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = StringsKt.replace$default(string, filter.getOriginalToken(), "", false, 4, (Object) null);
        objectRef.element = StringsKt.replace$default((String) objectRef.element, "  ", " ", false, 4, (Object) null);
        if (StringsKt.trim((CharSequence) objectRef.element).toString().length() <= 0) {
            this.lastQuery = "";
            MTCardPickerCallback mTCardPickerCallback = this.callback;
            if (mTCardPickerCallback != null) {
                mTCardPickerCallback.onQueryChanged("");
            }
            EditText editText3 = this.searchEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            } else {
                editText2 = editText3;
            }
            editText2.setText("");
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
            updateCards(CollectionsKt.emptyList());
            return;
        }
        EditText editText4 = this.searchEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText4 = null;
        }
        editText4.setText((CharSequence) objectRef.element);
        updateFilterListFromQuery((String) objectRef.element);
        this.lastQuery = (String) objectRef.element;
        MTCardPickerCallback mTCardPickerCallback2 = this.callback;
        if (mTCardPickerCallback2 != null) {
            mTCardPickerCallback2.onQueryChanged((String) objectRef.element);
        }
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new AnonymousClass1(objectRef, null), 2, null);
    }

    @Override // com.studiolaganne.lengendarylens.FilterDialogListener
    public void onFilterSubmitButton(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        int length = string.length();
        String shortString = filter.toShortString();
        if (length > 0) {
            shortString = string + " " + shortString;
        }
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText2 = null;
        }
        editText2.setText(shortString);
        updateFilterListFromQuery(shortString);
        this.lastQuery = shortString;
        MTCardPickerCallback mTCardPickerCallback = this.callback;
        if (mTCardPickerCallback != null) {
            mTCardPickerCallback.onQueryChanged(shortString);
        }
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new C12041(shortString, null), 2, null);
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
        updateFilterListFromQuery(scryfallQuery);
        if (StringsKt.trim((CharSequence) str).toString().length() <= 0) {
            this.lastQuery = "";
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
            return;
        }
        this.lastQuery = scryfallQuery;
        MTCardPickerCallback mTCardPickerCallback = this.callback;
        if (mTCardPickerCallback != null) {
            mTCardPickerCallback.onQueryChanged(scryfallQuery);
        }
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new C12051(scryfallQuery, null), 2, null);
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(MTFullCard card, int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        MTCardPickerCallback mTCardPickerCallback = this.callback;
        if (mTCardPickerCallback != null) {
            mTCardPickerCallback.onCardSelected(card);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
        Intrinsics.checkNotNullParameter(card, "card");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View viewFindViewById;
        super.onStart();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null || (viewFindViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setDraggable(false);
        bottomSheetBehaviorFrom.setExpandedOffset(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.titleTextView)).setText(getString(R.string.select_card));
        String str = this.title;
        if (str != null) {
            ((TextView) view.findViewById(R.id.titleTextView)).setText(str);
        }
        initializeViews(view);
        setupSearch();
        setupGridToggle();
        setupFilters();
        setupLegalCardsOnlyCheckbox();
        setupSearchSourceToggle();
        setupRecyclerView();
        updateCardCount();
        View viewFindViewById = view.findViewById(R.id.loadingBackgroundView);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loadingAnimationView);
        viewFindViewById.setVisibility(4);
        lottieAnimationView.setVisibility(4);
        int length = this.initialQuery.length();
        EditText editText = this.searchEditText;
        EditText editText2 = null;
        if (length > 0) {
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            editText.setText(this.initialQuery);
            String str2 = this.initialQuery;
            this.lastQuery = str2;
            performSearch(str2);
            return;
        }
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        editText.requestFocus();
        EditText editText3 = this.searchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        } else {
            editText2 = editText3;
        }
        editText2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MTCardPickerBottomSheetFragment.onViewCreated$lambda$1(this.f$0);
            }
        }, 300L);
    }
}
