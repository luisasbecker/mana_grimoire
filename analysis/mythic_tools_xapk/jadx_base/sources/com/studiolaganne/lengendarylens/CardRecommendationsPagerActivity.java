package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CardRecommendationsPagerActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0017J\b\u0010\u000e\u001a\u00020\nH\u0002J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardRecommendationsPagerActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "newlyAddedOracleIds", "", "", "paginationState", "Lcom/studiolaganne/lengendarylens/PagerPaginationState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "finishWithResult", "addCardToDeck", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "listId", "", "userId", "listType", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardRecommendationsPagerActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final Set<String> newlyAddedOracleIds = new LinkedHashSet();
    private PagerPaginationState paginationState = new PagerPaginationState(0, null, 0, false, null, 0, null, null, null, null, null, null, null, null, null, false, null, 131071, null);

    private final void addCardToDeck(final MTFullCard card, int listId, int userId, final String listType) {
        String lowerCase;
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setCardid(card.getCardid());
        mTFullCard.setScryfallid(null);
        String set_code = card.getSet_code();
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        mTFullCard.setSet_code(lowerCase);
        mTFullCard.setCollector_number(card.getCollector_number());
        mTFullCard.setLang(card.getLang());
        mTFullCard.setFinish(card.getFinish());
        String condition = card.getCondition();
        if (condition == null) {
            condition = GameUtils.CONDITION_NEAR_MINT;
        }
        mTFullCard.setCondition(condition);
        boolean altered = card.getAltered();
        if (altered == null) {
            altered = false;
        }
        mTFullCard.setAltered(altered);
        boolean signed = card.getSigned();
        if (signed == null) {
            signed = false;
        }
        mTFullCard.setSigned(signed);
        boolean missprint = card.getMissprint();
        if (missprint == null) {
            missprint = false;
        }
        mTFullCard.setMissprint(missprint);
        boolean proxy = card.getProxy();
        if (proxy == null) {
            proxy = false;
        }
        mTFullCard.setProxy(proxy);
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        MTEditCardActions mTEditCardActions = new MTEditCardActions(null, null, null, 7, null);
        mTEditCardActions.setAdded(CollectionsKt.mutableListOf(mTFullCard));
        mTEditCardBody.setCards(mTEditCardActions);
        MTApi.editCardsFromList$default(MTApiKt.getMtApi(), userId, listId, null, null, null, null, null, true, null, null, null, mTEditCardBody, 1792, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity.addCardToDeck.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Toast.makeText(this, R.string.error_adding_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                String string;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    Toast.makeText(this, R.string.error_adding_card, 0).show();
                    return;
                }
                String oracleid = card.getOracleid();
                if (oracleid != null) {
                    this.newlyAddedOracleIds.add(oracleid);
                }
                String printed_name = card.getPrinted_name();
                if (printed_name == null && (printed_name = card.getName()) == null) {
                    printed_name = "";
                }
                String str = listType;
                if (Intrinsics.areEqual(str, "maybeboard")) {
                    string = this.getString(R.string.mythic_added_to_maybeboard, new Object[]{printed_name});
                } else {
                    boolean zAreEqual = Intrinsics.areEqual(str, "sideboard");
                    CardRecommendationsPagerActivity cardRecommendationsPagerActivity = this;
                    string = zAreEqual ? cardRecommendationsPagerActivity.getString(R.string.mythic_added_to_sideboard, new Object[]{printed_name}) : cardRecommendationsPagerActivity.getString(R.string.mythic_added_to_deck, new Object[]{printed_name});
                }
                Intrinsics.checkNotNull(string);
                Toast.makeText(this, string, 0).show();
            }
        });
    }

    private final void finishWithResult() {
        Gson gson = new Gson();
        Intent intent = new Intent();
        intent.putExtra("newlyAddedOracleIds", gson.toJson(CollectionsKt.toList(this.newlyAddedOracleIds)));
        intent.putExtra("deckChanged", !this.newlyAddedOracleIds.isEmpty());
        intent.putExtra("categoryKey", this.paginationState.getCategoryKey());
        intent.putExtra("mode", this.paginationState.getMode());
        intent.putExtra("updatedPage", this.paginationState.getCurrentPage());
        intent.putExtra("updatedHasMorePages", this.paginationState.getHasMorePages());
        Integer total = this.paginationState.getTotal();
        intent.putExtra("updatedTotal", total != null ? total.intValue() : -1);
        List<MTFullCard> latestCards = this.paginationState.getLatestCards();
        if (latestCards != null) {
            intent.putExtra("updatedCards", gson.toJson(latestCards));
        }
        setResult(-1, intent);
        finish();
    }

    static final Unit onCreate$lambda$0(final List list, final int i, final String str, final Set set, final CardRecommendationsPagerActivity cardRecommendationsPagerActivity, final int i2, final int i3, final int i4, final int i5, Composer composer, int i6) {
        ComposerKt.sourceInformation(composer, "C157@6809L906,157@6795L920:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i6 & 3) != 2, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1801780970, i6, -1, "com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity.onCreate.<anonymous> (CardRecommendationsPagerActivity.kt:157)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(-2069924930, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivity.onCreate$lambda$0$0(list, i, str, set, cardRecommendationsPagerActivity, i2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(List list, int i, String str, Set set, final CardRecommendationsPagerActivity cardRecommendationsPagerActivity, final int i2, final int i3, final int i4, final int i5, Composer composer, int i6) {
        ComposerKt.sourceInformation(composer, "C164@7180L22,165@7238L445,158@6827L874:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i6 & 3) != 2, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2069924930, i6, -1, "com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity.onCreate.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:158)");
            }
            int iCoerceIn = RangesKt.coerceIn(i, 0, RangesKt.coerceAtLeast(list.size() - 1, 0));
            PagerPaginationState pagerPaginationState = cardRecommendationsPagerActivity.paginationState;
            ComposerKt.sourceInformationMarkerStart(composer, -627987788, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(cardRecommendationsPagerActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivity.onCreate$lambda$0$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627985509, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChanged = composer.changed(i2) | composer.changed(i3) | composer.changed(i4) | composer.changed(i5) | composer.changedInstance(cardRecommendationsPagerActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function2 function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardRecommendationsPagerActivity.onCreate$lambda$0$0$1$0(i2, i3, i4, i5, cardRecommendationsPagerActivity, (MTFullCard) obj, (String) obj2);
                    }
                };
                composer.updateRememberedValue(function2);
                objRememberedValue2 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CardRecommendationsPagerActivityKt.RecommendationsPagerScreen(list, iCoerceIn, str, set, pagerPaginationState, function0, (Function2) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$0(CardRecommendationsPagerActivity cardRecommendationsPagerActivity) {
        cardRecommendationsPagerActivity.finishWithResult();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$0(int i, int i2, int i3, int i4, CardRecommendationsPagerActivity cardRecommendationsPagerActivity, MTFullCard card, String listType) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(listType, "listType");
        if (!Intrinsics.areEqual(listType, "maybeboard")) {
            i = Intrinsics.areEqual(listType, "sideboard") ? i2 : i3;
        }
        if (i > 0 && i4 > 0) {
            cardRecommendationsPagerActivity.addCardToDeck(card, i, i4, listType);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Use onBackPressedDispatcher")
    public void onBackPressed() {
        finishWithResult();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        List listEmptyList;
        Set setEmptySet;
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        try {
            Type type = new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$onCreate$cards$type$1
            }.getType();
            String stringExtra = getIntent().getStringExtra("cards");
            if (stringExtra == null) {
                stringExtra = "";
            }
            listEmptyList = (List) gson.fromJson(stringExtra, type);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
        } catch (Exception e) {
            Log.e("RecsPager", "Failed to parse cards", e);
            listEmptyList = CollectionsKt.emptyList();
        }
        final int intExtra = getIntent().getIntExtra("startIndex", 0);
        int intExtra2 = getIntent().getIntExtra("deckId", -1);
        final int intExtra3 = getIntent().getIntExtra("mainListId", -1);
        final int intExtra4 = getIntent().getIntExtra("sideboardListId", -1);
        final int intExtra5 = getIntent().getIntExtra("maybeboardListId", -1);
        String stringExtra2 = getIntent().getStringExtra("categoryLabel");
        String str = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("categoryKey");
        String str2 = stringExtra3 == null ? "" : stringExtra3;
        int intExtra6 = getIntent().getIntExtra("currentPage", 1);
        boolean booleanExtra = getIntent().getBooleanExtra("hasMorePages", false);
        int intExtra7 = getIntent().getIntExtra("totalCards", -1);
        try {
            Type type2 = new TypeToken<List<? extends String>>() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$onCreate$initialAddedIds$type$1
            }.getType();
            String stringExtra4 = getIntent().getStringExtra("addedCardIds");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            List list = (List) gson.fromJson(stringExtra4, type2);
            if (list == null || (setEmptySet = CollectionsKt.toSet(list)) == null) {
                setEmptySet = SetsKt.emptySet();
            }
        } catch (Exception unused) {
            setEmptySet = SetsKt.emptySet();
        }
        String stringExtra5 = getIntent().getStringExtra("mode");
        if (stringExtra5 == null) {
            stringExtra5 = "recommendations";
        }
        String str3 = stringExtra5;
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        int id = currentUser != null ? currentUser.getId() : -1;
        Integer numValueOf = intExtra7 > 0 ? Integer.valueOf(intExtra7) : null;
        String stringExtra6 = getIntent().getStringExtra("searchScryfall");
        final List list2 = listEmptyList;
        String stringExtra7 = getIntent().getStringExtra("searchName");
        String stringExtra8 = getIntent().getStringExtra("searchOrderBy");
        String stringExtra9 = getIntent().getStringExtra("searchOrderDirection");
        String stringExtra10 = getIntent().getStringExtra("searchSimilarTo");
        String stringExtra11 = getIntent().getStringExtra("searchSimilarMode");
        String stringExtra12 = getIntent().getStringExtra("searchFillGap");
        boolean booleanExtra2 = getIntent().getBooleanExtra("fromCollection", false);
        String stringExtra13 = getIntent().getStringExtra(AndroidContextPlugin.LOCALE_KEY);
        this.paginationState = new PagerPaginationState(intExtra2, str2, intExtra6, booleanExtra, numValueOf, id, null, str3, stringExtra6, stringExtra7, stringExtra8, stringExtra9, stringExtra10, stringExtra11, stringExtra12, booleanExtra2, stringExtra13 == null ? "" : stringExtra13, 64, null);
        final int i = id;
        final Set set = setEmptySet;
        final String str4 = str;
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1801780970, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CardRecommendationsPagerActivity.onCreate$lambda$0(list2, intExtra, str4, set, this, intExtra5, intExtra4, intExtra3, i, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }
}
