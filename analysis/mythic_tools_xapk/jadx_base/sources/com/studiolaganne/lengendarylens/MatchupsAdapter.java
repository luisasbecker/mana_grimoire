package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MatchupsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchupsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "matchups", "", "Lcom/studiolaganne/lengendarylens/MTMatchupStats;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTDeck;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatchupsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_MATCHUP = 1;
    private final MTDeck deck;
    private final List<MTMatchupStats> matchups;
    public static final int $stable = 8;

    public MatchupsAdapter(List<MTMatchupStats> matchups, MTDeck deck) {
        Intrinsics.checkNotNullParameter(matchups, "matchups");
        Intrinsics.checkNotNullParameter(deck, "deck");
        this.matchups = matchups;
        this.deck = deck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(final MatchupViewHolder matchupViewHolder, final String str, MatchupsAdapter matchupsAdapter, final RecyclerView.ViewHolder viewHolder, CardRecord cardRecord) {
        if (cardRecord != null) {
            matchupViewHolder.getMatchupName().setText(cardRecord.getTitle());
            CardImageCache cardImageCache = CardImageCache.INSTANCE;
            Context context = matchupViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            String imageUrl = cardImageCache.getImageUrl(context, str, 0);
            if (imageUrl != null) {
                matchupViewHolder.getDeckImage().setImageUrl(imageUrl);
                matchupViewHolder.getDeckImage().setAutoLoad(false);
                matchupViewHolder.getDeckImage().loadSingleImage(imageUrl);
            } else {
                MTApiKt.getMtApi().getCardByScryfallId(str).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.MatchupsAdapter$onBindViewHolder$1$1$1$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            MTCardResponse mTCardResponseBody = response.body();
                            MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                            String imageUrl2 = card != null ? card.getImageUrl(0) : null;
                            String str2 = imageUrl2;
                            if (str2 == null || str2.length() == 0) {
                                return;
                            }
                            CardImageCache cardImageCache2 = CardImageCache.INSTANCE;
                            Context context2 = viewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                            cardImageCache2.saveImageUrl(context2, str, imageUrl2, 0);
                            matchupViewHolder.getDeckImage().setImageUrl(imageUrl2);
                            matchupViewHolder.getDeckImage().setAutoLoad(false);
                            matchupViewHolder.getDeckImage().loadSingleImage(imageUrl2);
                        }
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.matchups.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MatchupViewHolder matchupViewHolder = (MatchupViewHolder) holder;
        MTMatchupStats mTMatchupStats = this.matchups.get(position);
        matchupViewHolder.getInnerLayout().setClipToOutline(true);
        matchupViewHolder.getInnerLayout().setClipChildren(true);
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context context = matchupViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final String firstPrintScryfallId = companion.getInstance(context).getFirstPrintScryfallId(mTMatchupStats.getOracleid(), 0);
        if (firstPrintScryfallId != null) {
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context context2 = matchupViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            companion2.getCard(context2, firstPrintScryfallId, 0, new Function1() { // from class: com.studiolaganne.lengendarylens.MatchupsAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MatchupsAdapter.onBindViewHolder$lambda$0$0(matchupViewHolder, firstPrintScryfallId, this, holder, (CardRecord) obj);
                }
            });
        }
        if (mTMatchupStats.getGames() <= 0) {
            matchupViewHolder.getWinrateValue().setText("--");
            matchupViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(matchupViewHolder.getWinrateValue().getContext(), R.color.text_color));
            matchupViewHolder.getGamesValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            matchupViewHolder.getWinsValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            matchupViewHolder.getLossesValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            matchupViewHolder.getDrawsValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            matchupViewHolder.getGamesLabel().setText(matchupViewHolder.itemView.getResources().getString(R.string.games_singular));
            return;
        }
        float f = Float.parseFloat(mTMatchupStats.getRate());
        if (Math.abs(f) <= Float.MAX_VALUE) {
            matchupViewHolder.getWinrateValue().setText(MathKt.roundToInt(f) + "%");
            TextView winrateValue = matchupViewHolder.getWinrateValue();
            GameUtils companion3 = GameUtils.INSTANCE.getInstance();
            Context context3 = matchupViewHolder.getWinrateValue().getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            winrateValue.setTextColor(companion3.getWinRateColor(context3, Float.parseFloat(mTMatchupStats.getRate()), Integer.valueOf(this.deck.getFormatid())));
        } else {
            matchupViewHolder.getWinrateValue().setText("--");
            matchupViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(matchupViewHolder.getWinrateValue().getContext(), R.color.text_color));
        }
        matchupViewHolder.getGamesValue().setText(String.valueOf(mTMatchupStats.getGames()));
        matchupViewHolder.getWinsValue().setText(String.valueOf(mTMatchupStats.getWins()));
        matchupViewHolder.getLossesValue().setText(String.valueOf(mTMatchupStats.getLosses()));
        matchupViewHolder.getDrawsValue().setText(String.valueOf(mTMatchupStats.getDraws()));
        if (mTMatchupStats.getGames() == 1) {
            matchupViewHolder.getGamesLabel().setText(matchupViewHolder.itemView.getResources().getString(R.string.games_singular));
        } else {
            matchupViewHolder.getGamesLabel().setText(matchupViewHolder.itemView.getResources().getString(R.string.games_plural));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.matchup_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new MatchupViewHolder(viewInflate);
    }
}
