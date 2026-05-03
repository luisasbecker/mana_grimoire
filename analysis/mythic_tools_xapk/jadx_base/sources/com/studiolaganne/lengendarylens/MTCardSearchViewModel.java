package com.studiolaganne.lengendarylens;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: compiled from: MTCardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0019H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "searchResults", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "getSearchResults", "()Landroidx/lifecycle/MutableLiveData;", "emptyResult", "", "getEmptyResult", "searchJob", "Lkotlinx/coroutines/Job;", "performSearch", "", SearchIntents.EXTRA_QUERY, "", "searchType", "Lcom/studiolaganne/lengendarylens/MTCardSearchType;", "formatId", "", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardSearchType;Ljava/lang/Integer;)V", "toMTGCardRecord", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardSearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private Job searchJob;
    private final MutableLiveData<List<MTGCardRecord>> searchResults = new MutableLiveData<>();
    private final MutableLiveData<Boolean> emptyResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardSearchViewModel$performSearch$1, reason: invalid class name */
    /* JADX INFO: compiled from: MTCardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardSearchViewModel$performSearch$1", f = "MTCardSearchViewModel.kt", i = {0, 0, 0, 0}, l = {57}, m = "invokeSuspend", n = {NotificationCompat.CATEGORY_CALL, "response", "cards", "records"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $formatId;
        final /* synthetic */ String $query;
        final /* synthetic */ MTCardSearchType $searchType;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MTCardSearchViewModel this$0;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardSearchViewModel$performSearch$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MTCardSearchViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.MTCardSearchViewModel$performSearch$1$1", f = "MTCardSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<MTGCardRecord> $records;
            int label;
            final /* synthetic */ MTCardSearchViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02091(MTCardSearchViewModel mTCardSearchViewModel, List<MTGCardRecord> list, Continuation<? super C02091> continuation) {
                super(2, continuation);
                this.this$0 = mTCardSearchViewModel;
                this.$records = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02091(this.this$0, this.$records, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getSearchResults().postValue(this.$records);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.MTCardSearchViewModel$performSearch$1$WhenMappings */
        /* JADX INFO: compiled from: MTCardSearchViewModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MTCardSearchType.values().length];
                try {
                    iArr[MTCardSearchType.COMMANDER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MTCardSearchType.PARTNER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MTCardSearchType.SIGNATURE_SPELL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MTCardSearchType.PLAYMAT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MTCardSearchType mTCardSearchType, String str, Integer num, MTCardSearchViewModel mTCardSearchViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$searchType = mTCardSearchType;
            this.$query = str;
            this.$formatId = num;
            this.this$0 = mTCardSearchViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$searchType, this.$query, this.$formatId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Call<MTCardsResponse> callSearchCommanders;
            List<MTFullCard> listEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i2 = WhenMappings.$EnumSwitchMapping$0[this.$searchType.ordinal()];
                    if (i2 == 1) {
                        callSearchCommanders = MTApiKt.getMtApi().searchCommanders(this.$query, this.$formatId);
                    } else if (i2 == 2) {
                        callSearchCommanders = MTApiKt.getMtApi().searchPartners(this.$query, this.$formatId);
                    } else if (i2 == 3) {
                        callSearchCommanders = MTApiKt.getMtApi().searchSignatureSpells(this.$query, this.$formatId);
                    } else {
                        if (i2 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        callSearchCommanders = MTApi.searchCards$default(MTApiKt.getMtApi(), null, this.$query, null, null, null, null, null, null, null, null, null, null, null, null, 16381, null);
                    }
                    Response<MTCardsResponse> responseExecute = callSearchCommanders.execute();
                    if (responseExecute.isSuccessful()) {
                        MTCardsResponse mTCardsResponseBody = responseExecute.body();
                        if (mTCardsResponseBody == null || (listEmptyList = mTCardsResponseBody.getCards()) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        if (listEmptyList.isEmpty()) {
                            this.this$0.getEmptyResult().postValue(Boxing.boxBoolean(true));
                        } else {
                            List<MTFullCard> list = listEmptyList;
                            MTCardSearchViewModel mTCardSearchViewModel = this.this$0;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(mTCardSearchViewModel.toMTGCardRecord((MTFullCard) it.next()));
                            }
                            ArrayList arrayList2 = arrayList;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(callSearchCommanders);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseExecute);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            this.label = 1;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new C02091(this.this$0, arrayList2, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        ResponseBody responseBodyErrorBody = responseExecute.errorBody();
                        Log.e("MTCardSearch", "Error: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                        this.this$0.getEmptyResult().postValue(Boxing.boxBoolean(true));
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Log.e("MTCardSearch", "Error fetching search results", e);
                this.this$0.getEmptyResult().postValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void performSearch$default(MTCardSearchViewModel mTCardSearchViewModel, String str, MTCardSearchType mTCardSearchType, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        mTCardSearchViewModel.performSearch(str, mTCardSearchType, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MTGCardRecord toMTGCardRecord(MTFullCard mTFullCard) {
        Integer face_index = mTFullCard.getFace_index();
        int iIntValue = face_index != null ? face_index.intValue() : 0;
        String oracleid = mTFullCard.getOracleid();
        String str = oracleid == null ? "" : oracleid;
        String printed_name = mTFullCard.getPrinted_name();
        String str2 = (printed_name == null && (printed_name = mTFullCard.getName()) == null) ? "" : printed_name;
        String type_line = mTFullCard.getType_line();
        String oracle_text = mTFullCard.getOracle_text();
        String str3 = oracle_text == null ? "" : oracle_text;
        String lang = mTFullCard.getLang();
        if (lang == null) {
            lang = "en";
        }
        String str4 = lang;
        String scryfallid = mTFullCard.getScryfallid();
        String str5 = scryfallid == null ? "" : scryfallid;
        String cardid = mTFullCard.getCardid();
        return new MTGCardRecord(str, iIntValue, str2, type_line, str3, str4, null, str5, cardid == null ? "" : cardid, mTFullCard.getPreviewUrl(iIntValue), mTFullCard.getArtCropUrl(iIntValue).length() > 0);
    }

    public final MutableLiveData<Boolean> getEmptyResult() {
        return this.emptyResult;
    }

    public final MutableLiveData<List<MTGCardRecord>> getSearchResults() {
        return this.searchResults;
    }

    public final void performSearch(String query, MTCardSearchType searchType, Integer formatId) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(searchType, query, formatId, this, null), 2, null);
    }
}
