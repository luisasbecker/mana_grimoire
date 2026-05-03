package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.actions.SearchIntents;
import com.studiolaganne.lengendarylens.SearchMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.ResponseBody;
import org.opencv.videoio.Videoio;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: compiled from: CardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJb\u00100\u001a\u0002012\u0006\u00102\u001a\u00020#2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u00010#2\n\b\u0002\u00106\u001a\u0004\u0018\u00010#2\n\b\u0002\u00107\u001a\u0004\u0018\u00010#2\b\b\u0002\u00108\u001a\u00020\u00132\b\b\u0002\u00109\u001a\u00020\u00132\b\b\u0002\u0010:\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010;J$\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00052\u0006\u00102\u001a\u00020#2\u0006\u00108\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010>J@\u0010?\u001a\u0002012\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010#2\b\u00106\u001a\u0004\u0018\u00010#2\b\u00107\u001a\u0004\u0018\u00010#2\b\b\u0002\u00109\u001a\u00020\u0013H\u0002J*\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005H\u0002J\u000e\u0010C\u001a\u000201H\u0082@¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u0002012\u0006\u00102\u001a\u00020#2\u0006\u00108\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010>J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020HH\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010#2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0002J\n\u0010K\u001a\u00020\u000f*\u00020=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "databaseHelpers", "", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "context", "Landroid/content/Context;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;Lcom/studiolaganne/lengendarylens/PreferencesManager;Landroid/content/Context;)V", "searchResults", "Landroidx/lifecycle/MutableLiveData;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getSearchResults", "()Landroidx/lifecycle/MutableLiveData;", "emptyResult", "", "getEmptyResult", "searchMode", "Lcom/studiolaganne/lengendarylens/SearchMode;", "getSearchMode", "paginationState", "Lcom/studiolaganne/lengendarylens/SearchPaginationState;", "getPaginationState", "groupedResults", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "getGroupedResults", "_mergedResults", "", "apiJob", "Lkotlinx/coroutines/Job;", "currentLanguage", "", "getCurrentLanguage", "()Ljava/lang/String;", "setCurrentLanguage", "(Ljava/lang/String;)V", "searchLanguageFilter", "getSearchLanguageFilter", "setSearchLanguageFilter", "currentQuery", "currentSortBy", "currentGroupBy", "currentSortDirection", "currentIsCollectionSearch", "searchCards", "", SearchIntents.EXTRA_QUERY, "page", "", "sortBy", "groupBy", "sortDirection", "condense", "isCollectionSearch", "forceLocalDb", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performLocalSearch", "Lcom/studiolaganne/lengendarylens/CardRecord;", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchOnline", "mergeGroupedResults", "existing", "newGroups", "handleSearchError", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchOffline", "isSimpleNameSearch", "searchElement", "Lcom/studiolaganne/lengendarylens/SearchElement;", "extractInlineLanguage", "extractNameQuery", "toMTFullCard", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardSearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Set<MTFullCard> _mergedResults;
    private Job apiJob;
    private final Context context;
    private String currentGroupBy;
    private boolean currentIsCollectionSearch;
    private String currentLanguage;
    private String currentQuery;
    private String currentSortBy;
    private String currentSortDirection;
    private final MTGDBHelper databaseHelper;
    private final List<MTGDBHelperLocalized> databaseHelpers;
    private final MutableLiveData<Boolean> emptyResult;
    private final MutableLiveData<List<MTCardGroup>> groupedResults;
    private final MutableLiveData<SearchPaginationState> paginationState;
    private final PreferencesManager prefs;
    private String searchLanguageFilter;
    private final MutableLiveData<SearchMode> searchMode;
    private final MutableLiveData<List<MTFullCard>> searchResults;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$handleSearchError$2, reason: invalid class name */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel$handleSearchError$2", f = "CardSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CardSearchViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchPaginationState searchPaginationState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutableLiveData<SearchPaginationState> paginationState = CardSearchViewModel.this.getPaginationState();
            SearchPaginationState value = CardSearchViewModel.this.getPaginationState().getValue();
            if (value == null || (searchPaginationState = SearchPaginationState.copy$default(value, 0, 0, false, false, 7, null)) == null) {
                searchPaginationState = new SearchPaginationState(0, 0, false, false, 7, null);
            }
            paginationState.postValue(searchPaginationState);
            CardSearchViewModel.this.getEmptyResult().postValue(Boxing.boxBoolean(true));
            CardSearchViewModel.this.getSearchResults().postValue(CollectionsKt.emptyList());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchCards$1, reason: invalid class name */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel", f = "CardSearchViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {100, Videoio.CAP_PROP_OPENNI2_SYNC}, m = "searchCards", n = {SearchIntents.EXTRA_QUERY, "sortBy", "groupBy", "sortDirection", "mode", "page", "condense", "isCollectionSearch", "forceLocalDb", "effectiveCondense", SearchIntents.EXTRA_QUERY, "sortBy", "groupBy", "sortDirection", "mode", "page", "condense", "isCollectionSearch", "forceLocalDb", "effectiveCondense"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "Z$1", "Z$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "Z$1", "Z$2", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CardSearchViewModel.this.searchCards(null, 0, null, null, null, false, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchCards$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel$searchCards$2", f = "CardSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SearchMode $mode;
        final /* synthetic */ int $page;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11282(SearchMode searchMode, int i, Continuation<? super C11282> continuation) {
            super(2, continuation);
            this.$mode = searchMode;
            this.$page = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CardSearchViewModel.this.new C11282(this.$mode, this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchPaginationState searchPaginationState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CardSearchViewModel.this.getSearchMode().postValue(this.$mode);
            MutableLiveData<SearchPaginationState> paginationState = CardSearchViewModel.this.getPaginationState();
            SearchPaginationState value = CardSearchViewModel.this.getPaginationState().getValue();
            if (value == null || (searchPaginationState = SearchPaginationState.copy$default(value, this.$page, 0, false, true, 6, null)) == null) {
                searchPaginationState = new SearchPaginationState(this.$page, 0, false, true, 6, null);
            }
            paginationState.postValue(searchPaginationState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchOffline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel", f = "CardSearchViewModel.kt", i = {0, 0, 1, 1, 1, 1}, l = {338, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS}, m = "searchOffline", n = {SearchIntents.EXTRA_QUERY, "condense", SearchIntents.EXTRA_QUERY, "localResults", "localMTFullCards", "condense"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 1)
    static final class C11291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11291(Continuation<? super C11291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CardSearchViewModel.this.searchOffline(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchOffline$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel$searchOffline$2", f = "CardSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<MTFullCard> $localMTFullCards;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11302(List<MTFullCard> list, Continuation<? super C11302> continuation) {
            super(2, continuation);
            this.$localMTFullCards = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CardSearchViewModel.this.new C11302(this.$localMTFullCards, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CardSearchViewModel.this.getPaginationState().postValue(new SearchPaginationState(1, this.$localMTFullCards.size(), false, false));
            boolean zIsEmpty = this.$localMTFullCards.isEmpty();
            CardSearchViewModel cardSearchViewModel = CardSearchViewModel.this;
            if (zIsEmpty) {
                cardSearchViewModel.getEmptyResult().postValue(Boxing.boxBoolean(true));
            } else {
                cardSearchViewModel.getEmptyResult().postValue(Boxing.boxBoolean(false));
            }
            CardSearchViewModel.this.getSearchResults().postValue(this.$localMTFullCards);
            CardSearchViewModel.this.getGroupedResults().postValue(CollectionsKt.emptyList());
            CardSearchViewModel.this._mergedResults.clear();
            return Boxing.boxBoolean(CardSearchViewModel.this._mergedResults.addAll(this.$localMTFullCards));
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchOnline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel$searchOnline$1", f = "CardSearchViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}, l = {158, 233, 280, 284}, m = "invokeSuspend", n = {"utils", "searchElement", "nameQuery", "inlineLang", "effectiveQuery", "userId", "isSimpleName", "hasLangFilter", "utils", "searchElement", "nameQuery", "inlineLang", "effectiveQuery", NotificationCompat.CATEGORY_CALL, "response", "body", "pagination", "isSimpleName", "hasLangFilter", "utils", "searchElement", "nameQuery", "inlineLang", "effectiveQuery", NotificationCompat.CATEGORY_CALL, "response", "isSimpleName", "hasLangFilter", "e"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0"}, v = 1)
    static final class C11311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $groupBy;
        final /* synthetic */ boolean $isCollectionSearch;
        final /* synthetic */ int $page;
        final /* synthetic */ String $query;
        final /* synthetic */ String $sortBy;
        final /* synthetic */ String $sortDirection;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        final /* synthetic */ CardSearchViewModel this$0;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CardSearchViewModel$searchOnline$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CardSearchViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.CardSearchViewModel$searchOnline$1$1", f = "CardSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MTCardsResponse $body;
            final /* synthetic */ String $groupBy;
            final /* synthetic */ int $page;
            final /* synthetic */ MTPagination $pagination;
            int label;
            final /* synthetic */ CardSearchViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02001(CardSearchViewModel cardSearchViewModel, int i, MTPagination mTPagination, MTCardsResponse mTCardsResponse, String str, Continuation<? super C02001> continuation) {
                super(2, continuation);
                this.this$0 = cardSearchViewModel;
                this.$page = i;
                this.$pagination = mTPagination;
                this.$body = mTCardsResponse;
                this.$groupBy = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02001(this.this$0, this.$page, this.$pagination, this.$body, this.$groupBy, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List<MTFullCard> listEmptyList;
                Boolean has_next;
                Integer total;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutableLiveData<SearchPaginationState> paginationState = this.this$0.getPaginationState();
                int i = this.$page;
                MTPagination mTPagination = this.$pagination;
                boolean z = false;
                int iIntValue = (mTPagination == null || (total = mTPagination.getTotal()) == null) ? 0 : total.intValue();
                MTPagination mTPagination2 = this.$pagination;
                paginationState.postValue(new SearchPaginationState(i, iIntValue, (mTPagination2 == null || (has_next = mTPagination2.getHas_next()) == null) ? false : has_next.booleanValue(), false));
                MTCardsResponse mTCardsResponse = this.$body;
                List<MTCardGroup> grouped_cards = mTCardsResponse != null ? mTCardsResponse.getGrouped_cards() : null;
                if (this.$groupBy == null || grouped_cards == null) {
                    MTCardsResponse mTCardsResponse2 = this.$body;
                    if (mTCardsResponse2 == null || (listEmptyList = mTCardsResponse2.getCards()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    int i2 = this.$page;
                    CardSearchViewModel cardSearchViewModel = this.this$0;
                    if (i2 == 1) {
                        cardSearchViewModel._mergedResults.clear();
                        this.this$0._mergedResults.addAll(listEmptyList);
                        this.this$0.getSearchResults().postValue(listEmptyList);
                        this.this$0.getGroupedResults().postValue(CollectionsKt.emptyList());
                    } else {
                        cardSearchViewModel._mergedResults.addAll(listEmptyList);
                        this.this$0.getSearchResults().postValue(CollectionsKt.toList(this.this$0._mergedResults));
                        this.this$0.getGroupedResults().postValue(CollectionsKt.emptyList());
                    }
                    MutableLiveData<Boolean> emptyResult = this.this$0.getEmptyResult();
                    if (listEmptyList.isEmpty() && this.$page == 1) {
                        z = true;
                    }
                    emptyResult.postValue(Boxing.boxBoolean(z));
                } else {
                    int i3 = this.$page;
                    CardSearchViewModel cardSearchViewModel2 = this.this$0;
                    if (i3 == 1) {
                        cardSearchViewModel2.getGroupedResults().postValue(grouped_cards);
                        this.this$0.getSearchResults().postValue(CollectionsKt.emptyList());
                        this.this$0._mergedResults.clear();
                    } else {
                        List<MTCardGroup> value = cardSearchViewModel2.getGroupedResults().getValue();
                        if (value == null) {
                            value = CollectionsKt.emptyList();
                        }
                        this.this$0.getGroupedResults().postValue(this.this$0.mergeGroupedResults(value, grouped_cards));
                        this.this$0.getSearchResults().postValue(CollectionsKt.emptyList());
                    }
                    MutableLiveData<Boolean> emptyResult2 = this.this$0.getEmptyResult();
                    if (grouped_cards.isEmpty() && this.$page == 1) {
                        z = true;
                    }
                    emptyResult2.postValue(Boxing.boxBoolean(z));
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11311(String str, CardSearchViewModel cardSearchViewModel, boolean z, int i, String str2, String str3, String str4, Continuation<? super C11311> continuation) {
            super(2, continuation);
            this.$query = str;
            this.this$0 = cardSearchViewModel;
            this.$isCollectionSearch = z;
            this.$page = i;
            this.$groupBy = str2;
            this.$sortBy = str3;
            this.$sortDirection = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11311(this.$query, this.this$0, this.$isCollectionSearch, this.$page, this.$groupBy, this.$sortBy, this.$sortDirection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x03f1, code lost:
        
            if (r49.this$0.handleSearchError(r49) != r2) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x03c2, code lost:
        
            if (r49.this$0.handleSearchError(r49) == r2) goto L102;
         */
        /* JADX WARN: Removed duplicated region for block: B:85:0x02f8 A[Catch: Exception -> 0x03c5, TryCatch #0 {Exception -> 0x03c5, blocks: (B:12:0x0047, B:16:0x006d, B:48:0x0135, B:19:0x0075, B:21:0x0089, B:23:0x0092, B:25:0x009a, B:32:0x00b1, B:36:0x00be, B:38:0x00e0, B:40:0x00e6, B:42:0x00f2, B:45:0x00fe, B:51:0x013a, B:83:0x02ee, B:85:0x02f8, B:87:0x0302, B:89:0x030b, B:92:0x036d, B:94:0x0373, B:96:0x0379, B:55:0x0173, B:57:0x017c, B:58:0x01ad, B:62:0x01ea, B:64:0x01fa, B:66:0x0207, B:71:0x0246, B:73:0x0250, B:75:0x0260, B:77:0x026d, B:78:0x029d, B:80:0x02af, B:82:0x02bc, B:35:0x00bc), top: B:105:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x036d A[Catch: Exception -> 0x03c5, TryCatch #0 {Exception -> 0x03c5, blocks: (B:12:0x0047, B:16:0x006d, B:48:0x0135, B:19:0x0075, B:21:0x0089, B:23:0x0092, B:25:0x009a, B:32:0x00b1, B:36:0x00be, B:38:0x00e0, B:40:0x00e6, B:42:0x00f2, B:45:0x00fe, B:51:0x013a, B:83:0x02ee, B:85:0x02f8, B:87:0x0302, B:89:0x030b, B:92:0x036d, B:94:0x0373, B:96:0x0379, B:55:0x0173, B:57:0x017c, B:58:0x01ad, B:62:0x01ea, B:64:0x01fa, B:66:0x0207, B:71:0x0246, B:73:0x0250, B:75:0x0260, B:77:0x026d, B:78:0x029d, B:80:0x02af, B:82:0x02bc, B:35:0x00bc), top: B:105:0x0010 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String str;
            int i;
            String str2;
            String str3;
            Call callSearchCards$default;
            Response responseExecute;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
            } catch (Exception e) {
                Log.e("CardSearch", "Error fetching API results", e);
                this.L$0 = SpillingKt.nullOutSpilledVariable(e);
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.label = 4;
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
            SearchElement searchQuery = companion.parseSearchQuery(this.$query);
            boolean zIsSimpleNameSearch = this.this$0.isSimpleNameSearch(searchQuery);
            String strExtractNameQuery = zIsSimpleNameSearch ? this.this$0.extractNameQuery(searchQuery) : null;
            String strExtractInlineLanguage = this.this$0.extractInlineLanguage(searchQuery);
            int i3 = (strExtractInlineLanguage != null || this.this$0.getSearchLanguageFilter().length() <= 0) ? 0 : 1;
            if (i3 != 0) {
                str = ((!zIsSimpleNameSearch || strExtractNameQuery == null || strExtractNameQuery.length() <= 0) ? this.$query : strExtractNameQuery) + " lang:" + this.this$0.getSearchLanguageFilter();
            } else {
                str = null;
            }
            if (this.$isCollectionSearch) {
                MTUser currentUser = this.this$0.prefs.getCurrentUser();
                Integer numBoxInt = currentUser != null ? Boxing.boxInt(currentUser.getId()) : null;
                if (numBoxInt == null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(companion);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(searchQuery);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(strExtractNameQuery);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(strExtractInlineLanguage);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                    this.Z$0 = zIsSimpleNameSearch;
                    this.I$0 = i3;
                    this.label = 1;
                    if (this.this$0.handleSearchError(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (str != null) {
                    callSearchCards$default = MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), numBoxInt.intValue(), null, str, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, null, 770, null);
                    i = i3;
                    str3 = str;
                    responseExecute = callSearchCards$default.execute();
                    if (!responseExecute.isSuccessful()) {
                        MTCardsResponse mTCardsResponse = (MTCardsResponse) responseExecute.body();
                        MTPagination pagination = mTCardsResponse != null ? mTCardsResponse.getPagination() : null;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(companion);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(searchQuery);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(strExtractNameQuery);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(strExtractInlineLanguage);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(callSearchCards$default);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(responseExecute);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(mTCardsResponse);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(pagination);
                        this.Z$0 = zIsSimpleNameSearch;
                        this.I$0 = i;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C02001(this.this$0, this.$page, pagination, mTCardsResponse, this.$groupBy, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    ResponseBody responseBodyErrorBody = responseExecute.errorBody();
                    Log.e("CardSearch", "API search error: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(companion);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(searchQuery);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(strExtractNameQuery);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(strExtractInlineLanguage);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(callSearchCards$default);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(responseExecute);
                    this.Z$0 = zIsSimpleNameSearch;
                    this.I$0 = i;
                    this.label = 3;
                } else {
                    String str4 = str;
                    if (!zIsSimpleNameSearch || strExtractNameQuery == null || strExtractNameQuery.length() <= 0) {
                        i = i3;
                        str2 = strExtractNameQuery;
                        callSearchCards$default = MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), numBoxInt.intValue(), null, this.$query, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, null, 770, null);
                    } else {
                        i = i3;
                        callSearchCards$default = MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), numBoxInt.intValue(), strExtractNameQuery, null, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, null, 772, null);
                        str2 = strExtractNameQuery;
                    }
                    str3 = str4;
                    strExtractNameQuery = str2;
                    responseExecute = callSearchCards$default.execute();
                    if (!responseExecute.isSuccessful()) {
                    }
                }
            } else {
                i = i3;
                str2 = strExtractNameQuery;
                String str5 = str;
                if (str5 != null) {
                    MTApi mtApi = MTApiKt.getMtApi();
                    MTUser currentUser2 = this.this$0.prefs.getCurrentUser();
                    callSearchCards$default = MTApi.searchCards$default(mtApi, str5, null, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, Boxing.boxBoolean(true), null, null, null, null, currentUser2 != null ? Boxing.boxInt(currentUser2.getId()) : null, 7810, null);
                    str3 = str5;
                    strExtractNameQuery = str2;
                    responseExecute = callSearchCards$default.execute();
                    if (!responseExecute.isSuccessful()) {
                    }
                } else {
                    str3 = str5;
                    if (!zIsSimpleNameSearch || str2 == null || str2.length() <= 0) {
                        strExtractNameQuery = str2;
                        MTApi mtApi2 = MTApiKt.getMtApi();
                        MTUser currentUser3 = this.this$0.prefs.getCurrentUser();
                        callSearchCards$default = MTApi.searchCards$default(mtApi2, this.$query, null, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, Boxing.boxBoolean(true), null, null, null, null, currentUser3 != null ? Boxing.boxInt(currentUser3.getId()) : null, 7810, null);
                    } else {
                        MTApi mtApi3 = MTApiKt.getMtApi();
                        MTUser currentUser4 = this.this$0.prefs.getCurrentUser();
                        strExtractNameQuery = str2;
                        callSearchCards$default = MTApi.searchCards$default(mtApi3, null, strExtractNameQuery, Boxing.boxInt(this.$page), Boxing.boxInt(50), this.$groupBy, this.$sortBy, this.$sortDirection, null, Boxing.boxBoolean(true), null, null, null, null, currentUser4 != null ? Boxing.boxInt(currentUser4.getId()) : null, 7809, null);
                    }
                    responseExecute = callSearchCards$default.execute();
                    if (!responseExecute.isSuccessful()) {
                    }
                }
            }
        }
    }

    public CardSearchViewModel(MTGDBHelper databaseHelper, List<MTGDBHelperLocalized> databaseHelpers, PreferencesManager prefs, Context context) {
        Intrinsics.checkNotNullParameter(databaseHelper, "databaseHelper");
        Intrinsics.checkNotNullParameter(databaseHelpers, "databaseHelpers");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(context, "context");
        this.databaseHelper = databaseHelper;
        this.databaseHelpers = databaseHelpers;
        this.prefs = prefs;
        this.context = context;
        this.searchResults = new MutableLiveData<>();
        this.emptyResult = new MutableLiveData<>();
        this.searchMode = new MutableLiveData<>();
        this.paginationState = new MutableLiveData<>();
        this.groupedResults = new MutableLiveData<>();
        this._mergedResults = new LinkedHashSet();
        this.currentLanguage = "en";
        this.searchLanguageFilter = "";
        this.currentQuery = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractInlineLanguage(SearchElement searchElement) {
        Object next;
        if (!(searchElement instanceof SearchGroup)) {
            return null;
        }
        List<SearchElement> elements = ((SearchGroup) searchElement).getElements();
        ArrayList arrayList = new ArrayList();
        for (Object obj : elements) {
            if (obj instanceof SearchCondition) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SearchCondition searchCondition = (SearchCondition) next;
            if (searchCondition.getKeyword() == SearchKeyword.LANGUAGE && searchCondition.getInclude()) {
                break;
            }
        }
        SearchCondition searchCondition2 = (SearchCondition) next;
        if (searchCondition2 != null) {
            return searchCondition2.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractNameQuery(SearchElement searchElement) {
        if (!(searchElement instanceof SearchGroup)) {
            return "";
        }
        List<SearchElement> elements = ((SearchGroup) searchElement).getElements();
        ArrayList arrayList = new ArrayList();
        for (Object obj : elements) {
            if (obj instanceof SearchCondition) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            SearchCondition searchCondition = (SearchCondition) obj2;
            if (searchCondition.getKeyword() == SearchKeyword.NAME && searchCondition.getInclude()) {
                arrayList2.add(obj2);
            }
        }
        return StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList2, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.CardSearchViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return CardSearchViewModel.extractNameQuery$lambda$1((SearchCondition) obj3);
            }
        }, 30, null)).toString();
    }

    static final CharSequence extractNameQuery$lambda$1(SearchCondition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSearchError(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSimpleNameSearch(SearchElement searchElement) {
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
    public final List<MTCardGroup> mergeGroupedResults(List<MTCardGroup> existing, List<MTCardGroup> newGroups) {
        ArrayList arrayList;
        List<MTCardGroup> mutableList = CollectionsKt.toMutableList((Collection) existing);
        for (MTCardGroup mTCardGroup : newGroups) {
            Iterator<MTCardGroup> it = mutableList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getType(), mTCardGroup.getType())) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                MTCardGroup mTCardGroup2 = mutableList.get(i);
                List<MTFullCard> cards = mTCardGroup2.getCards();
                if (cards == null || (arrayList = CollectionsKt.toMutableList((Collection) cards)) == null) {
                    arrayList = new ArrayList();
                }
                List<MTFullCard> cards2 = mTCardGroup.getCards();
                if (cards2 == null) {
                    cards2 = CollectionsKt.emptyList();
                }
                arrayList.addAll(cards2);
                mutableList.set(i, new MTCardGroup(mTCardGroup2.getType(), arrayList.size(), mTCardGroup.getTotal_count(), arrayList));
            } else {
                mutableList.add(mTCardGroup);
            }
        }
        return mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performLocalSearch(String str, boolean z, Continuation<? super List<CardRecord>> continuation) {
        Object next;
        ArrayList arrayList = new ArrayList();
        SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(str);
        if (Intrinsics.areEqual(this.currentLanguage, "en")) {
            arrayList.addAll(this.databaseHelper.getFullCardsBySearchQuery(searchQuery, z));
            return arrayList;
        }
        Iterator<T> it = this.databaseHelpers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((MTGDBHelperLocalized) next).getLocale(), this.currentLanguage)) {
                break;
            }
        }
        MTGDBHelperLocalized mTGDBHelperLocalized = (MTGDBHelperLocalized) next;
        if (mTGDBHelperLocalized != null) {
            Boxing.boxBoolean(arrayList.addAll(mTGDBHelperLocalized.getFullCardsBySearchQueryWithFolding(searchQuery, z)));
        }
        arrayList.addAll(this.databaseHelper.getFullCardsBySearchQuery(searchQuery, z));
        return arrayList;
    }

    public static /* synthetic */ Object searchCards$default(CardSearchViewModel cardSearchViewModel, String str, int i, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        if ((i2 & 32) != 0) {
            z = true;
        }
        if ((i2 & 64) != 0) {
            z2 = false;
        }
        if ((i2 & 128) != 0) {
            z3 = false;
        }
        return cardSearchViewModel.searchCards(str, i, str2, str3, str4, z, z2, z3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b6, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r5, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchOffline(String str, boolean z, Continuation<? super Unit> continuation) {
        C11291 c11291;
        if (continuation instanceof C11291) {
            c11291 = (C11291) continuation;
            if ((c11291.label & Integer.MIN_VALUE) != 0) {
                c11291.label -= Integer.MIN_VALUE;
            } else {
                c11291 = new C11291(continuation);
            }
        }
        Object objPerformLocalSearch = c11291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11291.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objPerformLocalSearch);
            c11291.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c11291.Z$0 = z;
            c11291.label = 1;
            objPerformLocalSearch = performLocalSearch(str, z, c11291);
            if (objPerformLocalSearch != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c11291.Z$0;
            ResultKt.throwOnFailure(objPerformLocalSearch);
            return Unit.INSTANCE;
        }
        z = c11291.Z$0;
        str = (String) c11291.L$0;
        ResultKt.throwOnFailure(objPerformLocalSearch);
        List list = (List) objPerformLocalSearch;
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toMTFullCard((CardRecord) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        C11302 c11302 = new C11302(arrayList2, null);
        c11291.L$0 = SpillingKt.nullOutSpilledVariable(str);
        c11291.L$1 = SpillingKt.nullOutSpilledVariable(list);
        c11291.L$2 = SpillingKt.nullOutSpilledVariable(arrayList2);
        c11291.Z$0 = z;
        c11291.label = 2;
    }

    private final void searchOnline(String query, int page, String sortBy, String groupBy, String sortDirection, boolean isCollectionSearch) {
        Job job = this.apiJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.apiJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C11311(query, this, isCollectionSearch, page, groupBy, sortBy, sortDirection, null), 2, null);
    }

    static /* synthetic */ void searchOnline$default(CardSearchViewModel cardSearchViewModel, String str, int i, String str2, String str3, String str4, boolean z, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        cardSearchViewModel.searchOnline(str, i, str2, str3, str4, z);
    }

    public final String getCurrentLanguage() {
        return this.currentLanguage;
    }

    public final MutableLiveData<Boolean> getEmptyResult() {
        return this.emptyResult;
    }

    public final MutableLiveData<List<MTCardGroup>> getGroupedResults() {
        return this.groupedResults;
    }

    public final MutableLiveData<SearchPaginationState> getPaginationState() {
        return this.paginationState;
    }

    public final String getSearchLanguageFilter() {
        return this.searchLanguageFilter;
    }

    public final MutableLiveData<SearchMode> getSearchMode() {
        return this.searchMode;
    }

    public final MutableLiveData<List<MTFullCard>> getSearchResults() {
        return this.searchResults;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x014d, code lost:
    
        if (searchOffline(r12, r14, r9) == r10) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.studiolaganne.lengendarylens.CardSearchViewModel] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchCards(String str, int i, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        SearchMode.Offline offline;
        boolean z4;
        String str5;
        String str6;
        boolean z5;
        ?? r3;
        String str7;
        String str8;
        int i2 = i;
        boolean z6 = z2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i2 == 1) {
                this._mergedResults.clear();
                this.currentQuery = str;
                this.currentSortBy = str2;
                this.currentGroupBy = str3;
                this.currentSortDirection = str4;
                this.currentIsCollectionSearch = z6;
            }
            offline = (!z3 && NetworkHelper.INSTANCE.isNetworkAvailable(this.context)) ? SearchMode.Online.INSTANCE : SearchMode.Offline.INSTANCE;
            ?? r11 = z3 ? 0 : z;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C11282 c11282 = new C11282(offline, i2, null);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = str2;
            anonymousClass1.L$2 = str3;
            anonymousClass1.L$3 = str4;
            anonymousClass1.L$4 = offline;
            anonymousClass1.I$0 = i2;
            z4 = z;
            anonymousClass1.Z$0 = z4;
            anonymousClass1.Z$1 = z6;
            anonymousClass1.Z$2 = z3;
            anonymousClass1.I$1 = r11;
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(main, c11282, anonymousClass1) != coroutine_suspended) {
                str5 = str;
                str6 = str2;
                z5 = z3;
                r3 = r11;
                str7 = str3;
                str8 = str4;
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = anonymousClass1.I$1;
            boolean z7 = anonymousClass1.Z$2;
            boolean z8 = anonymousClass1.Z$1;
            boolean z9 = anonymousClass1.Z$0;
            int i5 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        int i6 = anonymousClass1.I$1;
        boolean z10 = anonymousClass1.Z$2;
        boolean z11 = anonymousClass1.Z$1;
        boolean z12 = anonymousClass1.Z$0;
        int i7 = anonymousClass1.I$0;
        SearchMode searchMode = (SearchMode) anonymousClass1.L$4;
        str8 = (String) anonymousClass1.L$3;
        str7 = (String) anonymousClass1.L$2;
        str6 = (String) anonymousClass1.L$1;
        str5 = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        z4 = z12;
        offline = searchMode;
        z6 = z11;
        r3 = i6;
        z5 = z10;
        i2 = i7;
        if (Intrinsics.areEqual(offline, SearchMode.Online.INSTANCE)) {
            searchOnline(str5, i2, str6, str7, str8, z6);
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(offline, SearchMode.Offline.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        boolean z13 = r3 != 0;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str6);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str7);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str8);
        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(offline);
        anonymousClass1.I$0 = i2;
        anonymousClass1.Z$0 = z4;
        anonymousClass1.Z$1 = z6;
        anonymousClass1.Z$2 = z5;
        anonymousClass1.I$1 = r3;
        anonymousClass1.label = 2;
    }

    public final void setCurrentLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentLanguage = str;
    }

    public final void setSearchLanguageFilter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchLanguageFilter = str;
    }

    public final MTFullCard toMTFullCard(CardRecord cardRecord) {
        Intrinsics.checkNotNullParameter(cardRecord, "<this>");
        String scryfall_id = cardRecord.getScryfall_id();
        String oracle_id = cardRecord.getOracle_id();
        String number = cardRecord.getNumber();
        String en_title = cardRecord.getEn_title();
        String title = cardRecord.getTitle();
        String set = cardRecord.getSet();
        String type_line = cardRecord.getType_line();
        String oracle_text = cardRecord.getOracle_text();
        String mana_cost = cardRecord.getMana_cost();
        return new MTFullCard(null, null, null, null, null, number, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(cardRecord.getFace()), null, null, null, null, null, null, null, null, null, cardRecord.getLang(), null, null, null, null, null, null, mana_cost, null, en_title, oracle_text, oracle_id, null, title, null, null, null, null, 1, null, scryfall_id, set, null, null, null, null, type_line, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -471073315, -5464825, 127, null);
    }
}
