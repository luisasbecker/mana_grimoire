package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.EditCardDialogFragment;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: BrowseListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTFullCardResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1 implements Callback<MTFullCardResponse> {
    final /* synthetic */ EditText $editText;
    final /* synthetic */ BrowseListFragment this$0;

    BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1(BrowseListFragment browseListFragment, EditText editText) {
        this.this$0 = browseListFragment;
        this.$editText = editText;
    }

    static final Unit onFailure$lambda$2(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onResponse$lambda$0$0$0(final BrowseListFragment browseListFragment, MTFullCard mTFullCard, final EditText editText, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
        String cardid;
        String lowerCase;
        String collector_number;
        String condition;
        Boolean altered;
        Boolean signed;
        Boolean missprint;
        Boolean proxy;
        String set_code;
        if (browseListFragment.getActivity() == null || browseListFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        int iIntValue = num != null ? num.intValue() : 1;
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        if (iIntValue >= 1) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iIntValue; i++) {
                MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                if (mTFullCard2 == null || (cardid = mTFullCard2.getCardid()) == null) {
                    cardid = mTFullCard.getCardid();
                }
                mTFullCard3.setCardid(cardid);
                mTFullCard3.setScryfallid(null);
                if (mTFullCard2 == null || (set_code = mTFullCard2.getSet_code()) == null) {
                    String set_code2 = mTFullCard.getSet_code();
                    if (set_code2 != null) {
                        lowerCase = set_code2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    } else {
                        lowerCase = null;
                    }
                } else {
                    lowerCase = set_code.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (lowerCase == null) {
                    }
                }
                mTFullCard3.setSet_code(lowerCase);
                if (mTFullCard2 == null || (collector_number = mTFullCard2.getCollector_number()) == null) {
                    collector_number = mTFullCard.getCollector_number();
                }
                mTFullCard3.setCollector_number(collector_number);
                mTFullCard3.setLang(str == null ? mTFullCard.getLang() : str);
                mTFullCard3.setFinish(str2 == null ? mTFullCard.getFinish() : str2);
                if (str3 == null) {
                    condition = mTFullCard.getCondition();
                    if (condition == null) {
                        condition = GameUtils.CONDITION_NEAR_MINT;
                    }
                } else {
                    condition = str3;
                }
                mTFullCard3.setCondition(condition);
                if (bool == null) {
                    altered = mTFullCard.getAltered();
                    if (altered == null) {
                        altered = false;
                    }
                } else {
                    altered = bool;
                }
                mTFullCard3.setAltered(altered);
                if (bool2 == null) {
                    signed = mTFullCard.getSigned();
                    if (signed == null) {
                        signed = false;
                    }
                } else {
                    signed = bool2;
                }
                mTFullCard3.setSigned(signed);
                if (bool3 == null) {
                    missprint = mTFullCard.getMissprint();
                    if (missprint == null) {
                        missprint = false;
                    }
                } else {
                    missprint = bool3;
                }
                mTFullCard3.setMissprint(missprint);
                if (bool4 == null) {
                    proxy = mTFullCard.getProxy();
                    if (proxy == null) {
                        proxy = false;
                    }
                } else {
                    proxy = bool4;
                }
                mTFullCard3.setProxy(proxy);
                mTFullCard3.setPurchase_price(d);
                arrayList.add(mTFullCard3);
            }
            MTEditCardActions cards = mTEditCardBody.getCards();
            if (cards != null) {
                cards.setAdded(arrayList);
            }
            Context contextRequireContext = browseListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                browseListFragment.getBinding().overlay.setVisibility(0);
                MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), browseListFragment.listId, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, browseListFragment.currentGroupBy, browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, false, null, null, null, mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1$onResponse$1$1$dialog$1$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                            return;
                        }
                        Log.e("BrowseListFragment", "Failed to add MT Card: " + t.getMessage());
                        browseListFragment.getBinding().overlay.setVisibility(8);
                        Toast.makeText(browseListFragment.requireContext(), R.string.error_adding_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (browseListFragment.getActivity() == null || browseListFragment.getContext() == null || browseListFragment._binding == null) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            browseListFragment.getBinding().overlay.setVisibility(8);
                            Toast.makeText(browseListFragment.requireContext(), R.string.error_adding_card, 0).show();
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        if (list != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            BrowseListFragment browseListFragment2 = browseListFragment;
                            EditText editText2 = editText;
                            preferencesManager2.incrementContainerVersion(list.getId());
                            preferencesManager2.incrementCollectionVersion();
                            preferencesManager2.incrementListsVersion();
                            CardContainerCache.INSTANCE.setCachedContainer(list, new CacheKey(list.getId(), browseListFragment2.currentOrderBy, browseListFragment2.currentOrderDirection, browseListFragment2.currentGroupBy, browseListFragment2.currentNameFilter, browseListFragment2.currentScryfallFilter, browseListFragment2.currentPage));
                            browseListFragment2.lastQuery = "";
                            editText2.setText("");
                            browseListFragment2.filtersCollapsed = false;
                            browseListFragment2.updateFilterListFromQuery("");
                            ImageView collapseImageView = browseListFragment2.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                            collapseImageView.setVisibility(8);
                            ConstraintLayout filterSummaryLayout = browseListFragment2.getBinding().filterSummaryLayout;
                            Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                            filterSummaryLayout.setVisibility(8);
                            browseListFragment2.resetAndRefreshList();
                        }
                        browseListFragment.getBinding().overlay.setVisibility(8);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onResponse$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().overlay.setVisibility(8);
        Log.e("BrowseListFragment", "Error fetching card: " + t.getMessage());
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.this$0.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_card_resolved_failure", null);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error: " + t.getMessage());
        String string2 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1.onFailure$lambda$2(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0._binding == null || this.this$0.getContext() == null) {
            return;
        }
        this.this$0.getBinding().overlay.setVisibility(8);
        if (response.isSuccessful()) {
            MTFullCardResponse mTFullCardResponseBody = response.body();
            if (mTFullCardResponseBody != null) {
                final BrowseListFragment browseListFragment = this.this$0;
                final EditText editText = this.$editText;
                final MTFullCard card = mTFullCardResponseBody.getCard();
                if (card != null) {
                    EditCardDialogFragment editCardDialogFragmentBuild = new EditCardDialogFragment.Builder().setCard(card).setAddMode(true).setShowPurchasePrice(true).setAllPrintsLauncher(browseListFragment.allPrintsActivityLauncher).setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function12
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                            return BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1.onResponse$lambda$0$0$0(browseListFragment, card, editText, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
                        }
                    }).build();
                    browseListFragment.currentEditDialog = editCardDialogFragmentBuild;
                    editCardDialogFragmentBuild.show(browseListFragment.getChildFragmentManager(), "edit_card_dialog");
                    return;
                }
                return;
            }
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.this$0.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_card_resolved_error", null);
        this.this$0.getBinding().overlay.setVisibility(8);
        Log.e("BrowseListFragment", "Error fetching card");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Unable to add card");
        String string2 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1.onResponse$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }
}
