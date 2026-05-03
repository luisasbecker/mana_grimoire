package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: DeckTokensActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010 \u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010 \u001a\u00020\bH\u0016J \u0010\"\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010 \u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckTokensActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "<init>", "()V", "deckId", "", "deckName", "", "tokens", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "tokensAdapter", "Lcom/studiolaganne/lengendarylens/MTFullCardsAdapter;", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "cardActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "fetchTokens", "updateTokensList", "onMTFullCardClick", "card", FirebaseAnalytics.Param.INDEX, "onCardLongPress", "position", "onCardSelectionToggle", "onQuantityChange", "newQuantity", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckTokensActivity extends BaseActivity implements OnMTFullCardClickListener, OnCardLongPressListener, OnCardSelectionListener {
    public static final int $stable = 8;
    private MTFullCardsAdapter tokensAdapter;
    private int deckId = -1;
    private String deckName = "";
    private List<MTFullCard> tokens = new ArrayList();
    private final List<CardSet> cardSets = CardSetsManager.INSTANCE.getCardSets();
    private final ActivityResultLauncher<Intent> cardActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckTokensActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "result");
        }
    });

    private final void fetchTokens() {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            finish();
            return;
        }
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().getDeckTokens(currentUser.getId(), this.deckId).enqueue(new Callback<MTDeckTokensResponse>() { // from class: com.studiolaganne.lengendarylens.DeckTokensActivity.fetchTokens.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTDeckTokensResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckTokensActivity.this.isFinishing() || DeckTokensActivity.this.isDestroyed()) {
                    return;
                }
                constraintLayout.setVisibility(8);
                Toast.makeText(DeckTokensActivity.this, R.string.server_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTDeckTokensResponse> call, Response<MTDeckTokensResponse> response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckTokensActivity.this.isFinishing() || DeckTokensActivity.this.isDestroyed()) {
                    return;
                }
                constraintLayout.setVisibility(8);
                if (!response.isSuccessful()) {
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    if (responseBodyErrorBody != null) {
                        responseBodyErrorBody.string();
                    }
                    Toast.makeText(DeckTokensActivity.this, R.string.server_error, 0).show();
                    return;
                }
                MTDeckTokensResponse mTDeckTokensResponseBody = response.body();
                List<MTFullCard> tokens = mTDeckTokensResponseBody != null ? mTDeckTokensResponseBody.getTokens() : null;
                DeckTokensActivity deckTokensActivity = DeckTokensActivity.this;
                if (tokens != null) {
                    deckTokensActivity.tokens = CollectionsKt.toMutableList((Collection) tokens);
                    deckTokensActivity.updateTokensList();
                } else {
                    deckTokensActivity.tokens = new ArrayList();
                    deckTokensActivity.updateTokensList();
                }
            }
        });
    }

    static final Unit onCreate$lambda$0(DeckTokensActivity deckTokensActivity) {
        deckTokensActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTokensList() {
        View viewFindViewById = findViewById(R.id.tokensRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        if (this.tokens.isEmpty()) {
            MTFullCardsAdapter mTFullCardsAdapter = this.tokensAdapter;
            if (mTFullCardsAdapter != null) {
                mTFullCardsAdapter.updateItems(CollectionsKt.emptyList());
                return;
            }
            return;
        }
        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.tokens);
        MTFullCardsAdapter mTFullCardsAdapter2 = this.tokensAdapter;
        if (mTFullCardsAdapter2 != null) {
            mTFullCardsAdapter2.updateItems(browseListCardItemsFromCards);
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

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_tokens);
        this.deckId = getIntent().getIntExtra("deckId", -1);
        String stringExtra = getIntent().getStringExtra("deckName");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.deckName = stringExtra;
        if (this.deckId == -1) {
            finish();
            return;
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckTokensActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckTokensActivity.onCreate$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.titleLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        if (this.deckName.length() > 0) {
            string = this.deckName + " " + getString(R.string.tokens);
        } else {
            string = getString(R.string.tokens);
            Intrinsics.checkNotNull(string);
        }
        textView.setText(string);
        View viewFindViewById3 = findViewById(R.id.tokensRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        MTFullCardsAdapter mTFullCardsAdapter = new MTFullCardsAdapter(CollectionsKt.emptyList(), -1, this.cardSets, false, this, this, this, null, null, 384, null);
        this.tokensAdapter = mTFullCardsAdapter;
        recyclerView.setAdapter(mTFullCardsAdapter);
        fetchTokens();
    }

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(MTFullCard card, int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("token_click_from_deck_tokens");
        DeckTokensActivity deckTokensActivity = this;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(deckTokensActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("token_click_from_deck_tokens", null);
        String json = new Gson().toJson(card);
        Intent intent = new Intent(deckTokensActivity, (Class<?>) CardActivity.class);
        intent.putExtra("singleMTCard", json);
        intent.putExtra("lang", card.getLang());
        intent.putExtra("enTitle", card.getName());
        intent.putExtra(OptionalModuleUtils.FACE, card.getFace());
        intent.putExtra("localizedTypeLine", card.getType_line());
        intent.putExtra("localizedTitle", card.getPrinted_name());
        intent.putExtra("localizedOracle", card.getOracle_text());
        CardDataStore.INSTANCE.setMtCardList(this.tokens);
        intent.putExtra("hasMTCards", true);
        intent.putExtra("currentMTIndex", index);
        intent.putExtra("mtCardListId", -1);
        intent.putExtra("readOnly", true);
        this.cardActivityLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
        Intrinsics.checkNotNullParameter(card, "card");
    }
}
